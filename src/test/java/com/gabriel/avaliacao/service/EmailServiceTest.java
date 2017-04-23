package com.gabriel.avaliacao.service;

import com.gabriel.avaliacao.entidade.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by gabriel on 21/04/17.
 */
public class EmailServiceTest {

    private EmailService emailService;

    @Mock
    private JavaMailSender javaMailSender;
    private final String emailFrom = "teste@teste.com";
    private final boolean habilitar = true;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        emailService = new EmailService(javaMailSender, emailFrom, habilitar);
    }

    @Test
    public void deveEnviarEmail() {
        Email email = new Email(new Candidato("Teste", "fulano@teste.com"), PerfilEnum.FRONTEND);
        doNothing().when(javaMailSender).send(any(SimpleMailMessage.class));
        emailService.enviar(email);
        ArgumentCaptor<SimpleMailMessage> captor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(javaMailSender, times(1)).send(captor.capture());
        SimpleMailMessage emailEnviado = captor.getValue();
        assertEquals(emailFrom, emailEnviado.getFrom());
        assertThat(Arrays.asList(emailEnviado.getTo()), hasItems(email.getDestino()));
        assertEquals(email.getAssunto(), emailEnviado.getSubject());
        assertEquals(Email.CONTEUDO_TEMPLATE.replace("{PERFIL}", PerfilEnum.FRONTEND.getDescricao()), emailEnviado.getText());
    }
}
