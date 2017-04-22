package com.gabriel.avaliacao.entidade;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by gabriel on 21/04/17.
 */
@Getter
public class Candidato {

    public static final String MENSAGEM_VALIDACAO_NOME = "O nome do candidato é obrigatório";
    public static final String MENSAGEM_VALIDACAO_EMAIL = "O email é obrigatório";
    public static final String MENSAGEM_VALIDACAO_SKILL = "Não é possível cadastrar skill nulo";

    @NotNull
    @Size(min = 1)
    private String nome;
    @NotNull
    @Size(min = 1)
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-z]+")
    private String email;
    @Setter(AccessLevel.NONE)
    private List<Skill> skills = new ArrayList<>();

    public Candidato(String nome, String email) {
        Optional.ofNullable(nome).filter(n -> !n.isEmpty()).orElseThrow(
                () -> new IllegalArgumentException(MENSAGEM_VALIDACAO_NOME));
        Optional.ofNullable(email).filter(e -> !e.isEmpty()).orElseThrow(
                () -> new IllegalArgumentException(MENSAGEM_VALIDACAO_EMAIL));
        this.nome = nome;
        this.email = email;
    }

    public void adicionarSkill(Skill skill) {
        Optional.ofNullable(skill).orElseThrow(
                () -> new IllegalArgumentException(MENSAGEM_VALIDACAO_SKILL));
        skills.add(skill);
    }

}
