package com.barbearia.api.domain.atendimento.validacoes.agendamento;

import com.barbearia.api.domain.atendimento.DadosAgendamentoAtendimento;
import com.barbearia.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamento{

    public void validar(DadosAgendamentoAtendimento dados) {

        var dataAtendimento = dados.data();
        var domingo = dataAtendimento.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataAtendimento.getHour() < 7;
        var depoisDoEncerramento = dataAtendimento.getHour() > 18;
        if (domingo || antesDaAbertura || depoisDoEncerramento) {
            throw new ValidacaoException("Atendimento fora do horário de funcionamento da Barbearia");
        }

    }
}
