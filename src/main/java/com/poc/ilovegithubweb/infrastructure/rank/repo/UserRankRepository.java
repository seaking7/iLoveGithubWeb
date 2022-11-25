package com.poc.ilovegithubweb.infrastructure.rank.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.ilovegithubweb.domain.rank.user.UserRank;

public interface UserRankRepository extends JpaRepository<UserRank, Integer> {

	Page<UserRank> findBy(Pageable pageable);

	Page<UserRank> findByFirstLanguageEquals(String firstLanguage, Pageable pageable);

	Page<UserRank> findByIsKoreanIsTrue(Pageable pageable);

	Page<UserRank> findByFirstLanguageEqualsAndIsKoreanIsTrue(String firstLanguage, Pageable pageable);
}
