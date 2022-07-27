package com.poc.iLoveGithubWeb.config.auth.dto;

import com.poc.iLoveGithubWeb.domain.member.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private int id;
    private String login;
    private String email;
    private String avatarUrl;
    private String type;
    private String name;
    private String company;

    public SessionUser(Member member) {
        this.id = member.getId();
        this.login = member.getLogin();
        this.email = member.getEmail();
        this.avatarUrl = member.getAvatarUrl();
        this.type = member.getType();
        this.name = member.getName();
        this.company = member.getCompany();

    }
}
