package com.poc.iLoveGithubWeb.interfaces.web;

import com.poc.iLoveGithubWeb.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final HttpSession httpSession;

    @GetMapping("/signIn")      //로그인 화면
    public String signIn(Model model){
        sessionCheck(model);
        return "login/signIn";
    }


    @GetMapping("/info")       //서비스 소개
    public String info(Model model){
        sessionCheck(model);
        return "login/info";
    }



    @GetMapping("/comingSoon")
    public String commingSoon(Model model){
        sessionCheck(model);
        return "login/comingSoon";
    }

    private void sessionCheck(Model model) {
        SessionUser login_user = (SessionUser) httpSession.getAttribute("login_user");
        if(login_user != null){
            model.addAttribute("login_session", login_user);
        }
    }
}
