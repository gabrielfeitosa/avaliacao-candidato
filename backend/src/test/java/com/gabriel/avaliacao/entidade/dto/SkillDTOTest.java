package com.gabriel.avaliacao.entidade.dto;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.Skill;
import com.gabriel.avaliacao.entidade.SkillTipoEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gabriel on 21/04/17.
 */
public class SkillDTOTest {

    @Test
    public void deveConverterDtoParaEntidade(){
        SkillDTO dto = new SkillDTO();
        dto.setTipo(SkillTipoEnum.HTML);
        dto.setGrauConhecimento(5);
        Skill skill = dto.buildSkill();
        assertEquals(dto.getGrauConhecimento(), skill.getGrauConhecimento());
        assertEquals(dto.getTipo(), skill.getTipo());
    }
}
