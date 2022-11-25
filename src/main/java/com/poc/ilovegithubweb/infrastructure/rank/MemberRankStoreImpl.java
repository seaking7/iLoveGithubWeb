package com.poc.ilovegithubweb.infrastructure.rank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.poc.ilovegithubweb.domain.rank.member.MemberRankInfo;
import com.poc.ilovegithubweb.domain.rank.store.MemberRankStore;
import com.poc.ilovegithubweb.infrastructure.rank.repo.MemberRankRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberRankStoreImpl implements MemberRankStore {

	private final MemberRankRepository memberRankRepository;

	@Override
	public Page<MemberRankInfo> getMemberRank(Pageable pageable) {
		return memberRankRepository.findBy(pageable)
			.map(MemberRankInfo::from);
	}

	@Override
	public Page<MemberRankInfo> getMemberRankLanguageBy(String languageBy, Pageable pageable) {
		return memberRankRepository.findByFirstLanguageEquals(languageBy, pageable)
			.map(MemberRankInfo::from);
	}

}
