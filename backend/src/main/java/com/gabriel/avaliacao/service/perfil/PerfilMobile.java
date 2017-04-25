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
public class PerfilMobile extends PerfilAbstract{

    public static final List<SkillTipoEnum> SKILLS = Arrays.asList(SkillTipoEnum.ANDROID, SkillTipoEnum.IOS);

    @Override
    protected boolean verificar(Stream<Skill> skillStream) {
        return skillStream.count() > 0;
    }

    @Override
    protected Predicate<? super Skill> getRegraFiltro() {
        return s -> s.getGrauConhecimento() >= 7 && SKILLS.contains(s.getTipo());
    }

    @Override
    public PerfilEnum getPerfil() {
        return PerfilEnum.MOBILE;
    }
}
