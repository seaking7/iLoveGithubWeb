package com.poc.ilovegithubweb.domain.rank.source;

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
@Table(name = "G_SourceRank")
public class SourceRank {

	@Id
	private int id;

	@Column(nullable = false)
	private String login;
	private int userId;
	private String name;
	private Integer size;
	private Integer stargazersCount;
	private String language;
	private Boolean isKorean;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime pushedAt;
}
