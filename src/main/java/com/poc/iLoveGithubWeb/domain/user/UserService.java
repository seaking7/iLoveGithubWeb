package com.poc.iLoveGithubWeb.domain.user;


import java.util.List;

public interface UserService {

    UserDetailInfo getUserDetailInfo(int id);

    List<UserRepoInfo> getUserRepoList(int id);
}
