package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.UserRank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRankRepository extends JpaRepository<UserRank, Integer> {

    Page<UserRank> findByTypeEquals(String type, Pageable pageable);
    Page<UserRank> findByTypeEqualsAndIsKoreanIsTrue(String type, Pageable pageable);
}
