package com.poc.ilovegithubweb.domain.board;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuestionCommand {
	private String login;
	private String name;
	private String contentType;
	private String content;

	public Question toEntity() {
		return Question.builder()
			.login(login)
			.name(name)
			.content(content)
			.contentType(contentType)
			.createdAt(LocalDateTime.now())
			.build();
	}
}
