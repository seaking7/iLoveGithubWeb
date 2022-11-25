package com.poc.ilovegithubweb.infrastructure.rank.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.ilovegithubweb.domain.rank.member.MemberRank;

public interface MemberRankRepository extends JpaRepository<MemberRank, Integer> {

	Page<MemberRank> findBy(Pageable pageable);

	Page<MemberRank> findByFirstLanguageEquals(String firstLanguage, Pageable pageable);

}
