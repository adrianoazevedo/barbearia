package com.barbearia.api.domain.barbeiro;

import jakarta.validation.constraints.NotNull;
import com.barbearia.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoBarbeiro(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
