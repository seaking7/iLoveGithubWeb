package com.poc.iLoveGithubWeb.infrastructure.search;

import com.poc.iLoveGithubWeb.domain.search.SearchResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchResultRepository extends JpaRepository<SearchResult, Long> {

}
