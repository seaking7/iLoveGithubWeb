package com.poc.iLoveGithubWeb.domain.user;


import java.util.List;

public interface UserStore {

    UserDetailInfo getUserDetailInfo(int id);

    List<UserRepoInfo> getUserRepoList(int id);

    UserDetailInfo getUserDetailInfoByLogin(String login);

    List<UserRepoInfo> getUserRepoListByLogin(String login);
}
