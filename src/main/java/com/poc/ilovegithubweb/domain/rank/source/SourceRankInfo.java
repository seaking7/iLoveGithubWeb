package com.poc.ilovegithubweb.domain.rank.source;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SourceRankInfo {
	private int id;
	private String login;
	private int userId;
	private String name;
	private int size;
	private int stargazersCount;
	private String language;
	private LocalDateTime createdAt;
	private LocalDateTime pushedAt;

	public static SourceRankInfo from(SourceRank sourceRank) {
		return SourceRankInfo.builder()
			.id(sourceRank.getId())
			.login(sourceRank.getLogin())
			.userId(sourceRank.getUserId())
			.name(sourceRank.getName())
			.size(sourceRank.getSize())
			.stargazersCount(sourceRank.getStargazersCount())
			.language(sourceRank.getLanguage())
			.createdAt(sourceRank.getCreatedAt())
			.pushedAt(sourceRank.getPushedAt())
			.build();
	}
}
