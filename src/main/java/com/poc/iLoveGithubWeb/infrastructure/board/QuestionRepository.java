package com.poc.iLoveGithubWeb.infrastructure.board;

import com.poc.iLoveGithubWeb.domain.board.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
