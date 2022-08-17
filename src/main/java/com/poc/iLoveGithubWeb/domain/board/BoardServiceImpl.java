package com.poc.iLoveGithubWeb.domain.board;

import com.poc.iLoveGithubWeb.infrastructure.board.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final QuestionRepository questionRepository;

    @Override
    public Long saveQuestion(QuestionCommand questionCommand) {
        Question question = new Question();
        question = questionCommand.toEntity();
        Question saved = questionRepository.save(question);
        return saved.getId();
    }
}
