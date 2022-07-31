package com.poc.iLoveGithubWeb.domain.rank;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RankService {

    Page<UserRankInfo> getGlobalUserRank(Pageable pageable);

    List<RankInfo> getOrgRankIndex();

    Page<SourceRankInfo> getGlobalSourceRank(Pageable pageable, String languageBy);

    List<RankInfo> getKoreanUserRankIndex();

    List<RankInfo> getKoreanOrgRankIndex();

    Page<SourceRankInfo> getKoreanSourceRank(Pageable pageable, String languageBy);

    Page<UserRankInfo> getKoreanUserRankIndex2(Pageable pageable);
}
