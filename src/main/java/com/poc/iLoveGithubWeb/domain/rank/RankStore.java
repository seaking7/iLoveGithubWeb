package com.poc.iLoveGithubWeb.domain.rank;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RankStore {

    Page<UserRankInfo> getUserRankIndex(Pageable pageable);

    List<RankInfo> getOrgRankIndex();

    List<UserRank> getKoreanUserRankIndex(String type, Boolean isKorean);

    Page<SourceRankInfo> getGlobalSourceRank(Pageable pageable);
    Page<SourceRankInfo> getKoreanSourceRank(Pageable pageable);

    Page<UserRankInfo> getKoreanUserRankIndex2(Pageable pageable);

    Page<SourceRankInfo> getGlobalSourceRankLanguageBy(Pageable pageable, String languageBy);

    Page<SourceRankInfo> getKoreanSourceRankLanguageBy(Pageable pageable, String languageBy);
}
