package com.barbearia.api.domain.atendimento;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoAtendimento(
        @NotNull
        Long idAtendimento,

        @NotNull
        MotivoCancelamento motivo
) {
}
