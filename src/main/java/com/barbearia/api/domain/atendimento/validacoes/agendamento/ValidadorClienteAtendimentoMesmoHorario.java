package com.barbearia.api.domain.atendimento.validacoes.agendamento;

import com.barbearia.api.domain.atendimento.AtendimentoRepository;
import com.barbearia.api.domain.atendimento.DadosAgendamentoAtendimento;
import com.barbearia.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorClienteAtendimentoMesmoHorario implements ValidadorAgendamento{

    @Autowired
    private AtendimentoRepository repository;

    public void validar(DadosAgendamentoAtendimento dados) {

        var clientePossuiAtendimentoMesmoHorario = repository.existsByBarbeiroIdAndDataAndMotivoCancelamentoIsNull(dados.idCliente(), dados.data());
        if (clientePossuiAtendimentoMesmoHorario) {
            throw new ValidacaoException("Cliente já possui um atendimento agendada nesse dia");
        }
    }
}
