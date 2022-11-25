package com.poc.ilovegithubweb.domain.rank.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poc.ilovegithubweb.domain.rank.search.SearchRankInfo;

public interface SearchRankStore {

	Page<SearchRankInfo> getSearchRank(Pageable pageable);

	Page<SearchRankInfo> getSearchRankLanguageBy(String languageBy, Pageable pageable);

}
