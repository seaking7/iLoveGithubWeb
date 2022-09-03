package com.poc.iLoveGithubWeb.interfaces.web;


import com.poc.iLoveGithubWeb.application.RankFacade;
import com.poc.iLoveGithubWeb.application.SearchFacade;
import com.poc.iLoveGithubWeb.config.auth.dto.SessionUser;
import com.poc.iLoveGithubWeb.domain.rank.org.OrgRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.source.SourceRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.user.UserRankInfo;
import com.poc.iLoveGithubWeb.domain.search.SearchCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/korean")
public class KoreanRankController {

    private final HttpSession httpSession;
    private final RankFacade rankFacade;
    private final SearchFacade searchFacade;


    @GetMapping("/user")
    public String koreanUserRank(Model model,
                                 @RequestParam(required = false, defaultValue = "30") int size,
                                 @RequestParam(required = false, defaultValue = "0")  int page,
                                 @RequestParam(required = false, defaultValue = "All") String languageBy,
                                 @RequestParam(required = false, defaultValue = "StargazersCount") String sortBy,
                                 HttpServletRequest request){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());

        String login = sessionCheck(model);
        searchFacade.insertSearchResult(SearchCommand.builder().menu("koreanUser")
                .page(page).size(size).languageBy(languageBy).sortBy(sortBy).ip(request.getRemoteAddr()).login(login).build());

        Page<UserRankInfo> rankInfo = rankFacade.getKoreanUserRank(languageBy, pageable);
        model.addAttribute("userRanks", rankInfo);
        model.addAttribute("var_languageBy", languageBy);
        model.addAttribute("var_sortBy", sortBy);

        return "koreanRank/userRank";
    }

    @GetMapping("/organization")
    public String koreanOrgRank(Model model,
                                @RequestParam(required = false, defaultValue = "30") int size,
                                @RequestParam(required = false, defaultValue = "0")  int page,
                                @RequestParam(required = false, defaultValue = "All") String languageBy,
                                @RequestParam(required = false, defaultValue = "StargazersCount") String sortBy,
                                HttpServletRequest request){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        String login = sessionCheck(model);
        searchFacade.insertSearchResult(SearchCommand.builder().menu("koreanOrg")
                .page(page).size(size).languageBy(languageBy).sortBy(sortBy).ip(request.getRemoteAddr()).login(login).build());

        Page<OrgRankInfo> rankInfo = rankFacade.getKoreanOrgRank(languageBy, pageable);
        model.addAttribute("userRanks", rankInfo);
        model.addAttribute("var_languageBy", languageBy);
        model.addAttribute("var_sortBy", sortBy);

        return "koreanRank/orgRank";
    }

    @GetMapping("/source")
    public String koreanSourceRank(Model model,
                                   @RequestParam(required = false, defaultValue = "30") int size,
                                   @RequestParam(required = false, defaultValue = "0")  int page,
                                   @RequestParam(required = false, defaultValue = "All") String languageBy,
                                   @RequestParam(required = false, defaultValue = "StargazersCount") String sortBy,
                                   HttpServletRequest request){

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());

        String login = sessionCheck(model);
        searchFacade.insertSearchResult(SearchCommand.builder().menu("koreanSource")
                .page(page).size(size).languageBy(languageBy).sortBy(sortBy).ip(request.getRemoteAddr()).login(login).build());

        Page<SourceRankInfo> rankInfo = rankFacade.getKoreanSourceRank(languageBy, pageable);
        model.addAttribute("userRanks", rankInfo);
        model.addAttribute("var_languageBy", languageBy);
        model.addAttribute("var_sortBy", sortBy);

        return "koreanRank/sourceRank";
    }

    private String sessionCheck(Model model) {
        SessionUser login_user = (SessionUser) httpSession.getAttribute("login_user");
        if(login_user != null){
            model.addAttribute("login_session", login_user);
            return login_user.getLogin();
        }
        return "";
    }
}
