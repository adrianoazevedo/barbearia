package com.barbearia.api.domain.cliente;

import jakarta.validation.constraints.NotNull;
import com.barbearia.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoCliente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
