package com.poc.iLoveGithubWeb.domain.search;

import com.poc.iLoveGithubWeb.infrastructure.search.SearchResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchResultRepository searchResultRepository;

    @Override
    public void insertSearchResult(SearchCommand searchCommand) {
        SearchResult searchResult = searchCommand.toEntity();
        searchResultRepository.save(searchResult);
    }
}
