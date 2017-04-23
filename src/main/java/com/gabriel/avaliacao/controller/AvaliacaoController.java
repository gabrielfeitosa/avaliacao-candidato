package com.gabriel.avaliacao.controller;

import com.gabriel.avaliacao.entidade.dto.CandidatoDTO;
import com.gabriel.avaliacao.entidade.dto.MensagemDTO;
import com.gabriel.avaliacao.service.AvaliacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by gabriel on 21/04/17.
 */
@RestController
@RequestMapping(path = "/avaliacao", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AvaliacaoController {

    public static final String MENSAGEM_SUCESSO = "Enviado para avaliação!";

    private AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    public ResponseEntity<MensagemDTO> avaliar(@Valid @RequestBody CandidatoDTO candidatoDTO) {
        avaliacaoService.avaliar(candidatoDTO.buildCandidato());
        return new ResponseEntity<>(new MensagemDTO(MENSAGEM_SUCESSO), HttpStatus.OK);
    }

}
