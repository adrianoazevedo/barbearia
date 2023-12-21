package com.barbearia.api.domain.atendimento;

import com.barbearia.api.domain.barbeiro.Barbeiro;
import com.barbearia.api.domain.barbeiro.BarbeiroRepository;
import com.barbearia.api.domain.cliente.ClienteRepository;
import com.barbearia.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeAtendimentos {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void agendar(DadosAgendamentoAtendimento dados) {
        if (!clienteRepository.existsById(dados.idCliente())) {
            throw new ValidacaoException("Id do Cliente informado não existe!");
        }

        if (dados.idBarbeiro() != null && !barbeiroRepository.existsById(dados.idBarbeiro())) {
            throw new ValidacaoException("Id do Barbeiro informado não existe!");
        }


        var cliente = clienteRepository.getReferenceById(dados.idCliente());
//        var barbeiro = barbeiroRepository.findById(dados.idBarbeiro()).get();
        var barbeiro = escolherBarbeiro(dados);
        var atendimento = new Atendimento(null, barbeiro, cliente, dados.data(), null);
        atendimentoRepository.save(atendimento);
    }

    public void cancelar(DadosCancelamentoAtendimento dados) {
        if (!atendimentoRepository.existsById(dados.idAtendimento())) {
            throw new ValidacaoException("Id do Atendimento informado não existe!");
        }

        var atendimento = atendimentoRepository.getReferenceById(dados.idAtendimento());
        atendimento.cancelar(dados.motivo());
    }

    private Barbeiro escolherBarbeiro(DadosAgendamentoAtendimento dados) {
        if (dados.idBarbeiro() != null) {
            return barbeiroRepository.getReferenceById(dados.idBarbeiro());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória quando barbeiro não for escolhido!");
        }

        return barbeiroRepository.escolherBarbeiroAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

}
