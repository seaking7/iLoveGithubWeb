package com.poc.iLoveGithubWeb.domain.board;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "g_notice")
public class Notice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String hashtag;

    private String createdBy;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;


}
