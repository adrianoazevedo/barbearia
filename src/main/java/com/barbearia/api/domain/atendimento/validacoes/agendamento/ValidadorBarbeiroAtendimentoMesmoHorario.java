package com.barbearia.api.domain.atendimento.validacoes.agendamento;

import com.barbearia.api.domain.atendimento.AtendimentoRepository;
import com.barbearia.api.domain.atendimento.DadosAgendamentoAtendimento;
import com.barbearia.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorBarbeiroAtendimentoMesmoHorario implements ValidadorAgendamento{

    @Autowired
    private AtendimentoRepository repository;

    public void validar(DadosAgendamentoAtendimento dados) {
        var barbeiroPossuiAtendimentoMesmoHorario = repository.existsByBarbeiroIdAndDataAndMotivoCancelamentoIsNull(dados.idBarbeiro(), dados.data());
        if (barbeiroPossuiAtendimentoMesmoHorario) {
            throw new ValidacaoException("Barbeiro já possui outro atendimento agendado nesse mesmo horário");
        }
    }

}
