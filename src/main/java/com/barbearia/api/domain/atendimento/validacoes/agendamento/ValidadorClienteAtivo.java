package com.barbearia.api.domain.atendimento.validacoes.agendamento;

import com.barbearia.api.domain.atendimento.DadosAgendamentoAtendimento;
import com.barbearia.api.domain.cliente.ClienteRepository;
import com.barbearia.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorClienteAtivo implements ValidadorAgendamento{

    @Autowired
    private ClienteRepository repository;

    public void validar(DadosAgendamentoAtendimento dados) {
        var clienteEstaAtivo = repository.findAtivoById(dados.idCliente());
        if (!clienteEstaAtivo) {
            throw new ValidacaoException("Atendimento não pode ser agendado com Cliente Inativo");
        }
    }
}
