package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.UserRank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRankRepository extends JpaRepository<UserRank, Integer> {

}
