package com.gabriel.avaliacao.controller;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.dto.CandidatoDTO;
import com.gabriel.avaliacao.entidade.dto.MensagemDTO;
import com.gabriel.avaliacao.service.AvaliacaoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by gabriel on 21/04/17.
 */
public class AvaliacaoControllerTest {

    private AvaliacaoController avaliacaoController;

    @Mock
    private AvaliacaoService avaliacaoService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        avaliacaoController = new AvaliacaoController(avaliacaoService);
    }

    @Test
    public void deveAvaliarCandidato(){
        CandidatoDTO candidato = new CandidatoDTO();
        candidato.setNome("Teste");
        candidato.setEmail("teste@teste.com");
        doNothing().when(avaliacaoService).avaliar(any());
        ResponseEntity<MensagemDTO> resposta = avaliacaoController.avaliar(candidato);
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(resposta.getBody().getMensagem(), AvaliacaoController.MENSAGEM_SUCESSO);
        verify(avaliacaoService).avaliar(any(Candidato.class));
    }

}
