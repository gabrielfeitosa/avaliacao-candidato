package com.gabriel.avaliacao.entidade;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by gabriel on 21/04/17.
 */
public class SkillTest {

    private Skill skill;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void deveLancarExcecaoQuandoTipoDoSkillNulo(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Skill.MENSAGEM_VALIDACAO_TIPO);
        new Skill(null,0);
    }

    @Test
    public void deveLancarExcecaoQuandoGrauDeConhecimentoMenorQueZero(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Skill.MENSAGEM_VALIDACAO_GRAU_CONHECIMENTO);
        new Skill(SkillTipoEnum.CSS,-1);
    }

    @Test
    public void deveLancarExcecaoQuandoGrauDeConhecimentoMaiorQueDez(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Skill.MENSAGEM_VALIDACAO_GRAU_CONHECIMENTO);
        new Skill(SkillTipoEnum.PYTHON,20);
    }

    @Test
    public void deveCriarSkill(){
        Assert.assertNotNull(new Skill(SkillTipoEnum.PYTHON,10));
    }

}
