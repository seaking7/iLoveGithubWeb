package com.poc.ilovegithubweb.infrastructure.rank.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.ilovegithubweb.domain.rank.source.SourceRank;

public interface SourceRankRepository extends JpaRepository<SourceRank, Integer> {

	Page<SourceRank> findBy(Pageable pageable);

	Page<SourceRank> findByLanguageEquals(String language, Pageable pageable);

	Page<SourceRank> findByIsKoreanTrue(Pageable pageable);

	Page<SourceRank> findByLanguageEqualsAndIsKoreanTrue(String language, Pageable pageable);
}
