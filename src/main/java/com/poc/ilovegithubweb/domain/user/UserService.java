package com.poc.ilovegithubweb.domain.user;

import java.util.List;

public interface UserService {

	UserDetailInfo getUserDetailInfo(int id);

	List<UserRepoInfo> getUserRepoList(int id);

	UserDetailInfo getUserDetailInfoByLogin(String login);

	List<UserRepoInfo> getUserRepoListByLogin(String login);
}
