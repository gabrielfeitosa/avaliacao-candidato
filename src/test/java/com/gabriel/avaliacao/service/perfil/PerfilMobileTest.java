package com.gabriel.avaliacao.service.perfil;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.Skill;
import com.gabriel.avaliacao.entidade.SkillTipoEnum;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gabriel on 21/04/17.
 */
public class PerfilMobileTest {

    private Perfil perfil = new PerfilMobile();

    @Test
    public void deveTerOPerfil(){
        Candidato candidato = new Candidato("Teste", "teste@teste.com");
        candidato.adicionarSkill(new Skill(SkillTipoEnum.ANDROID, 10));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.IOS, 6));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.CSS, 9));
        Assert.assertTrue(perfil.validar(candidato));
    }

    @Test
    public void naoDeveTerOPerfil(){
        Candidato candidato = new Candidato("Teste", "teste@teste.com");
        candidato.adicionarSkill(new Skill(SkillTipoEnum.ANDROID, 5));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.IOS, 6));
        Assert.assertFalse(perfil.validar(candidato));
    }
}
