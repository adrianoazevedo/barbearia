package com.barbearia.api.domain.cliente;

public record DadosListagemCliente(Long id, String nome, String email, String cpf) {

    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf());
    }

}
