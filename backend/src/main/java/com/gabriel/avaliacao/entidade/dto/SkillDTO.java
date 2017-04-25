package com.gabriel.avaliacao.entidade.dto;

import com.gabriel.avaliacao.entidade.Skill;
import com.gabriel.avaliacao.entidade.SkillTipoEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by gabriel on 21/04/17.
 */
@Getter
@Setter
public class SkillDTO {

    private SkillTipoEnum tipo;
    private int grauConhecimento;


    public Skill buildSkill() {
        return new Skill(tipo, grauConhecimento);
    }
}
