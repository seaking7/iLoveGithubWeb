package com.poc.iLoveGithubWeb.application;

import com.poc.iLoveGithubWeb.domain.mail.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailFacade {
    private final MailService mailService;

    public void sendWelcomeMail(String toMail) throws MessagingException {

        mailService.sendWelcomeMail(toMail);
    }
}
