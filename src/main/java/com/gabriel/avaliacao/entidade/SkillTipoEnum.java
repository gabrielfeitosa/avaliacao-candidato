package com.gabriel.avaliacao.entidade;

import java.util.*;

/**
 * Created by gabriel on 21/04/17.
 */
public enum SkillTipoEnum {

    HTML,
    CSS,
    JAVASCRIPT,
    PYTHON,
    DJANGO,
    DESENVOLVIMENTO_IOS,
    DESENVOLVIMENTO_ANDROID;


    public static final List<SkillTipoEnum> BACKEND = Arrays.asList(PYTHON, DJANGO);
    public static final List<SkillTipoEnum> MOBILE = Arrays.asList(DESENVOLVIMENTO_ANDROID, DESENVOLVIMENTO_IOS);

}
