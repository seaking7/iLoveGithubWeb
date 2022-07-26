package com.poc.iLoveGithubWeb.domain.rank;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SourceRankInfo {
    private int id;
    private String login;
    private String name;
    private int size;
    private int stargazersCount;
    private String language;
    private LocalDateTime pushedAt;
}
