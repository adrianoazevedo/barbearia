package com.barbearia.api.domain.atendimento.validacoes.cancelamento;

import com.barbearia.api.domain.atendimento.DadosCancelamentoAtendimento;

public interface ValidadorCancelamento {
    void validar(DadosCancelamentoAtendimento dados);
}
