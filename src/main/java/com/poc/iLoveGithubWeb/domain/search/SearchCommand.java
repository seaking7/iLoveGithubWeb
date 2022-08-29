package com.poc.iLoveGithubWeb.domain.search;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class SearchCommand {
    private String ip;
    private String login;
    private String menu;
    private int searchId;
    private String searchLogin;
    private String sortBy;
    private String languageBy;
    private int page;
    private int size;


    public SearchResult toEntity() {
        return SearchResult.builder()
                .ip(ip)
                .login(login)
                .menu(menu)
                .searchId(searchId)
                .searchLogin(searchLogin)
                .sortBy(sortBy)
                .languageBy(languageBy)
                .page(page)
                .size(size)
                .createdAt(LocalDateTime.now())
                .build();
    }

}
