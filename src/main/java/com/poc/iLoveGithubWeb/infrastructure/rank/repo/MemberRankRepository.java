package com.poc.iLoveGithubWeb.infrastructure.rank.repo;

import com.poc.iLoveGithubWeb.domain.rank.MemberRank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRankRepository extends JpaRepository<MemberRank, Integer> {

    Page<MemberRank> findBy( Pageable pageable);

    Page<MemberRank> findByFirstLanguageEquals(String FirstLanguage, Pageable pageable);

}
