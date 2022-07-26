package com.poc.iLoveGithubWeb.domain.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRepoInfo {
    private int id;
    private String login;
    private String name;
    private int size;
    private int stargazersCount;
    private String language;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime pushedAt;
}
