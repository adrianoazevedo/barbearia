package com.barbearia.api.domain.atendimento.validacoes.agendamento;

import com.barbearia.api.domain.atendimento.DadosAgendamentoAtendimento;
import com.barbearia.api.domain.barbeiro.BarbeiroRepository;
import com.barbearia.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorBarbeiroAtivo implements ValidadorAgendamento{

    @Autowired
    private BarbeiroRepository repository;

    public void validar(DadosAgendamentoAtendimento dados) {
        //barbeiro opcional
        if (dados.idBarbeiro() == null) {
            return;
        }

        var barbeiroEstaAtivo = repository.findAtivoById(dados.idBarbeiro());
        if (!barbeiroEstaAtivo) {
            throw new ValidacaoException("Atendimento não pode ser agendada com Barbeiro Inativo/Excluído");
        }
    }
}
