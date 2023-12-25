package com.barbearia.api.domain.atendimento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    boolean existsByClienteIdAndDataBetween(Long idCliente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);

    boolean existsByBarbeiroIdAndDataAndMotivoCancelamentoIsNull(Long idBarbeiro, LocalDateTime data);
}
