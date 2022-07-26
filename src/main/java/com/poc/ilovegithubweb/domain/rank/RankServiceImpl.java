package com.poc.ilovegithubweb.domain.rank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poc.ilovegithubweb.domain.rank.member.MemberRankInfo;
import com.poc.ilovegithubweb.domain.rank.org.OrgRankInfo;
import com.poc.ilovegithubweb.domain.rank.search.SearchRankInfo;
import com.poc.ilovegithubweb.domain.rank.source.SourceRankInfo;
import com.poc.ilovegithubweb.domain.rank.store.MemberRankStore;
import com.poc.ilovegithubweb.domain.rank.store.OrgRankStore;
import com.poc.ilovegithubweb.domain.rank.store.SearchRankStore;
import com.poc.ilovegithubweb.domain.rank.store.SourceRankStore;
import com.poc.ilovegithubweb.domain.rank.store.UserRankStore;
import com.poc.ilovegithubweb.domain.rank.user.UserRankInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {
	private final UserRankStore userRankStore;
	private final OrgRankStore orgRankStore;
	private final MemberRankStore memberRankStore;
	private final SourceRankStore sourceRankStore;
	private final SearchRankStore searchRankStore;

	@Override
	public Page<UserRankInfo> getGlobalUserRank(String languageBy, Pageable pageable) {
		if (languageBy.equals("All")) {
			return userRankStore.getUserRankIndex(pageable);
		} else {
			return userRankStore.getUserRankLanguageBy(languageBy, pageable);
		}
	}

	@Override
	public Page<OrgRankInfo> getOrgRankIndex(String languageBy, Pageable pageable) {
		if (languageBy.equals("All")) {
			return orgRankStore.getOrgRankIndex(pageable);
		} else {
			return orgRankStore.getOrgRankLanguageBy(languageBy, pageable);
		}
	}

	@Override
	public Page<OrgRankInfo> getKoreanOrgRank(String languageBy, Pageable pageable) {
		if (languageBy.equals("All")) {
			return orgRankStore.getKoreanOrgRank(pageable);
		} else {
			return orgRankStore.getKoreanOrgRankLanguageBy(languageBy, pageable);
		}
	}

	@Override
	public Page<UserRankInfo> getKoreanUserRank(String languageBy, Pageable pageable) {
		if (languageBy.equals("All")) {
			return userRankStore.getKoreanUserRank(pageable);
		} else {
			return userRankStore.getKoreanUserRankLanguageBy(languageBy, pageable);
		}
	}

	@Override
	public Page<SourceRankInfo> getGlobalSourceRank(String languageBy, Pageable pageable) {
		if (languageBy.equals("All")) {
			return sourceRankStore.getGlobalSourceRank(pageable);
		} else {
			return sourceRankStore.getGlobalSourceRankLanguageBy(languageBy, pageable);
		}
	}

	@Override
	public Page<SourceRankInfo> getKoreanSourceRank(String languageBy, Pageable pageable) {
		if (languageBy.equals("All")) {
			return sourceRankStore.getKoreanSourceRank(pageable);
		} else {
			return sourceRankStore.getKoreanSourceRankLanguageBy(languageBy, pageable);
		}
	}

	@Override
	public Page<MemberRankInfo> getMemberRank(String languageBy, Pageable pageable) {
		if (languageBy.equals("All")) {
			return memberRankStore.getMemberRank(pageable);
		} else {
			return memberRankStore.getMemberRankLanguageBy(languageBy, pageable);
		}
	}

	@Override
	public Page<SearchRankInfo> getSearchRank(String languageBy, Pageable pageable) {
		if (languageBy.equals("All")) {
			return searchRankStore.getSearchRank(pageable);
		} else {
			return searchRankStore.getSearchRankLanguageBy(languageBy, pageable);
		}
	}

}
