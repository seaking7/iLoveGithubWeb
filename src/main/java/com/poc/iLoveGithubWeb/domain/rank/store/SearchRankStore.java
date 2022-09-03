package com.poc.iLoveGithubWeb.domain.rank.store;


import com.poc.iLoveGithubWeb.domain.rank.search.SearchRankInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchRankStore {

    public Page<SearchRankInfo> getSearchRank(Pageable pageable);

    public Page<SearchRankInfo> getSearchRankLanguageBy(String languageBy, Pageable pageable);

}
