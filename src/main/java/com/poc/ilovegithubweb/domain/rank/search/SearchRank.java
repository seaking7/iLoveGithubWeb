package com.poc.ilovegithubweb.domain.rank.search;

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
@Table(name = "g_search_rank")
public class SearchRank {

	@Id
	private int id;

	@Column(nullable = false)
	private String login;
	private String type;

	private Integer followers;
	private Integer following;
	private Integer searchCount;
	private Integer size;
	private Integer stargazersCount;
	private String firstLanguage;
	private String secondLanguage;
	private String thirdLanguage;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
