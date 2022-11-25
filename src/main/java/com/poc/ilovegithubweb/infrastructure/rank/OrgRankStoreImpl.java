package com.poc.ilovegithubweb.infrastructure.rank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.poc.ilovegithubweb.domain.rank.org.OrgRankInfo;
import com.poc.ilovegithubweb.domain.rank.store.OrgRankStore;
import com.poc.ilovegithubweb.infrastructure.rank.repo.OrgRankRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrgRankStoreImpl implements OrgRankStore {

	private final OrgRankRepository orgRankRepository;

	@Override
	public Page<OrgRankInfo> getOrgRankIndex(Pageable pageable) {
		return orgRankRepository.findBy(pageable)
			.map(OrgRankInfo::from);
	}

	@Override
	public Page<OrgRankInfo> getKoreanOrgRank(Pageable pageable) {
		return orgRankRepository.findByIsKoreanIsTrue(pageable)
			.map(OrgRankInfo::from);
	}

	@Override
	public Page<OrgRankInfo> getOrgRankLanguageBy(String languageBy, Pageable pageable) {
		return orgRankRepository.findByFirstLanguageEquals(languageBy, pageable)
			.map(OrgRankInfo::from);
	}

	@Override
	public Page<OrgRankInfo> getKoreanOrgRankLanguageBy(String languageBy, Pageable pageable) {
		return orgRankRepository.findByFirstLanguageEqualsAndIsKoreanIsTrue(languageBy, pageable)
			.map(OrgRankInfo::from);
	}

}
