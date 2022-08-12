package com.poc.iLoveGithubWeb.infrastructure.board;

import com.poc.iLoveGithubWeb.domain.board.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
