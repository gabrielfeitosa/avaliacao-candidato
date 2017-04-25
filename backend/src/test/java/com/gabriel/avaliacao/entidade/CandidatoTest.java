package com.gabriel.avaliacao.entidade;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by gabriel on 21/04/17.
 */
public class CandidatoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void deveLancarExcecaoQuandoNomeNull(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Candidato.MENSAGEM_VALIDACAO_NOME);
        new Candidato(null,"");
    }

    @Test
    public void deveLancarExcecaoQuandoNomeVazio(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Candidato.MENSAGEM_VALIDACAO_NOME);
        new Candidato("","");
    }

    @Test
    public void deveLancarExcecaoQuandoEmailNull(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Candidato.MENSAGEM_VALIDACAO_EMAIL);
        new Candidato("Teste",null);
    }

    @Test
    public void deveLancarExcecaoQuandoEmailVazio(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Candidato.MENSAGEM_VALIDACAO_EMAIL);
        new Candidato("Teste","");
    }

    @Test
    public void deveLancarExcecaoQuandoEmailInvalido(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Candidato.MENSAGEM_FORMATO_EMAIL);
        new Candidato("Teste","teste");
    }


    @Test
    public void deveAdicionarSkills(){
        Candidato candidato = new Candidato("Teste", "teste@teste.com");
        Skill css = new Skill(SkillTipoEnum.CSS, 8);
        Skill javascript = new Skill(SkillTipoEnum.JAVASCRIPT, 10);
        candidato.adicionarSkill(css);
        candidato.adicionarSkill(javascript);
        assertEquals(2, candidato.getSkills().size());
        assertThat(candidato.getSkills(), hasItems(css, javascript));
    }

    @Test
    public void deveLancarExecaoAoAdicionarSkillNulo(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Candidato.MENSAGEM_VALIDACAO_SKILL);
        Candidato candidato = new Candidato("Teste", "teste@teste.com");
        candidato.adicionarSkill(null);
    }

}
