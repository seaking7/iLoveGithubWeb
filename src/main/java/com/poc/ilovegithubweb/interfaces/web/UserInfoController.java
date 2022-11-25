package com.poc.ilovegithubweb.interfaces.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poc.ilovegithubweb.application.SearchFacade;
import com.poc.ilovegithubweb.application.UserInfoFacade;
import com.poc.ilovegithubweb.config.auth.dto.SessionUser;
import com.poc.ilovegithubweb.domain.search.SearchCommand;
import com.poc.ilovegithubweb.domain.user.UserDetailInfo;
import com.poc.ilovegithubweb.domain.user.UserRepoInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserInfoController {

	private final HttpSession httpSession;
	private final UserInfoFacade userInfoFacade;
	private final SearchFacade searchFacade;

	@GetMapping("/id/{id}")
	public String detailUserById(@PathVariable int id, Model model, HttpServletRequest request) {
		String login = sessionCheck(model);
		searchFacade.insertSearchResult(SearchCommand.builder().menu("detailUserById")
			.ip(request.getRemoteAddr()).login(login).searchId(id).build());

		UserDetailInfo userDetailInfo = userInfoFacade.getUserRankIndex(id);
		log.info("userinfo =={}", userDetailInfo.toString());
		model.addAttribute("userInfo", userDetailInfo);

		List<UserRepoInfo> userRepoInfoList = userInfoFacade.getUserRepoList(id);
		model.addAttribute("userRepoList", userRepoInfoList);
		return "user/userDetail";
	}

	@GetMapping("/login")
	public String detailUserByLogin(@RequestParam String inputLogin, Model model, HttpServletRequest request) {
		String login = sessionCheck(model);
		searchFacade.insertSearchResult(SearchCommand.builder().menu("detailUserByLogin")
			.ip(request.getRemoteAddr()).login(login).searchLogin(inputLogin).build());

		UserDetailInfo userDetailInfo = userInfoFacade.getUserRankByLogin(inputLogin);
		log.info("userinfo =={}", userDetailInfo.toString());
		model.addAttribute("userInfo", userDetailInfo);

		List<UserRepoInfo> userRepoInfoList = userInfoFacade.getUserRepoListByLogin(inputLogin);
		model.addAttribute("userRepoList", userRepoInfoList);
		return "user/userDetail";
	}

	private String sessionCheck(Model model) {
		SessionUser loginUser = (SessionUser)httpSession.getAttribute("login_user");
		if (loginUser != null) {
			model.addAttribute("login_session", loginUser);
			return loginUser.getLogin();
		}
		return "";
	}

}
