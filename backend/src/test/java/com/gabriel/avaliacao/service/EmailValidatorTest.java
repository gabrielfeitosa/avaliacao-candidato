package com.gabriel.avaliacao.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by gabriel on 23/04/17.
 */
public class EmailValidatorTest {

    @Test
    public void deveValidarEmails() {
        List<String> emails = Arrays.asList("teste@teste.com", "te87ste@teste.com.br", "teste_teste@teste.com.br", "teste.teste@teste.com.br");
        for (String temp : emails) {
            assertTrue(EmailValidator.validar(temp));
        }

    }

    @Test
    public void deveInvalidarEmails() {
        List<String> emails = Arrays.asList("teste", "teste@teste", "teste-teste@teste.");
        for (String temp : emails) {
            assertFalse(EmailValidator.validar(temp));
        }

    }

}
