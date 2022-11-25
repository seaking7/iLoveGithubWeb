package com.poc.ilovegithubweb.infrastructure.board;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.ilovegithubweb.domain.board.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
