package com.poc.ilovegithubweb.domain.rank.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poc.ilovegithubweb.domain.rank.user.UserRankInfo;

public interface UserRankStore {

	Page<UserRankInfo> getUserRankIndex(Pageable pageable);

	Page<UserRankInfo> getKoreanUserRank(Pageable pageable);

	Page<UserRankInfo> getUserRankLanguageBy(String languageBy, Pageable pageable);

	Page<UserRankInfo> getKoreanUserRankLanguageBy(String languageBy, Pageable pageable);

}
