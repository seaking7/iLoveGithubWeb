package com.poc.ilovegithubweb.domain.user;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDetailInfo {
	private int id;
	private String login;
	private String status;
	private String name;
	private String type;
	private String blog;
	private String company;
	private String location;
	private String email;
	private String bio;
	private int publicRepos;
	private int followers;
	private int following;
	private int star;
	private LocalDateTime updatedAt;
}
