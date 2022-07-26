package com.poc.iLoveGithubWeb.interfaces.web;

import com.poc.iLoveGithubWeb.application.UserInfoFacade;
import com.poc.iLoveGithubWeb.config.auth.dto.SessionUser;
import com.poc.iLoveGithubWeb.domain.user.UserDetailInfo;
import com.poc.iLoveGithubWeb.domain.user.UserRepoInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserInfoController {

    private final HttpSession httpSession;
    private final UserInfoFacade userInfoFacade;


    @GetMapping("/{id}")
    public String detailUser(@PathVariable int id, Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) model.addAttribute("userName", user.getName());

        UserDetailInfo userDetailInfo = userInfoFacade.getUserRankIndex(id);
        log.info("userinfo =={}", userDetailInfo.toString());
        model.addAttribute("userInfo", userDetailInfo);

        List<UserRepoInfo> userRepoInfoList = userInfoFacade.getUserRepoList(id);
        model.addAttribute("userRepoList", userRepoInfoList);
        return "user/userDetail";
    }

}
