package com.poc.iLoveGithubWeb.domain.rank;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class SourceRankInfo {
    private int id;
    private String login;
    private String name;
    private int size;
    private int stargazersCount;
    private String language;
    private LocalDateTime pushedAt;


    public static SourceRankInfo from(SourceRank sourceRank){
        return SourceRankInfo.builder()
                .id(sourceRank.getId())
                .login(sourceRank.getLogin())
                .name(sourceRank.getName())
                .size(sourceRank.getSize())
                .stargazersCount(sourceRank.getStargazersCount())
                .language(sourceRank.getLanguage())
                .pushedAt(sourceRank.getPushedAt())
                .build();
    }
}
