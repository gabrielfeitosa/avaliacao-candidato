package com.gabriel.avaliacao.service;

import com.gabriel.avaliacao.entidade.*;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by gabriel on 21/04/17.
 */
public class AvaliacaoServiceTest {

    private AvaliacaoService avaliacaoService;

    @Mock
    private EmailService emailService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        avaliacaoService = new AvaliacaoService(emailService);
    }

    @Test
    public void candidatoDeveTerPerfilGenericoQuandoNaoEnviouListaDeSkills() {
        Candidato candidato = new Candidato("Genérico", "generico@test.com");
        doNothing().when(emailService).enviar(any(Email.class));
        avaliacaoService.avaliar(candidato);
        ArgumentCaptor<Email> captor = ArgumentCaptor.forClass(Email.class);
        verify(emailService, times(1)).enviar(captor.capture());
        assertEquals(candidato.getEmail(), captor.getValue().getDestino());
        assertEquals(Email.CONTEUDO_TEMPLATE.replace("{PERFIL}", PerfilEnum.GENERICO.getDescricao()), captor.getValue().getConteudo());
    }

    @Test
    public void candidatoDeveTerPerfilGenericoQuandoGrauDeConhecimentoMenorQueSete() {
        Candidato candidato = new Candidato("Genérico", "generico@test.com");
        candidato.adicionarSkill(new Skill(SkillTipoEnum.IOS, 4));
        doNothing().when(emailService).enviar(any(Email.class));
        avaliacaoService.avaliar(candidato);
        ArgumentCaptor<Email> captor = ArgumentCaptor.forClass(Email.class);
        verify(emailService, times(1)).enviar(captor.capture());
        assertEquals(candidato.getEmail(), captor.getValue().getDestino());
        assertEquals(Email.CONTEUDO_TEMPLATE.replace("{PERFIL}", PerfilEnum.GENERICO.getDescricao()), captor.getValue().getConteudo());
    }
    @Test
    public void candidatoDeveTerOsPerfisDeFrontendBackendMobile() {
        Candidato candidato = new Candidato("Fulano", "fulano@test.com");

        candidato.adicionarSkill(new Skill(SkillTipoEnum.DJANGO, 7));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.PYTHON, 10));

        candidato.adicionarSkill(new Skill(SkillTipoEnum.HTML, 7));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.CSS, 9));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.JAVASCRIPT, 8));

        candidato.adicionarSkill(new Skill(SkillTipoEnum.ANDROID, 10));

        doNothing().when(emailService).enviar(any(Email.class));
        avaliacaoService.avaliar(candidato);
        ArgumentCaptor<Email> captor = ArgumentCaptor.forClass(Email.class);
        verify(emailService, times(3)).enviar(captor.capture());
        assertThat(captor.getAllValues(), everyItem(Matchers.hasProperty("destino", containsString(candidato.getEmail()))));
    }
}
