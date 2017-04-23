package com.gabriel.avaliacao.controller;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.SkillTipoEnum;
import com.gabriel.avaliacao.entidade.dto.CandidatoDTO;
import com.gabriel.avaliacao.service.AvaliacaoService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by gabriel on 21/04/17.
 */
public class SkillControllerTest {

    private SkillController skillController;

    @Before
    public void setUp() {
        skillController = new SkillController();
    }

    @Test
    public void deveListarOsSkills(){
        ResponseEntity<List<SkillTipoEnum>> resposta = skillController.listarSkills();
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        List<SkillTipoEnum> skills = resposta.getBody();
        assertEquals(skills.size(), SkillTipoEnum.values().length);
        assertThat(skills, Matchers.contains(SkillTipoEnum.values()));
    }

}
