package com.gabriel.avaliacao.service.perfil;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.PerfilEnum;
import com.gabriel.avaliacao.entidade.Skill;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by gabriel on 21/04/17.
 */
public abstract class PerfilAbstract implements Perfil{

    public boolean validar(Candidato candidato){
        Stream<Skill> skillStream = candidato.getSkills()
                .stream()
                .filter(getRegraFiltro());
        return verificar(skillStream);
    }

    protected abstract boolean verificar(Stream<Skill> skillStream);

    protected abstract Predicate<? super Skill> getRegraFiltro();
}
