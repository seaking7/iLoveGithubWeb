package com.poc.ilovegithubweb.domain.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {

	private final JavaMailSender mailSender;

	public void sendWelcomeMail(String toMail) throws MessagingException {
		String subject = "[환영] ilovegithub 에 가입해주셔서 감사합니다.";

		String body = "<!DOCTYPE html>\n"
			+ "</html>";
		sendEmailHtml(toMail, subject, body);
	}

	// String 형태로 메일전송
	public void sendEmail(String toAddress, String subject, String msgBody) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(toAddress);
		smm.setSubject(subject);
		smm.setText(msgBody);

		mailSender.send(smm);
	}

	// Html 형태로 메일전송
	public void sendEmailHtml(String toAddress, String subject, String msgBody) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		mimeMessage.setSubject(subject);
		mimeMessage.setText(msgBody, "UTF-8", "html");
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));

		mailSender.send(mimeMessage);
	}
}
