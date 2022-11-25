package com.poc.ilovegithubweb.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.ilovegithubweb.domain.user.UserDetailInfo;
import com.poc.ilovegithubweb.domain.user.UserRepoInfo;
import com.poc.ilovegithubweb.domain.user.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

	public UserDetailInfo getUserRankByLogin(String login) {
		return userService.getUserDetailInfoByLogin(login);
	}

	public List<UserRepoInfo> getUserRepoListByLogin(String login) {
		return userService.getUserRepoListByLogin(login);
	}
}
