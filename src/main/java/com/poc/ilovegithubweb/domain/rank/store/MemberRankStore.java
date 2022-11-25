package com.poc.ilovegithubweb.domain.rank.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poc.ilovegithubweb.domain.rank.member.MemberRankInfo;

public interface MemberRankStore {

	Page<MemberRankInfo> getMemberRank(Pageable pageable);

	Page<MemberRankInfo> getMemberRankLanguageBy(String languageBy, Pageable pageable);

}
