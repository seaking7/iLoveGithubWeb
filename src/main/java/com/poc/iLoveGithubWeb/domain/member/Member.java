package com.poc.iLoveGithubWeb.domain.member;

import com.poc.iLoveGithubWeb.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "g_member")
public class Member {

    @Id
    private int id;

    @Column(nullable = false)
    private String login;

    @Column
    private String email;
    @Column
    private String avatarUrl;
    @Column
    private String type;
    @Column
    private String name;
    @Column
    private String company;
    private int publicRepos;
    private int followers;
    private int following;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Member(int id, String login, String email, String avatarUrl, String type, String name,
                  String company, int publicRepos, int followers, int following, LocalDateTime createdAt, LocalDateTime updatedAt, Role role) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.type = type;
        this.name = name;
        this.company = company;
        this.publicRepos = publicRepos;
        this.followers = followers;
        this.following = following;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

    public Member update(String email, String avatarUrl) {
        this.email = email;
        this.avatarUrl = avatarUrl;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
