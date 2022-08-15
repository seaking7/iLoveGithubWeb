package com.poc.iLoveGithubWeb.domain.rank;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class UserRankInfo {
    private int id;
    private String login;
    private int followers;
    private int following;
    private int size;
    private int stargazersCount;
    private String firstLanguage;
    private String secondLanguage;
    private String thirdLanguage;
    private LocalDateTime updatedAt;

    public static UserRankInfo from(UserRank userRank){

        return UserRankInfo.builder()
                .id(userRank.getId())
                .login(userRank.getLogin())
                .followers(userRank.getFollowers())
                .following(userRank.getFollowing())
                .size(userRank.getSize())
                .stargazersCount(userRank.getStargazersCount())
                .firstLanguage(userRank.getFirstLanguage())
                .secondLanguage(userRank.getSecondLanguage())
                .thirdLanguage(userRank.getThirdLanguage())
                .updatedAt(userRank.getUpdatedAt())
                .build();
    }


}
