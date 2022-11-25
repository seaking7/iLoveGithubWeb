package com.poc.ilovegithubweb.application;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.poc.ilovegithubweb.domain.mail.MailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailFacade {
	private final MailService mailService;

	public void sendWelcomeMail(String toMail) throws MessagingException {

		mailService.sendWelcomeMail(toMail);
	}
}
