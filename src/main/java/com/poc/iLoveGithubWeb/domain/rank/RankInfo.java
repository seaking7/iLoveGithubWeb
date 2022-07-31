package com.poc.iLoveGithubWeb.domain.rank;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RankInfo {
    private int id;
    private String login;
    private int followers;
    private int following;
    private int size;
    private int stargazersCount;
    private LocalDateTime updatedAt;

}
