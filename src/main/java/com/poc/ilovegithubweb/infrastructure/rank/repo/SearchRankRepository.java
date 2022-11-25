package com.poc.ilovegithubweb.infrastructure.rank.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.ilovegithubweb.domain.rank.search.SearchRank;

public interface SearchRankRepository extends JpaRepository<SearchRank, Integer> {

	Page<SearchRank> findBy(Pageable pageable);

	Page<SearchRank> findByFirstLanguageEquals(String firstLanguage, Pageable pageable);

}
