package com.poc.iLoveGithubWeb.domain.rank;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class OrgRankInfo {
    private int id;
    private String login;
    private int peopleCount;
    private int size;
    private int stargazersCount;
    private LocalDateTime updatedAt;

    public static OrgRankInfo from(OrgRank orgRank){
        return OrgRankInfo.builder()
                .id(orgRank.getId())
                .login(orgRank.getLogin())
                .peopleCount(orgRank.getPeopleCount())
                .size(orgRank.getSize())
                .stargazersCount(orgRank.getStargazersCount())
                .updatedAt(orgRank.getUpdatedAt())
                .build();
    }
}
