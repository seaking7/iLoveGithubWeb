package com.poc.iLoveGithubWeb.infrastructure.rank.repo;

import com.poc.iLoveGithubWeb.domain.rank.OrgRank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRankRepository extends JpaRepository<OrgRank, Integer> {

    Page<OrgRank> findBy(Pageable pageable);

    Page<OrgRank> findByFirstLanguageEquals(String FirstLanguage, Pageable pageable);
    Page<OrgRank> findByIsKoreanIsTrue(Pageable pageable);

    Page<OrgRank> findByFirstLanguageEqualsAndIsKoreanIsTrue(String FirstLanguage, Pageable pageable);
}
