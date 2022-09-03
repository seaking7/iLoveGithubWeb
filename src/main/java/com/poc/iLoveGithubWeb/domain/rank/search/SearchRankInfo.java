package com.poc.iLoveGithubWeb.domain.rank.search;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class SearchRankInfo {
    private int id;
    private String login;
    private String type;
    private Integer followers;
    private Integer following;
    private Integer searchCount;
    private Integer size;
    private Integer stargazersCount;
    private String firstLanguage;
    private String secondLanguage;
    private String thirdLanguage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static SearchRankInfo from(SearchRank searchRank){

        return SearchRankInfo.builder()
                .id(searchRank.getId())
                .login(searchRank.getLogin())
                .type(searchRank.getType())
                .followers(searchRank.getFollowers())
                .following(searchRank.getFollowing())
                .searchCount(searchRank.getSearchCount())
                .size(searchRank.getSize())
                .stargazersCount(searchRank.getStargazersCount())
                .firstLanguage(searchRank.getFirstLanguage())
                .secondLanguage(searchRank.getSecondLanguage())
                .thirdLanguage(searchRank.getThirdLanguage())
                .createdAt(searchRank.getCreatedAt())
                .updatedAt(searchRank.getUpdatedAt())
                .build();
    }


}
