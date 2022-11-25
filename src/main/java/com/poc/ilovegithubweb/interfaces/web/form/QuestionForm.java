package com.poc.ilovegithubweb.interfaces.web.form;

import com.poc.ilovegithubweb.domain.board.QuestionCommand;

import lombok.Data;

@Data
public class QuestionForm {
	private String login;
	private String name;
	private String contentType;
	private String content;

	public QuestionCommand toCommand() {
		return QuestionCommand.builder()
			.login(login)
			.name(name)
			.contentType(contentType)
			.content(content)
			.build();
	}
}
