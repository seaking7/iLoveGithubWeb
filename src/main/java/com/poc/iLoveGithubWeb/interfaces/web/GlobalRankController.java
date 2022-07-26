package com.poc.iLoveGithubWeb.interfaces.web;

import com.poc.iLoveGithubWeb.application.RankFacade;
import com.poc.iLoveGithubWeb.config.auth.dto.SessionUser;
import com.poc.iLoveGithubWeb.domain.rank.RankInfo;
import com.poc.iLoveGithubWeb.domain.rank.SourceRankInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/global")
public class GlobalRankController {

    private final HttpSession httpSession;
    private final RankFacade rankFacade;

    @GetMapping("/user")
    public String globalUserRank(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) model.addAttribute("userName", user.getName());

        List<RankInfo> rankInfo = rankFacade.getUserRankIndex();
        model.addAttribute("userRanks", rankInfo);

        return "globalRank/userRank";
    }

    @GetMapping("/organization")
    public String globalOrgRank(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) model.addAttribute("userName", user.getName());

        List<RankInfo> rankInfo = rankFacade.getOrgRankIndex();
        model.addAttribute("userRanks", rankInfo);

        return "globalRank/orgRank";
    }

    @GetMapping("/source")
    public String globalSourceRank(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) model.addAttribute("userName", user.getName());

        List<SourceRankInfo> rankInfo = rankFacade.getSourceRankIndex();
        model.addAttribute("userRanks", rankInfo);

        return "globalRank/sourceRank";
    }
}
