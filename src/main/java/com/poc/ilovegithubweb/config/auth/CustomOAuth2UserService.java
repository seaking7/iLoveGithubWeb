package com.poc.ilovegithubweb.config.auth;

import java.util.Collections;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.poc.ilovegithubweb.config.auth.dto.OAuthAttributes;
import com.poc.ilovegithubweb.config.auth.dto.SessionUser;
import com.poc.ilovegithubweb.domain.mail.MailService;
import com.poc.ilovegithubweb.domain.member.Member;
import com.poc.ilovegithubweb.domain.member.MemberHistory;
import com.poc.ilovegithubweb.infrastructure.member.MemberHistoryRepository;
import com.poc.ilovegithubweb.infrastructure.member.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

	private final Logger reportLogger = LoggerFactory.getLogger("logReportFile");
	private final MemberRepository memberRepository;
	private final MemberHistoryRepository memberHistoryRepository;
	private final HttpSession httpSession;

	private final MailService mailService;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		log.info("loadUser== {}", oAuth2User.toString());

		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
			.getUserInfoEndpoint().getUserNameAttributeName();

		log.info("registrationId :{}, userNameAttributeName:{}", registrationId, userNameAttributeName);
		OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName,
			oAuth2User.getAttributes());

		Member member = oauthLoginProcess(attributes);
		httpSession.setAttribute("login_user", new SessionUser(member));

		//        log.info(httpSession.getId())

		return new DefaultOAuth2User(
			Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
			attributes.getAttributes(),
			attributes.getNameAttributeKey());
	}

	private Member oauthLoginProcess(OAuthAttributes attributes) {
		insertLoginHistory(attributes);

		Member member;
		Optional<Member> byLogin = memberRepository.findByLogin(attributes.getLogin());
		if (byLogin.isEmpty()) {
			member = attributes.toEntity();
			sendWelcomeMail(member);
		} else {
			member = byLogin.map(entity -> entity.update(attributes)).get();
		}

		Gson gson = new Gson();
		reportLogger.info(gson.toJson(member));
		return memberRepository.save(member);
	}

	private void insertLoginHistory(OAuthAttributes attributes) {
		MemberHistory memberHistory = attributes.toHistoryEntity();
		memberHistoryRepository.save(memberHistory);
	}

	private void sendWelcomeMail(Member member) {

		String toMail = member.getEmail();
		String emailPatterns =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		if (toMail != null && toMail.matches(emailPatterns)) {
			try {
				mailService.sendWelcomeMail(member.getEmail());
			} catch (MessagingException e) {
				log.info("mail 발송 실패" + e.getMessage());
			}
		}
	}
}
