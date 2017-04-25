package com.gabriel.avaliacao.service.perfil;

import com.gabriel.avaliacao.entidade.PerfilEnum;
import com.gabriel.avaliacao.entidade.Skill;
import com.gabriel.avaliacao.entidade.SkillTipoEnum;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by gabriel on 21/04/17.
 */
public class PerfilBackend extends PerfilAbstract{

    public static final List<SkillTipoEnum> SKILLS = Arrays.asList(SkillTipoEnum.PYTHON, SkillTipoEnum.DJANGO);

    @Override
    protected boolean verificar(Stream<Skill> skillStream) {
        return skillStream.count() == SKILLS.size();
    }

    @Override
    protected Predicate<? super Skill> getRegraFiltro() {
        return s -> s.getGrauConhecimento() >= 7 && SKILLS.contains(s.getTipo());
    }

    @Override
    public PerfilEnum getPerfil() {
        return PerfilEnum.BACKEND;
    }
}
