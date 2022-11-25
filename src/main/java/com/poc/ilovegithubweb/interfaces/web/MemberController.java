package com.poc.ilovegithubweb.interfaces.web;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poc.ilovegithubweb.application.BoardFacade;
import com.poc.ilovegithubweb.application.RankFacade;
import com.poc.ilovegithubweb.config.auth.dto.SessionUser;
import com.poc.ilovegithubweb.domain.board.QuestionCommand;
import com.poc.ilovegithubweb.domain.rank.member.MemberRankInfo;
import com.poc.ilovegithubweb.domain.rank.search.SearchRankInfo;
import com.poc.ilovegithubweb.domain.rank.source.SourceRankInfo;
import com.poc.ilovegithubweb.interfaces.web.form.QuestionForm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	private final HttpSession httpSession;
	private final RankFacade rankFacade;
	private final BoardFacade boardFacade;

	@GetMapping("/user")
	public String memberUserRank(Model model,
		@RequestParam(required = false, defaultValue = "30") int size,
		@RequestParam(required = false, defaultValue = "0") int page,
		@RequestParam(required = false, defaultValue = "All") String languageBy,
		@RequestParam(required = false, defaultValue = "StargazersCount") String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());

		sessionCheck(model);

		Page<MemberRankInfo> rankInfo = rankFacade.getMemberRank(languageBy, pageable);
		model.addAttribute("userRanks", rankInfo);
		model.addAttribute("var_languageBy", languageBy);
		model.addAttribute("var_sortBy", sortBy);

		return "member/userRank";
	}

	@GetMapping("/searchRank")
	public String getSearchRank(Model model,
		@RequestParam(required = false, defaultValue = "30") int size,
		@RequestParam(required = false, defaultValue = "0") int page,
		@RequestParam(required = false, defaultValue = "All") String languageBy,
		@RequestParam(required = false, defaultValue = "SearchCount") String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
		sessionCheck(model);

		Page<SearchRankInfo> rankInfo = rankFacade.getSearchRank(languageBy, pageable);
		model.addAttribute("userRanks", rankInfo);
		model.addAttribute("var_languageBy", languageBy);
		model.addAttribute("var_sortBy", sortBy);

		return "member/searchRank";
	}

	@GetMapping("/source")
	public String memberSourceRank(Model model,
		@RequestParam(required = false, defaultValue = "30") int size,
		@RequestParam(required = false, defaultValue = "0") int page,
		@RequestParam(required = false, defaultValue = "All") String languageBy,
		@RequestParam(required = false, defaultValue = "StargazersCount") String sortBy) {

		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());

		sessionCheck(model);

		Page<SourceRankInfo> rankInfo = rankFacade.getKoreanSourceRank(languageBy, pageable);
		model.addAttribute("userRanks", rankInfo);
		model.addAttribute("var_languageBy", languageBy);
		model.addAttribute("var_sortBy", sortBy);

		return "koreanRank/sourceRank";
	}

	@GetMapping("/question")       //문의 및 건의사항
	public String question(Model model) {
		sessionCheck(model);
		return "member/question";
	}

	@PostMapping("/question")       //문의 및 건의사항
	public String postQuestion(QuestionForm form, Model model) {

		sessionCheck(model);
		QuestionCommand questionCommand = form.toCommand();
		Long savedId = boardFacade.saveQuestion(questionCommand);
		model.addAttribute("saved_Id", savedId);

		log.info("question id:{}, login:{}, name:{}, contentType:{}, content:{}", savedId, form.getLogin(),
			form.getName(), form.getContentType(), form.getContent());
		return "member/question";
	}

	private void sessionCheck(Model model) {
		SessionUser loginUser = (SessionUser)httpSession.getAttribute("login_user");
		if (loginUser != null) {
			model.addAttribute("login_session", loginUser);
		}
	}
}
