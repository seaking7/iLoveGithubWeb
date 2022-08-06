package com.poc.iLoveGithubWeb.domain.rank;

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
@Table(name = "G_SourceRank")
public class SourceRank {

    @Id
    private int id;

    @Column(nullable = false)
    private String login;

    private String name;
    private Integer size;
    private Integer stargazersCount;
    private String language;
    private Boolean isKorean;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime pushedAt;
}
