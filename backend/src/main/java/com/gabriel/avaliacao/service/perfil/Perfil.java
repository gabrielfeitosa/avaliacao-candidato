package com.gabriel.avaliacao.service.perfil;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.PerfilEnum;
import com.gabriel.avaliacao.entidade.Skill;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by gabriel on 21/04/17.
 */
public interface Perfil {

    
    boolean validar(Candidato candidato);

    PerfilEnum getPerfil();
}
