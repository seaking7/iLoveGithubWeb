package com.poc.ilovegithubweb.domain.rank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poc.ilovegithubweb.domain.rank.member.MemberRankInfo;
import com.poc.ilovegithubweb.domain.rank.org.OrgRankInfo;
import com.poc.ilovegithubweb.domain.rank.search.SearchRankInfo;
import com.poc.ilovegithubweb.domain.rank.source.SourceRankInfo;
import com.poc.ilovegithubweb.domain.rank.user.UserRankInfo;

public interface RankService {

	Page<UserRankInfo> getGlobalUserRank(String languageBy, Pageable pageable);

	Page<OrgRankInfo> getOrgRankIndex(String languageBy, Pageable pageable);

	Page<UserRankInfo> getKoreanUserRank(String languageBy, Pageable pageable);

	Page<SourceRankInfo> getGlobalSourceRank(String languageBy, Pageable pageable);

	Page<OrgRankInfo> getKoreanOrgRank(String languageBy, Pageable pageable);

	Page<SourceRankInfo> getKoreanSourceRank(String languageBy, Pageable pageable);

	Page<MemberRankInfo> getMemberRank(String languageBy, Pageable pageable);

	Page<SearchRankInfo> getSearchRank(String languageBy, Pageable pageable);
}
