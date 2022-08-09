package com.poc.iLoveGithubWeb.interfaces.web;

import com.poc.iLoveGithubWeb.application.RankFacade;
import com.poc.iLoveGithubWeb.config.auth.dto.SessionUser;
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

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final HttpSession httpSession;
    private final RankFacade rankFacade;

    @GetMapping
    public String viewHome(Model model){
        Pageable pageable = PageRequest.of(0, 30, Sort.by("StargazersCount").descending());


        SessionUser login_user = (SessionUser) httpSession.getAttribute("login_user");
        if(login_user != null){
            model.addAttribute("login_session", login_user);
        }

        Page<UserRankInfo> rankInfo = rankFacade.getGlobalUserRankIndex(pageable);
        model.addAttribute("userRanks", rankInfo);

        return "index";
    }

    @GetMapping("/login/comingSoon")
    public String commingSoon(Model model){
        SessionUser login_user = (SessionUser) httpSession.getAttribute("login_user");
        if(login_user != null){
            model.addAttribute("login_session", login_user);
        }
        return "login/comingSoon";
    }

    @GetMapping("/login/signIn")
    public String signIn(Model model){

        return "login/signIn";
    }
}
