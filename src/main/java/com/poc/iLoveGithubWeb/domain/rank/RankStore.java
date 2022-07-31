package com.poc.iLoveGithubWeb.domain.rank;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RankStore {

    Page<UserRankInfo> getUserRankIndex(Pageable pageable);

    List<RankInfo> getOrgRankIndex();

    List<SourceRankInfo> getSourceRankIndex();

    List<UserRank> getKoreanUserRankIndex(String type, Boolean isKorean);

    List<SourceRank> getKoreanSourceRankIndex();

    Page<UserRankInfo> getKoreanUserRankIndex2(Pageable pageable);
}
