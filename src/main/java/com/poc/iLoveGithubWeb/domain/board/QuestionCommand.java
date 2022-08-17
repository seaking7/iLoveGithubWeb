package com.poc.iLoveGithubWeb.domain.board;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

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
