package com.poc.ilovegithubweb.domain.rank.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "G_userRank")
public class UserRank {

	@Id
	private int id;

	@Column(nullable = false)
	private String login;

	private Integer followers;
	private Integer following;
	private Integer size;
	private Integer stargazersCount;
	private Boolean isKorean;
	private String firstLanguage;
	private String secondLanguage;
	private String thirdLanguage;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
