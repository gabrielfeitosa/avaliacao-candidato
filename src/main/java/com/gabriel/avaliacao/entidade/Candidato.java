package com.gabriel.avaliacao.entidade;

import com.gabriel.avaliacao.service.EmailValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;

/**
 * Created by gabriel on 21/04/17.
 */
@Getter
public class Candidato {

    public static final String MENSAGEM_VALIDACAO_NOME = "O nome do candidato é obrigatório";
    public static final String MENSAGEM_VALIDACAO_EMAIL = "O email é obrigatório";
    public static final String MENSAGEM_VALIDACAO_SKILL = "Não é possível cadastrar skill nulo";
    public static final String MENSAGEM_FORMATO_EMAIL = "Email no formato inválido";

    @NotNull
    @Size(min = 1)
    private String nome;
    @NotNull
    @Size(min = 1)
    @Pattern(regexp = EmailValidator.EMAIL_PATTERN)
    private String email;
    @Setter(AccessLevel.NONE)
    private List<Skill> skills = new ArrayList<>();
    private java.util.regex.Pattern pattern;

    public Candidato(String nome, String email) {
        Optional.ofNullable(nome).filter(n -> !n.isEmpty()).orElseThrow(
                () -> new IllegalArgumentException(MENSAGEM_VALIDACAO_NOME));
        Optional.ofNullable(email).filter(e -> !e.isEmpty()).orElseThrow(
                () -> new IllegalArgumentException(MENSAGEM_VALIDACAO_EMAIL));
        if (!EmailValidator.validar(email)) {
            throw new IllegalArgumentException(MENSAGEM_FORMATO_EMAIL);
        }
        this.nome = nome;
        this.email = email;
    }

    public void adicionarSkill(Skill skill) {
        Optional.ofNullable(skill).orElseThrow(
                () -> new IllegalArgumentException(MENSAGEM_VALIDACAO_SKILL));
        skills.add(skill);
    }

}
