package com.poc.ilovegithubweb.infrastructure.rank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.poc.ilovegithubweb.domain.rank.store.UserRankStore;
import com.poc.ilovegithubweb.domain.rank.user.UserRankInfo;
import com.poc.ilovegithubweb.infrastructure.rank.repo.UserRankRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRankStoreImpl implements UserRankStore {

	private final UserRankRepository userRankRepository;

	@Override
	public Page<UserRankInfo> getUserRankIndex(Pageable pageable) {
		return userRankRepository.findBy(pageable)
			.map(UserRankInfo::from);
	}

	@Override
	public Page<UserRankInfo> getKoreanUserRank(Pageable pageable) {
		return userRankRepository.findByIsKoreanIsTrue(pageable)
			.map(UserRankInfo::from);
	}

	@Override
	public Page<UserRankInfo> getUserRankLanguageBy(String languageBy, Pageable pageable) {
		return userRankRepository.findByFirstLanguageEquals(languageBy, pageable)
			.map(UserRankInfo::from);
	}

	@Override
	public Page<UserRankInfo> getKoreanUserRankLanguageBy(String languageBy, Pageable pageable) {
		return userRankRepository.findByFirstLanguageEqualsAndIsKoreanIsTrue(languageBy, pageable)
			.map(UserRankInfo::from);
	}

}
