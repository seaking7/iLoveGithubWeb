package com.poc.iLoveGithubWeb.domain.rank;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RankService {

    Page<UserRankInfo> getGlobalUserRank(Pageable pageable);

    Page<OrgRankInfo> getOrgRankIndex(Pageable pageable);

    Page<UserRankInfo> getKoreanUserRank(Pageable pageable);
    Page<SourceRankInfo> getGlobalSourceRank(String languageBy, Pageable pageable);


    Page<OrgRankInfo> getKoreanOrgRankIndex(Pageable pageable);

    Page<SourceRankInfo> getKoreanSourceRank(String languageBy, Pageable pageable);


}
