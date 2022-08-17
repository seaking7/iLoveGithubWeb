package com.poc.iLoveGithubWeb.domain.member;

import com.poc.iLoveGithubWeb.config.auth.dto.OAuthAttributes;
import com.poc.iLoveGithubWeb.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@Getter
@NoArgsConstructor
@Entity
@Table(name = "g_member")
public class Member {

    @Id
    private int id;

    @Column(nullable = false)
    private String login;

    private String status;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private String type;
    private String blog;
    @Column
    private String company;
    private String location;
    @Column
    private String email;
    private String bio;
    private int publicRepos;
    private int followers;
    private int following;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime joinedAt;
    private LocalDateTime lastLoginAt;


    @Builder
    public Member(int id, String login, String status, String name, Role role, String type, String blog, String company, String location,
                   String email, String bio, int publicRepos, int followers, int following,
                  LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime joinedAt, LocalDateTime lastLoginAt ) {
        this.id = id;
        this.login = login;
        this.status = status;
        this.name = name;
        this.role = role;
        this.type = type;
        this.blog = blog;
        this.company = company;
        this.location = location;
        this.email = email;
        this.bio = bio;
        this.publicRepos = publicRepos;
        this.followers = followers;
        this.following = following;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.joinedAt = joinedAt;
        this.lastLoginAt = lastLoginAt;
    }

    // 가입 이후 로그인시 호출
    public Member update(OAuthAttributes attributes) {

        this.name = attributes.getName();
        this.type = attributes.getType();
        this.blog = attributes.getBlog();
        this.company = attributes.getCompany();
        this.location = attributes.getLocation();
        this.email = attributes.getEmail();
        this.bio = attributes.getBio();
        this.publicRepos = attributes.getPublicRepos();
        this.followers = attributes.getFollowers();
        this.following = attributes.getFollowing();
        this.createdAt = attributes.getCreatedAt();
        this.updatedAt = attributes.getUpdatedAt();
        this.lastLoginAt = LocalDateTime.now();
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
