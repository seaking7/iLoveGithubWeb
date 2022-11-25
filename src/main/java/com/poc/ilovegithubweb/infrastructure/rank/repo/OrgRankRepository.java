package com.poc.ilovegithubweb.infrastructure.rank.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.ilovegithubweb.domain.rank.org.OrgRank;

public interface OrgRankRepository extends JpaRepository<OrgRank, Integer> {

	Page<OrgRank> findBy(Pageable pageable);

	Page<OrgRank> findByFirstLanguageEquals(String firstLanguage, Pageable pageable);

	Page<OrgRank> findByIsKoreanIsTrue(Pageable pageable);

	Page<OrgRank> findByFirstLanguageEqualsAndIsKoreanIsTrue(String firstLanguage, Pageable pageable);
}
