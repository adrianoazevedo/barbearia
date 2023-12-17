package com.barbearia.api.domain.barbeiro;

import com.barbearia.api.domain.endereco.Endereco;

public record DadosDetalhamentoBarbeiro(Long id, String nome, String email, String cpf, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoBarbeiro(Barbeiro barbeiro) {
        this(barbeiro.getId(), barbeiro.getNome(), barbeiro.getEmail(), barbeiro.getCpf(), barbeiro.getTelefone(), barbeiro.getEspecialidade(), barbeiro.getEndereco());
    }
}
