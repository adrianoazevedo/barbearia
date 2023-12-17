package com.barbearia.api.domain.barbeiro;

public record DadosListagemBarbeiro(Long id, String nome, String email, String cpf, Especialidade especialidade) {

    public DadosListagemBarbeiro(Barbeiro barbeiro) {
        this(barbeiro.getId(), barbeiro.getNome(), barbeiro.getEmail(), barbeiro.getCpf(), barbeiro.getEspecialidade());
    }

}
