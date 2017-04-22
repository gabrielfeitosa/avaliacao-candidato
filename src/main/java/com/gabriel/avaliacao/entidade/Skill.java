package com.gabriel.avaliacao.entidade;

import lombok.Getter;

import java.util.Optional;

/**
 * Created by gabriel on 21/04/17.
 */
@Getter
public class Skill {

    public static final String MENSAGEM_VALIDACAO_TIPO = "O tipo do skill é obrigatório";
    public static final String MENSAGEM_VALIDACAO_GRAU_CONHECIMENTO = "O grau de conhecimento deve ser entre 0 e 10";

    private final SkillTipoEnum tipo;
    private final int grauConhecimento;

    public Skill(SkillTipoEnum tipo, int grauConhecimento) {
        Optional.ofNullable(tipo).orElseThrow(
                () -> new IllegalArgumentException(MENSAGEM_VALIDACAO_TIPO));
        if(grauConhecimento < 0 || grauConhecimento > 10){
            throw new IllegalArgumentException(MENSAGEM_VALIDACAO_GRAU_CONHECIMENTO);
        }
        this.tipo = tipo;
        this.grauConhecimento = grauConhecimento;
    }


}
