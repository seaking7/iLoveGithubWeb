package com.poc.ilovegithubweb.domain.search;

import org.springframework.stereotype.Service;

import com.poc.ilovegithubweb.infrastructure.search.SearchResultRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
