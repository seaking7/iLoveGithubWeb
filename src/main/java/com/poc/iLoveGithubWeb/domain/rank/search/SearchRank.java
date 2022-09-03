package com.poc.iLoveGithubWeb.domain.rank.search;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "g_search_rank")
public class SearchRank {

    @Id
    private int id;

    @Column(nullable = false)
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
}
