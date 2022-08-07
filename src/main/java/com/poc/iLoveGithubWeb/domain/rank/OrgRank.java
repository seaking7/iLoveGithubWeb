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
@Table(name = "G_orgRank")
public class OrgRank {

    @Id
    private int id;

    @Column(nullable = false)
    private String login;

    private Integer peopleCount;
    private Integer size;
    private Integer stargazersCount;
    private Boolean isKorean;
    private String mainLanguage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}