package com.poc.iLoveGithubWeb.infrastructure.rank.repo;

import com.poc.iLoveGithubWeb.domain.rank.search.SearchRank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRankRepository extends JpaRepository<SearchRank, Integer> {

    Page<SearchRank> findBy( Pageable pageable);

    Page<SearchRank> findByFirstLanguageEquals(String FirstLanguage, Pageable pageable);

}
