package com.poc.ilovegithubweb.domain.search;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
@Entity
@Table(name = "g_search_result")
public class SearchResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ip;
	private String login;

	private String menu;

	private int searchId;
	private String searchLogin;
	private String sortBy;
	private String languageBy;

	private int size;
	private int page;
	private LocalDateTime createdAt;

	@Builder
	public SearchResult(Long id, String ip, String login, String menu, int searchId, String searchLogin, String sortBy,
		String languageBy, int size, int page, LocalDateTime createdAt) {
		this.id = id;
		this.ip = ip;
		this.login = login;
		this.menu = menu;
		this.searchId = searchId;
		this.searchLogin = searchLogin;
		this.sortBy = sortBy;
		this.languageBy = languageBy;
		this.size = size;
		this.page = page;
		this.createdAt = createdAt;
	}
}
