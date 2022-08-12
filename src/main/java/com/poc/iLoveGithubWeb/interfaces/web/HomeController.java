package com.poc.iLoveGithubWeb.interfaces.web;

import com.poc.iLoveGithubWeb.application.RankFacade;
import com.poc.iLoveGithubWeb.config.auth.dto.SessionUser;
import com.poc.iLoveGithubWeb.domain.rank.OrgRankInfo;
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
        sessionCheck(model);


        Page<UserRankInfo> userRankInfo = rankFacade.getGlobalUserRank("All", pageable);
        model.addAttribute("userRanks", userRankInfo);

        Page<OrgRankInfo> orgRankInfo = rankFacade.getGlobalOrgRank("All", pageable);
        model.addAttribute("orgRanks", orgRankInfo);

        return "index";
    }

    private void sessionCheck(Model model) {
        SessionUser login_user = (SessionUser) httpSession.getAttribute("login_user");
        if(login_user != null){
            model.addAttribute("login_session", login_user);
        }
    }

    @GetMapping("/login/comingSoon")
    public String commingSoon(Model model){
        sessionCheck(model);
        return "login/comingSoon";
    }

    @GetMapping("/login/signIn")
    public String signIn(Model model){
        sessionCheck(model);
        return "login/signIn";
    }

    @GetMapping("/login/info")
    public String info(Model model){
        sessionCheck(model);
        return "login/info";
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
}
