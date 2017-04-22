package com.gabriel.avaliacao.service;

import com.gabriel.avaliacao.entidade.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by gabriel on 21/04/17.
 */
@Service
public class EmailService {

    private String emailFrom;

    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender,@Value("${email.from}") String emailFrom) {
        this.javaMailSender = javaMailSender;
        this.emailFrom = emailFrom;
    }

    public void enviar(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(email.getDestino());
        message.setSubject(email.getAssunto());
        message.setText(email.getConteudo());
        javaMailSender.send(message);
    }
}
