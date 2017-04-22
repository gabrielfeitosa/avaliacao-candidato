package com.gabriel.avaliacao.entidade;

import java.util.Optional;

/**
 * Created by gabriel on 21/04/17.
 */

public class Email {

    public static final String MENSAGEM_VALIDACAO_CANDIDATO = "O candidato é obrigatório";
    public static final String MENSAGEM_VALIDACAO_PERFIL = "O perfil é obrigatório";

    public final static String CONTEUDO_TEMPLATE = " Obrigado por se candidatar, assim que tivermos uma vaga disponível para programador {PERFIL} entraremos em contato";
    private String assunto = "Obrigado por se candidatar";
    private Candidato candidato;
    private String conteudo;

    public Email(Candidato candidato, PerfilEnum perfil){
        Optional.ofNullable(candidato).orElseThrow(
                () -> new IllegalArgumentException(MENSAGEM_VALIDACAO_CANDIDATO));
        Optional.ofNullable(perfil).orElseThrow(
                () -> new IllegalArgumentException(MENSAGEM_VALIDACAO_PERFIL));
        this.candidato = candidato;
        this.conteudo = CONTEUDO_TEMPLATE.replace("{PERFIL}", perfil.getDescricao());
    }

    public String getAssunto() {
        return assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getDestino() {
        return candidato.getEmail();
    }
}
