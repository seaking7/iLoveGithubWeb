package com.poc.iLoveGithubWeb.infrastructure.rank.repo;

import com.poc.iLoveGithubWeb.domain.rank.UserRank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRankRepository extends JpaRepository<UserRank, Integer> {

    Page<UserRank> findBy( Pageable pageable);

    Page<UserRank> findByFirstLanguageEquals(String FirstLanguage, Pageable pageable);

    Page<UserRank> findByIsKoreanIsTrue(Pageable pageable);

    Page<UserRank> findByFirstLanguageEqualsAndIsKoreanIsTrue(String FirstLanguage, Pageable pageable);
}
