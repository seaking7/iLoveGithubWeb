package com.poc.ilovegithubweb.infrastructure.board;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.ilovegithubweb.domain.board.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
