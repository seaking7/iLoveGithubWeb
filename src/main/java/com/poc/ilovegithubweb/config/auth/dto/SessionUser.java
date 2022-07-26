package com.poc.ilovegithubweb.config.auth.dto;

import java.io.Serializable;

import com.poc.ilovegithubweb.domain.member.Member;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {

	private final int id;
	private final String login;
	private final String email;
	private final String type;
	private final String name;
	private final String company;

	public SessionUser(Member member) {
		this.id = member.getId();
		this.login = member.getLogin();
		this.email = member.getEmail();
		this.type = member.getType();
		this.name = member.getName();
		this.company = member.getCompany();

	}
}
