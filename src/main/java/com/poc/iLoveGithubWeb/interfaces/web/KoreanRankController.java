package com.poc.iLoveGithubWeb.interfaces.web;


import com.poc.iLoveGithubWeb.application.RankFacade;
import com.poc.iLoveGithubWeb.config.auth.dto.SessionUser;
import com.poc.iLoveGithubWeb.domain.rank.RankInfo;
import com.poc.iLoveGithubWeb.domain.rank.SourceRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.UserRankInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) model.addAttribute("userName", user.getName());

        Page<UserRankInfo> rankInfo = rankFacade.getKoreanUserRankIndex(pageable);
        model.addAttribute("userRanks", rankInfo);
        model.addAttribute("var_sortBy", sortBy);

        return "koreanRank/userRank";
    }

    @GetMapping("/organization")
    public String globalOrgRank(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) model.addAttribute("userName", user.getName());

        List<RankInfo> rankInfo = rankFacade.getKoreanOrgRankIndex();
        model.addAttribute("userRanks", rankInfo);

        return "koreanRank/orgRank";
    }

    @GetMapping("/source")
    public String globalSourceRank(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) model.addAttribute("userName", user.getName());

        List<SourceRankInfo> rankInfo = rankFacade.getKoreanSourceRankIndex();
        model.addAttribute("userRanks", rankInfo);

        return "koreanRank/sourceRank";
    }
}
