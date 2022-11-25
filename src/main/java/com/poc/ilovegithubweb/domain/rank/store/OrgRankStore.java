package com.poc.ilovegithubweb.domain.rank.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poc.ilovegithubweb.domain.rank.org.OrgRankInfo;

public interface OrgRankStore {

	Page<OrgRankInfo> getOrgRankIndex(Pageable pageable);

	Page<OrgRankInfo> getKoreanOrgRank(Pageable pageable);

	Page<OrgRankInfo> getOrgRankLanguageBy(String languageBy, Pageable pageable);

	Page<OrgRankInfo> getKoreanOrgRankLanguageBy(String languageBy, Pageable pageable);
}
