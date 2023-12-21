package com.barbearia.api.domain.atendimento;

import java.time.LocalDateTime;

public record DadosDetalhamentoAtendimento(Long id, Long idBarbeiro, Long idCliente, LocalDateTime data) {

}
