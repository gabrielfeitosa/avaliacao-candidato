package com.gabriel.avaliacao.entidade;

/**
 * Created by gabriel on 21/04/17.
 */
public enum PerfilEnum {

    FRONTEND("Front-End"),
    BACKEND("Back-End"),
    MOBILE("Mobile"),
    GENERICO("");

    private String descricao;

    PerfilEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
