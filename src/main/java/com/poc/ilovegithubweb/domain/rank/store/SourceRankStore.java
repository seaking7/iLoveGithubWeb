package com.poc.ilovegithubweb.domain.rank.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poc.ilovegithubweb.domain.rank.source.SourceRankInfo;

public interface SourceRankStore {

	Page<SourceRankInfo> getGlobalSourceRank(Pageable pageable);

	Page<SourceRankInfo> getGlobalSourceRankLanguageBy(String languageBy, Pageable pageable);

	Page<SourceRankInfo> getKoreanSourceRank(Pageable pageable);

	Page<SourceRankInfo> getKoreanSourceRankLanguageBy(String languageBy, Pageable pageable);
}
