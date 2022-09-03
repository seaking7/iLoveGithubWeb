package com.poc.iLoveGithubWeb.domain.rank.store;


import com.poc.iLoveGithubWeb.domain.rank.source.SourceRankInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SourceRankStore {

    Page<SourceRankInfo> getGlobalSourceRank(Pageable pageable);
    Page<SourceRankInfo> getGlobalSourceRankLanguageBy(String languageBy, Pageable pageable);

    Page<SourceRankInfo> getKoreanSourceRank(Pageable pageable);
    Page<SourceRankInfo> getKoreanSourceRankLanguageBy(String languageBy, Pageable pageable);
}
