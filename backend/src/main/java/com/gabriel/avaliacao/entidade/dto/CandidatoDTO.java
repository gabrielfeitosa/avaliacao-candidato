package com.gabriel.avaliacao.entidade.dto;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.Skill;
import com.gabriel.avaliacao.service.EmailValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel on 21/04/17.
 */
@Getter
@Setter
public class CandidatoDTO {

    @NotNull
    @Size(min = 1)
    private String nome;
    @NotNull
    @Size(min = 1)
    @Pattern(regexp = EmailValidator.EMAIL_PATTERN)
    private String email;
    private List<SkillDTO> skills = new ArrayList<>();


    public Candidato buildCandidato() {
        Candidato candidato = new Candidato(getNome(), getEmail());
        getSkills().forEach(skillDTO -> candidato.adicionarSkill(skillDTO.buildSkill()));
        return candidato;
    }

}
