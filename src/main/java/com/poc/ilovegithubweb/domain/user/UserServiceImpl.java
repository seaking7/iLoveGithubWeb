package com.poc.ilovegithubweb.domain.user;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserStore userStore;

	@Override
	public UserDetailInfo getUserDetailInfo(int id) {
		return userStore.getUserDetailInfo(id);
	}

	@Override
	public List<UserRepoInfo> getUserRepoList(int id) {
		return userStore.getUserRepoList(id);
	}

	@Override
	public UserDetailInfo getUserDetailInfoByLogin(String login) {
		return userStore.getUserDetailInfoByLogin(login);
	}

	@Override
	public List<UserRepoInfo> getUserRepoListByLogin(String login) {
		return userStore.getUserRepoListByLogin(login);
	}
}
