package com.poc.iLoveGithubWeb.config.auth.dto;

import com.poc.iLoveGithubWeb.domain.member.Member;
import com.poc.iLoveGithubWeb.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Slf4j
@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;

    private int id;
    private String login;
    private String email;
    private String avatarUrl;
    private String type;
    private String name;
    private String company;
    private int publicRepos;
    private int followers;
    private int following;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, int id, String login, String email,
                           String avatarUrl, String type, String name, String company,
                           int publicRepos, int followers, int following, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
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
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        log.info("OAuthAttributes =={} {} {]", registrationId, userNameAttributeName, attributes.toString());

        return ofGithub(userNameAttributeName, attributes);

    }

    private static OAuthAttributes ofGithub(String userNameAttributeName, Map<String, Object> attributes) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

        return OAuthAttributes.builder()
                .id((int) attributes.get("id"))
                .login((String) attributes.get("login"))
                .email((String) attributes.get("email"))
                .avatarUrl((String) attributes.get("avatar_url"))
                .type((String) attributes.get("type"))
                .name((String) attributes.get("name"))
                .company((String) attributes.get("company"))
                .publicRepos((int) attributes.get("public_repos"))
                .followers((int) attributes.get("followers"))
                .following((int) attributes.get("following"))
                .createdAt(LocalDateTime.parse((String)attributes.get("created_at"), formatter))
                .updatedAt(LocalDateTime.parse((String)attributes.get("updated_at"), formatter))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }


    public Member toEntity() {
        return Member.builder()
                .id(id)
                .login(login)
                .email(email)
                .avatarUrl(avatarUrl)
                .type(type)
                .name(name)
                .company(company)
                .publicRepos(publicRepos)
                .followers(followers)
                .following(following)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .role(Role.GUEST)
                .build();
    }
}
