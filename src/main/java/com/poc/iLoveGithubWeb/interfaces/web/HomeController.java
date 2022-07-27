package com.poc.iLoveGithubWeb.interfaces.web;

import com.poc.iLoveGithubWeb.application.RankFacade;
import com.poc.iLoveGithubWeb.config.auth.dto.SessionUser;
import com.poc.iLoveGithubWeb.domain.rank.RankInfo;
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
@RequestMapping("/")
public class HomeController {

    private final HttpSession httpSession;
    private final RankFacade rankFacade;

    @GetMapping
    public String viewHome(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("member_login", user.getLogin());
            model.addAttribute("member_Name", user.getName());
            model.addAttribute("member_avatar", user.getAvatarUrl());
        }

        List<RankInfo> rankInfo = rankFacade.getUserRankIndex();
        model.addAttribute("userRanks", rankInfo);

        return "index";
    }

    @GetMapping("/comingSoon")
    public String commingSoon(Model model){

        return "comingSoon";
    }
}
