package com.gabriel.avaliacao.controller;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.Skill;
import com.gabriel.avaliacao.entidade.SkillTipoEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by gabriel on 21/04/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AvaliacaoControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/avaliacao");
    }

    @Test
    public void deveAvaliarCandidato(){
        Candidato candidato = new Candidato("teste","teste@teste.com");
        for(SkillTipoEnum tipo: SkillTipoEnum.values()){
            candidato.adicionarSkill(new Skill(tipo, 10));
        }
        ResponseEntity<String> response = template.postForEntity(base.toString(), candidato, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody(), equalTo(AvaliacaoController.MENSAGEM_SUCESSO));
    }
}
