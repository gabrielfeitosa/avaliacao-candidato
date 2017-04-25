package com.gabriel.avaliacao.entidade.dto;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.SkillTipoEnum;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by gabriel on 21/04/17.
 */
public class CandidatoDTOTest {

    @Test
    public void deveConverterDtoParaEntidade(){
        CandidatoDTO dto = new CandidatoDTO();
        dto.setNome("Fulano");
        dto.setEmail("fulano@teste.com");
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setTipo(SkillTipoEnum.HTML);
        skillDTO.setGrauConhecimento(10);
        dto.getSkills().add(skillDTO);
        Candidato candidato = dto.buildCandidato();
        assertEquals(dto.getNome(), candidato.getNome());
        assertEquals(candidato.getSkills().size(), 1);
    }
}
