package com.poc.ilovegithubweb.domain.rank;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RankInfo {
	private int id;
	private String login;
	private int followers;
	private int following;
	private int size;
	private int stargazersCount;
	private LocalDateTime updatedAt;

}
