package com.poc.ilovegithubweb.application;

import org.springframework.stereotype.Service;

import com.poc.ilovegithubweb.domain.board.BoardService;
import com.poc.ilovegithubweb.domain.board.QuestionCommand;
import com.poc.ilovegithubweb.domain.mail.MailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardFacade {
	private final BoardService boardService;

	private final MailService mailService;

	public Long saveQuestion(QuestionCommand questionCommand) {
		//        mailService.sendEmail("seaking7@gmail.com", "iloveGithub Q&A", questionCommand.getContent());
		return boardService.saveQuestion(questionCommand);
	}
}
