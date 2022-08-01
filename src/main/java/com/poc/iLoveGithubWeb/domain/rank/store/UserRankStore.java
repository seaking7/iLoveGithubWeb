package com.poc.iLoveGithubWeb.domain.rank.store;


import com.poc.iLoveGithubWeb.domain.rank.UserRankInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRankStore {

    Page<UserRankInfo> getUserRankIndex(Pageable pageable);

    Page<UserRankInfo> getKoreanUserRank(Pageable pageable);

}
