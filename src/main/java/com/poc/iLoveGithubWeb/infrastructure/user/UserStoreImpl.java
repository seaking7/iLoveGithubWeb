package com.poc.iLoveGithubWeb.infrastructure.user;

import com.poc.iLoveGithubWeb.domain.user.UserDetailInfo;
import com.poc.iLoveGithubWeb.domain.user.UserRepoInfo;
import com.poc.iLoveGithubWeb.domain.user.UserStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

    private final JdbcUserRepository jdbcUserRepository;

    @Override
    public UserDetailInfo getUserDetailInfo(int id) {
        return jdbcUserRepository.findUserDetailById(id).orElse(new UserDetailInfo());
    }

    @Override
    public List<UserRepoInfo> getUserRepoList(int id) {
        return jdbcUserRepository.findUserRepoById(id);
    }
}
