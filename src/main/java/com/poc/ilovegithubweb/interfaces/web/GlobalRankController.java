package com.poc.ilovegithubweb.interfaces.web;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.poc.ilovegithubweb.application.RankFacade;
import com.poc.ilovegithubweb.application.SearchFacade;
import com.poc.ilovegithubweb.config.auth.dto.SessionUser;
import com.poc.ilovegithubweb.domain.rank.org.OrgRankInfo;
import com.poc.ilovegithubweb.domain.rank.source.SourceRankInfo;
import com.poc.ilovegithubweb.domain.rank.user.UserRankInfo;
import com.poc.ilovegithubweb.domain.search.SearchCommand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/global")
public class GlobalRankController {

	private final HttpSession httpSession;
	private final RankFacade rankFacade;
	private final SearchFacade searchFacade;

	@GetMapping("/user")
	public String globalUserRank(Model model,
		@RequestParam(required = false, defaultValue = "0") int page,
		@RequestParam(required = false, defaultValue = "30") int size,
		@RequestParam(required = false, defaultValue = "All") String languageBy,
		@RequestParam(required = false, defaultValue = "StargazersCount") String sortBy,
		HttpServletRequest request) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());

		String login = sessionCheck(model);
		searchFacade.insertSearchResult(SearchCommand.builder()
			.menu("globalUser")
			.page(page)
			.size(size)
			.languageBy(languageBy)
			.sortBy(sortBy)
			.ip(request.getRemoteAddr())
			.login(login)
			.build());

		Page<UserRankInfo> rankInfo = rankFacade.getGlobalUserRank(languageBy, pageable);
		model.addAttribute("userRanks", rankInfo);
		model.addAttribute("var_languageBy", languageBy);
		model.addAttribute("var_sortBy", sortBy);

		return "globalRank/userRank";
	}

	@GetMapping("/organization")
	public String globalOrgRank(Model model,
		@RequestParam(required = false, defaultValue = "30") int size,
		@RequestParam(required = false, defaultValue = "0") int page,
		@RequestParam(required = false, defaultValue = "All") String languageBy,
		@RequestParam(required = false, defaultValue = "StargazersCount") String sortBy,
		HttpServletRequest request) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());

		String login = sessionCheck(model);
		searchFacade.insertSearchResult(SearchCommand.builder()
			.menu("globalOrg")
			.page(page)
			.size(size)
			.languageBy(languageBy)
			.sortBy(sortBy)
			.ip(request.getRemoteAddr())
			.login(login)
			.build());

		Page<OrgRankInfo> rankInfo = rankFacade.getGlobalOrgRank(languageBy, pageable);
		model.addAttribute("userRanks", rankInfo);
		model.addAttribute("var_languageBy", languageBy);
		model.addAttribute("var_sortBy", sortBy);

		return "globalRank/orgRank";
	}

	@GetMapping("/source")
	public String globalSourceRank(Model model,
		@RequestParam(required = false, defaultValue = "30") int size,
		@RequestParam(required = false, defaultValue = "0") int page,
		@RequestParam(required = false, defaultValue = "All") String languageBy,
		@RequestParam(required = false, defaultValue = "StargazersCount") String sortBy,
		HttpServletRequest request) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());

		String login = sessionCheck(model);
		searchFacade.insertSearchResult(SearchCommand.builder()
			.menu("globalSource")
			.page(page)
			.size(size)
			.languageBy(languageBy)
			.sortBy(sortBy)
			.ip(request.getRemoteAddr())
			.login(login)
			.build());

		Page<SourceRankInfo> rankInfo = rankFacade.getSourceRankIndex(languageBy, pageable);
		model.addAttribute("userRanks", rankInfo);
		model.addAttribute("var_languageBy", languageBy);
		model.addAttribute("var_sortBy", sortBy);

		return "globalRank/sourceRank";
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
