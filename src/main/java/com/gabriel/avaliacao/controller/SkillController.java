package com.gabriel.avaliacao.controller;

import com.gabriel.avaliacao.entidade.SkillTipoEnum;
import com.gabriel.avaliacao.entidade.dto.CandidatoDTO;
import com.gabriel.avaliacao.service.AvaliacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gabriel on 21/04/17.
 */
@RestController
@RequestMapping(path = "/skill")
public class SkillController {

    @GetMapping
    public ResponseEntity<List<SkillTipoEnum>> listarSkills() {
        return new ResponseEntity<>(Arrays.asList(SkillTipoEnum.values()), HttpStatus.OK);
    }

}
