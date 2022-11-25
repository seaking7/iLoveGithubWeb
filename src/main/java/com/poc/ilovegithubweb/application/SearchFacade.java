package com.poc.ilovegithubweb.application;

import org.springframework.stereotype.Service;

import com.poc.ilovegithubweb.domain.search.SearchCommand;
import com.poc.ilovegithubweb.domain.search.SearchService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchFacade {
	private final SearchService searchService;

	public void insertSearchResult(SearchCommand searchCommand) {

		searchService.insertSearchResult(searchCommand);
	}
}
