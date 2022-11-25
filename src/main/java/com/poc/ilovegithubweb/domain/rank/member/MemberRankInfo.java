package com.poc.ilovegithubweb.domain.rank.member;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberRankInfo {
	private int id;
	private String login;
	private String company;
	private int followers;
	private int following;
	private int size;
	private int stargazersCount;
	private String firstLanguage;
	private String secondLanguage;
	private String thirdLanguage;
	private LocalDateTime updatedAt;

	public static MemberRankInfo from(MemberRank memberRank) {

		return MemberRankInfo.builder()
			.id(memberRank.getId())
			.login(memberRank.getLogin())
			.company(memberRank.getCompany())
			.followers(memberRank.getFollowers())
			.following(memberRank.getFollowing())
			.size(memberRank.getSize())
			.stargazersCount(memberRank.getStargazersCount())
			.firstLanguage(memberRank.getFirstLanguage())
			.secondLanguage(memberRank.getSecondLanguage())
			.thirdLanguage(memberRank.getThirdLanguage())
			.updatedAt(memberRank.getUpdatedAt())
			.build();
	}

}
