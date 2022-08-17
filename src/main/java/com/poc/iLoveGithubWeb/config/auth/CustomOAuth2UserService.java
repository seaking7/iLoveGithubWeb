package com.poc.iLoveGithubWeb.config.auth;

import com.google.gson.Gson;
import com.poc.iLoveGithubWeb.config.auth.dto.OAuthAttributes;
import com.poc.iLoveGithubWeb.config.auth.dto.SessionUser;
import com.poc.iLoveGithubWeb.domain.member.Member;
import com.poc.iLoveGithubWeb.domain.member.MemberHistory;
import com.poc.iLoveGithubWeb.infrastructure.member.MemberHistoryRepository;
import com.poc.iLoveGithubWeb.infrastructure.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final Logger reportLogger = LoggerFactory.getLogger("logReportFile");
    private final MemberRepository memberRepository;
    private final MemberHistoryRepository memberHistoryRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);
        log.info("loadUser== {}", oAuth2User.toString());

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        log.info("registrationId :{}, userNameAttributeName:{}", registrationId, userNameAttributeName);
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Member member = saveOrUpdate(attributes);
        httpSession.setAttribute("login_user", new SessionUser(member));

//        log.info(httpSession.getId())

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }


    private Member saveOrUpdate(OAuthAttributes attributes) {
        MemberHistory memberHistory = attributes.toHistoryEntity();
        memberHistoryRepository.save(memberHistory);

        Member member = memberRepository.findByLogin(attributes.getLogin())
                .map(entity -> entity.update(attributes))
                .orElse(attributes.toEntity());

        Gson gson = new Gson();
        reportLogger.info(gson.toJson(member));
        return memberRepository.save(member);
    }
}
