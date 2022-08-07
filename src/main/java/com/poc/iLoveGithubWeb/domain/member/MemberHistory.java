package com.poc.iLoveGithubWeb.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "g_member_history")
public class MemberHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String login;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime loginAt;

    @Builder
    public MemberHistory(int id, String login, LocalDateTime loginAt) {
        this.id = id;
        this.login = login;
        this.loginAt = loginAt;
    }
}
