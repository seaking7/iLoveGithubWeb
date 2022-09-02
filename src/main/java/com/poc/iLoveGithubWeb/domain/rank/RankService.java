package com.poc.iLoveGithubWeb.domain.rank;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RankService {

    Page<UserRankInfo> getGlobalUserRank(String languageBy, Pageable pageable);

    Page<OrgRankInfo> getOrgRankIndex(String languageBy, Pageable pageable);

    Page<UserRankInfo> getKoreanUserRank(String languageBy, Pageable pageable);
    Page<SourceRankInfo> getGlobalSourceRank(String languageBy, Pageable pageable);


    Page<OrgRankInfo> getKoreanOrgRank(String languageBy, Pageable pageable);

    Page<SourceRankInfo> getKoreanSourceRank(String languageBy, Pageable pageable);


    Page<MemberRankInfo> getMemberRank(String languageBy, Pageable pageable);
}
