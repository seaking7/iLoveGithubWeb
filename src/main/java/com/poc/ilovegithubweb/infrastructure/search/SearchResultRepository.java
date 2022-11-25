package com.poc.ilovegithubweb.infrastructure.search;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.ilovegithubweb.domain.search.SearchResult;

public interface SearchResultRepository extends JpaRepository<SearchResult, Long> {

}
