package com.barbearia.api.domain.atendimento.validacoes.agendamento;

import com.barbearia.api.domain.atendimento.DadosAgendamentoAtendimento;

public interface ValidadorAgendamento {

    void validar(DadosAgendamentoAtendimento dados);
}
