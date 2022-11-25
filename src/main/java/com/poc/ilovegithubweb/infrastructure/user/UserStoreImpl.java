package com.poc.ilovegithubweb.infrastructure.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.poc.ilovegithubweb.domain.user.UserDetailInfo;
import com.poc.ilovegithubweb.domain.user.UserRepoInfo;
import com.poc.ilovegithubweb.domain.user.UserStore;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

	@Override
	public UserDetailInfo getUserDetailInfoByLogin(String login) {
		return jdbcUserRepository.findUserDetailByLogin(login).orElse(new UserDetailInfo());
	}

	@Override
	public List<UserRepoInfo> getUserRepoListByLogin(String login) {
		return jdbcUserRepository.findUserRepoByLogin(login);
	}
}
