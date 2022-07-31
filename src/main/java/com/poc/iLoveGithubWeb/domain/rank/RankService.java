package com.poc.iLoveGithubWeb.domain.rank;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RankService {

    Page<UserRankInfo> getGlobalUserRank(Pageable pageable);

    List<RankInfo> getOrgRankIndex();

    List<SourceRankInfo> getSourceRankIndex();

    List<RankInfo> getKoreanUserRankIndex();

    List<RankInfo> getKoreanOrgRankIndex();

    List<SourceRankInfo> getKoreanSourceRankIndex();

    Page<UserRankInfo> getKoreanUserRankIndex2(Pageable pageable);
}
