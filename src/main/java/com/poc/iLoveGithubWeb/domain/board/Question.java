package com.poc.iLoveGithubWeb.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "g_question")
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String name;

    private String content;

    private String contentType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Builder
    public Question(String login, String name, String content, String contentType, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.login = login;
        this.name = name;
        this.content = content;
        this.contentType = contentType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
