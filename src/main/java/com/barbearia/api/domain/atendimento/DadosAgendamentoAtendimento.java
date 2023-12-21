package com.barbearia.api.domain.atendimento;

import com.barbearia.api.domain.barbeiro.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoAtendimento(
        Long idBarbeiro,

        @NotNull
        Long idCliente,

        @NotNull
        @Future
        LocalDateTime data,

        Especialidade especialidade) {
}



