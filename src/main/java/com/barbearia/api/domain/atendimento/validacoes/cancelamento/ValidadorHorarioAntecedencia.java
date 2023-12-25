package com.barbearia.api.domain.atendimento.validacoes.cancelamento;

import com.barbearia.api.domain.atendimento.AtendimentoRepository;
import com.barbearia.api.domain.atendimento.DadosCancelamentoAtendimento;
import com.barbearia.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamento{

    @Autowired
    private AtendimentoRepository repository;

    @Override
    public void validar(DadosCancelamentoAtendimento dados) {
        var atendimento = repository.getReferenceById(dados.idAtendimento());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, atendimento.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Atendimento somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }

}
