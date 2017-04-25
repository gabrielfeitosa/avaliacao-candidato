package com.gabriel.avaliacao.entidade;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by gabriel on 21/04/17.
 */
public class EmailTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void deveLancarExcecaoQuandoCandidatoNulo(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Email.MENSAGEM_VALIDACAO_CANDIDATO);
        new Email(null, PerfilEnum.FRONTEND);
    }

    @Test
    public void deveLancarExcecaoQuandoPerfilNulo(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Email.MENSAGEM_VALIDACAO_PERFIL);
        new Email(new Candidato("Teste", "teste@teste.com"), null);
    }

    @Test
    public void deveCriarEmail(){
        assertNotNull(new Email(new Candidato("Teste", "teste@teste.com"), PerfilEnum.FRONTEND));
    }

}
