package com.poc.iLoveGithubWeb.application;

import com.poc.iLoveGithubWeb.domain.user.UserDetailInfo;
import com.poc.iLoveGithubWeb.domain.user.UserRepoInfo;
import com.poc.iLoveGithubWeb.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserInfoFacade {
    private final UserService userService;

    public UserDetailInfo getUserRankIndex(int id) {
        return userService.getUserDetailInfo(id);
    }

    public List<UserRepoInfo> getUserRepoList(int id) {
        return userService.getUserRepoList(id);
    }
}
