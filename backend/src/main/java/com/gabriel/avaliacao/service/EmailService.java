package com.gabriel.avaliacao.service;

import com.gabriel.avaliacao.entidade.Email;
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
    private boolean habilitar;

    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender,@Value("${email.from}") String emailFrom, @Value("${email.habilitar}") boolean habilitar) {
        this.javaMailSender = javaMailSender;
        this.emailFrom = emailFrom;
        this.habilitar = habilitar;
    }

    public void enviar(Email email) {
        if(habilitar){
            disparar(email);
        }else{
            imprimir(email);
        }
    }

    private void imprimir(Email email) {
        System.out.println("Enviando email para "+ email.getDestino());
        System.out.println("Assunto: "+ email.getAssunto());
        System.out.println("Conteúdo: "+ email.getConteudo());

    }

    private void disparar(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(email.getDestino());
        message.setSubject(email.getAssunto());
        message.setText(email.getConteudo());
        javaMailSender.send(message);
    }
}
