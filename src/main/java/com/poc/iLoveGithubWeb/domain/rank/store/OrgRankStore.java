package com.poc.iLoveGithubWeb.domain.rank.store;


import com.poc.iLoveGithubWeb.domain.rank.OrgRankInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrgRankStore {

    Page<OrgRankInfo> getOrgRankIndex(Pageable pageable);

    Page<OrgRankInfo> getKoreanOrgRank(Pageable pageable);

    Page<OrgRankInfo> getOrgRankLanguageBy(String languageBy, Pageable pageable);

    Page<OrgRankInfo> getKoreanOrgRankLanguageBy(String languageBy, Pageable pageable);
}
