package com.poc.iLoveGithubWeb.interfaces.web;


import com.poc.iLoveGithubWeb.application.RankFacade;
import com.poc.iLoveGithubWeb.config.auth.dto.SessionUser;
import com.poc.iLoveGithubWeb.domain.rank.OrgRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.SourceRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.UserRankInfo;
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

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/korean")
public class KoreanRankController {

    private final HttpSession httpSession;
    private final RankFacade rankFacade;


    @GetMapping("/user")
    public String globalUserRank(Model model,
                                 @RequestParam(required = false, defaultValue = "30") int size,
                                 @RequestParam(required = false, defaultValue = "0")  int page,
                                 @RequestParam(required = false, defaultValue = "StargazersCount") String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());


        SessionUser user = (SessionUser) httpSession.getAttribute("login_user");
        if(user != null){
            model.addAttribute("login_login", user.getLogin());
            model.addAttribute("login_name", user.getName());
            model.addAttribute("login_avatar", user.getAvatarUrl());
        }

        Page<UserRankInfo> rankInfo = rankFacade.getKoreanUserRankIndex(pageable);
        model.addAttribute("userRanks", rankInfo);
        model.addAttribute("var_sortBy", sortBy);

        return "koreanRank/userRank";
    }

    @GetMapping("/organization")
    public String globalOrgRank(Model model,
                                @RequestParam(required = false, defaultValue = "30") int size,
                                @RequestParam(required = false, defaultValue = "0")  int page,
                                @RequestParam(required = false, defaultValue = "StargazersCount") String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by("StargazersCount").descending());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) model.addAttribute("userName", user.getName());

        Page<OrgRankInfo> rankInfo = rankFacade.getKoreanOrgRankIndex(pageable);
        model.addAttribute("userRanks", rankInfo);
        model.addAttribute("var_sortBy", sortBy);

        return "koreanRank/orgRank";
    }

    @GetMapping("/source")
    public String globalSourceRank(Model model,
                                   @RequestParam(required = false, defaultValue = "30") int size,
                                   @RequestParam(required = false, defaultValue = "0")  int page,
                                   @RequestParam(required = false, defaultValue = "All") String languageBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by("StargazersCount").descending());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) model.addAttribute("userName", user.getName());

        Page<SourceRankInfo> rankInfo = rankFacade.getKoreanSourceRankIndex(languageBy, pageable);
        model.addAttribute("userRanks", rankInfo);
        model.addAttribute("var_languageBy", languageBy);

        return "koreanRank/sourceRank";
    }
}
