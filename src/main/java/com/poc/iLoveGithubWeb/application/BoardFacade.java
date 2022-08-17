package com.poc.iLoveGithubWeb.application;

import com.poc.iLoveGithubWeb.domain.board.BoardService;
import com.poc.iLoveGithubWeb.domain.board.QuestionCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardFacade {
    private final BoardService boardService;

    public Long saveQuestion(QuestionCommand questionCommand) {
        return boardService.saveQuestion(questionCommand);
    }
}
