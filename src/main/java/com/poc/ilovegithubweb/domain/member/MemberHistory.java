package com.poc.ilovegithubweb.domain.member;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "g_member_history")
public class MemberHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(nullable = false)
	private int id;

	@Column(nullable = false)
	private String login;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime loginAt;

	@Builder
	public MemberHistory(int id, String login, LocalDateTime loginAt) {
		this.id = id;
		this.login = login;
		this.loginAt = loginAt;
	}
}
