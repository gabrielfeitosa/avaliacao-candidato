package com.gabriel.avaliacao.service;

import com.gabriel.avaliacao.entidade.Candidato;
import com.gabriel.avaliacao.entidade.Email;
import com.gabriel.avaliacao.entidade.PerfilEnum;
import com.gabriel.avaliacao.service.perfil.Perfil;
import com.gabriel.avaliacao.service.perfil.PerfilBackend;
import com.gabriel.avaliacao.service.perfil.PerfilFrontend;
import com.gabriel.avaliacao.service.perfil.PerfilMobile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gabriel on 21/04/17.
 */
@Service
public class AvaliacaoService {

    private final List<Perfil> PERFIS_DISPONIVEIS = Arrays.asList(new PerfilFrontend(), new PerfilBackend(), new PerfilMobile());
    private EmailService emailService;

    public AvaliacaoService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void avaliar(Candidato candidato) {
        List<Perfil> perfisDoCandidado = PERFIS_DISPONIVEIS.stream()
                .filter(p -> p.validar(candidato))
                .collect(Collectors.toList());


        if (perfisDoCandidado.isEmpty()) {
            emailService.enviar(new Email(candidato, PerfilEnum.GENERICO));
        } else {
            perfisDoCandidado.forEach(p -> emailService.enviar(new Email(candidato, p.getPerfil())));

        }
    }
}
