package com.poc.iLoveGithubWeb.application;

import com.poc.iLoveGithubWeb.domain.search.SearchCommand;
import com.poc.iLoveGithubWeb.domain.search.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchFacade {
    private final SearchService searchService;

    public void insertSearchResult(SearchCommand searchCommand) {

        searchService.insertSearchResult(searchCommand);
    }
}
