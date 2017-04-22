package com.gabriel.avaliacao.service.perfil;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.Skill;
import com.gabriel.avaliacao.entidade.SkillTipoEnum;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gabriel on 21/04/17.
 */
public class PerfilFrontendTest {

    private Perfil perfil = new PerfilFrontend();

    @Test
    public void deveTerOPerfil(){
        Candidato candidato = new Candidato("Teste", "teste@teste.com");
        candidato.adicionarSkill(new Skill(SkillTipoEnum.HTML, 7));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.CSS, 9));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.JAVASCRIPT, 8));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.DJANGO, 6));
        Assert.assertTrue(perfil.validar(candidato));
    }

    @Test
    public void naoDeveTerOPerfil(){
        Candidato candidato = new Candidato("Teste", "teste@teste.com");
        candidato.adicionarSkill(new Skill(SkillTipoEnum.HTML, 7));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.CSS, 9));
        candidato.adicionarSkill(new Skill(SkillTipoEnum.DJANGO, 6));
        Assert.assertFalse(perfil.validar(candidato));
    }
}
