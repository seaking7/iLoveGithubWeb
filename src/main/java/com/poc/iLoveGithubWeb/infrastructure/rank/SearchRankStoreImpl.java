package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.search.SearchRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.store.SearchRankStore;
import com.poc.iLoveGithubWeb.infrastructure.rank.repo.SearchRankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class SearchRankStoreImpl implements SearchRankStore {

    private final SearchRankRepository searchRankRepository;


    @Override
    public Page<SearchRankInfo> getSearchRank(Pageable pageable) {
        return searchRankRepository.findBy(pageable)
                .map(SearchRankInfo::from);
    }

    @Override
    public Page<SearchRankInfo> getSearchRankLanguageBy(String languageBy, Pageable pageable) {
        return searchRankRepository.findByFirstLanguageEquals(languageBy, pageable)
                .map(SearchRankInfo::from);
    }
}
