package com.poc.ilovegithubweb.interfaces.web;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poc.ilovegithubweb.application.MailFacade;
import com.poc.ilovegithubweb.application.RankFacade;
import com.poc.ilovegithubweb.application.SearchFacade;
import com.poc.ilovegithubweb.config.auth.dto.SessionUser;
import com.poc.ilovegithubweb.domain.rank.org.OrgRankInfo;
import com.poc.ilovegithubweb.domain.rank.user.UserRankInfo;
import com.poc.ilovegithubweb.domain.search.SearchCommand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

	private final HttpSession httpSession;
	private final RankFacade rankFacade;

	private final MailFacade mailFacade;
	private final SearchFacade searchFacade;

	@GetMapping
	public String viewHome(Model model, HttpServletRequest request) {
		Pageable pageable = PageRequest.of(0, 30, Sort.by("StargazersCount").descending());
		String login = sessionCheck(model);
		searchFacade.insertSearchResult(SearchCommand.builder().menu("Home")
			.ip(request.getRemoteAddr()).login(login).build());

		Page<UserRankInfo> userRankInfo = rankFacade.getGlobalUserRank("All", pageable);
		model.addAttribute("userRanks", userRankInfo);

		Page<OrgRankInfo> orgRankInfo = rankFacade.getGlobalOrgRank("All", pageable);
		model.addAttribute("orgRanks", orgRankInfo);

		return "index";
	}

	@GetMapping("/login/noticeMail")
	public String testSendEmail() throws MessagingException {
		String email = "seaking7@gmail.com";

		mailFacade.sendWelcomeMail(email);
		return "redirect:/";
	}

	@RequestMapping("/error-page/404")
	public String errorPage404(Model model) {
		sessionCheck(model);
		return "login/404";
	}

	@RequestMapping("/error-page/500")
	public String errorPage500(Model model) {
		sessionCheck(model);
		return "login/500";
	}

	private String sessionCheck(Model model) {
		SessionUser login_user = (SessionUser)httpSession.getAttribute("login_user");
		if (login_user != null) {
			model.addAttribute("login_session", login_user);
			return login_user.getLogin();
		}
		return "";
	}
}
