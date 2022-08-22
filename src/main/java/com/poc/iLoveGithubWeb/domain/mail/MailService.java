package com.poc.iLoveGithubWeb.domain.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    public void sendWelcomeMail(String toMail) throws MessagingException {
        String subject = "[환영] ilovegithub 에 가입해주셔서 감사합니다.";

        String body = "<!DOCTYPE html>\n" +
                "<html lang=\"kr\">\n" +
                "<header>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx\" crossorigin=\"anonymous\">\n" +
                "</header>\n" +
                "<body>\n" +
                "<main>\n" +
                "      <div class=\"row\">\n" +
                "        <div class=\"col-12 vstack gap-4\">\n" +
                "          <div class=\"card border p-sm-4\">\n" +
                "            <div class=\"alert alert-success border-0 py-2\">\n" +
                "              <nav aria-label=\"breadcrumb\">\n" +
                "                <ol class=\"breadcrumb breadcrumb-dots mb-2\">\n" +
                "                  <li class=\"breadcrumb-item\"><a href=\"http://www.ilovegithub.com\"><i class=\"bi bi-house me-1\"></i> Home</a></li>\n" +
                "                  <li class=\"breadcrumb-item\"><a href=\"http://www.ilovegithub.com/member/question\"><i class=\"bi bi-info-circle me-1\"></i> Help</a></li>\n" +
                "                  <li class=\"breadcrumb-item active\">Get started with i Love Github</li>\n" +
                "                </ol>\n" +
                "              </nav>\n" +
                "              <h2>i Love Github 에 가입하신 것을 환영합니다.</h2>\n" +
                "            </div>\n" +
                "            <div class=\"card-body\">\n" +
                "              <h5 class=\"mt-4\">서비스 소개</h5>\n" +
                "              <p><strong>Github를 혹시 오픈소스를 다운만 받는 사이트로 알고 계시나요?</strong></p>\n" +
                "              <p>인터넷이 정보의 무한한 바다인 것과 같이, Github는 <strong>무한한 소스의 바다</strong>이며, 개발자들이 참고하고 학습하기에 가장 좋은 참고서 역할을 할 수 있습니다.<br>\n" +
                "                그런데, 나의 수준에 맞는 소스를 찾기가 어렵고 소스를 올리고 협업하는데 초점이 맞춰져 있는 사이트이다보니, 잘 활용이 안되고 있는 현실입니다.<br>\n" +
                "                <strong>이에 iLoveGithub 서비스에서는 Github의 유저, 조직, 소스들의 정보를 다양한 조건으로 검색할 수 있게 제공합니다.</strong></p>\n" +
                "              <p><string>참고해주세요.</string></p>\n" +
                "              <ul>\n" +
                "                <li>Github의 OpenAPI 동시 처리건수 제한으로 인해, 현재 Github 전체 회원 정보 수집에 시간이 소요되고 있습니다.</li>\n" +
                "                <li>2022.08.17일 기준으로, 2015년 이전 Github에 가입된 3천만명에 대한 회원, 조직, 소스랭킹이 제공되고 있습니다. 곧, 전체 1억명의 Github유저 랭킹을 제공할 예정입니다.</li>\n" +
                "                <li>한국인 여부는 Github에서 제공하지 않고, Github에서 제공된 개인의 blog, email, location 정보 등을 통해 추정하여 한국인 랭킹을 제공합니다.</li>\n" +
                "                <li>회원랭킹은 저희 사이트에서 Github 간편로그인을 한번 이상 수행한 회원들의 랭킹을 제공하여, 회원끼리 경쟁 등 재미요소를 느낄 수 있도록 제공합니다.</li>\n" +
                "                <li>글로벌랭킹, 한국인랭킹은 1일 1회 랭킹을 갱신하고, 회원랭킹은 1시간마다 한번씩 랭킹을 갱신합니다. </li>\n" +
                "                <li>유저 및 조직랭킹의 Main Language 는 보유한 Repository 중 별을 많이 받은 개발언어를 주요 개발언어로 판단하여 표시합니다.</li>\n" +
                "              </ul>\n" +
                "              <p> 처음부터 Spring, Linux 등 복잡한 오픈소스를 받아서 학습하면, 어렵고 쉽게 지치게 됩니다. 자신의 수준에 맞는 오픈소스를 찾아 살펴보시는 것을 추천드립니다.<br>\n" +
                "                Repository의 생성일, 수정일 등을 참고하여 너무 오래된 소스보다 최근에도 활발하게 Update되고 있는 소스를 학습하시고, 오픈소스에 기여도 해 보세요~<br>\n" +
                "                <a href=\"http://www.ilovegithub.com\"><strong>iLoveGithub</strong></a> 를 통해 당신의 개발실력 향상에 조금이라도 도움이 되기를 기대합니다.</p>\n" +
                "              <div class=\"alert alert-warning\" role=\"alert\">\n" +
                "                <strong>Note: </strong>서비스 제휴 및 개선요청 사항은 \"문의 및 건의사항\"을 통해 보내주시면, 빠른 시간안에 확인하도록 하겠습니다.\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "  </div>\n" +
                "</main>\n" +
                "</body>\n" +
                "</html>";
        sendEmailHtml(toMail, subject, body);
    }

    // String 형태로 메일전송
    public void sendEmail(String toAddress, String subject, String msgBody){
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
