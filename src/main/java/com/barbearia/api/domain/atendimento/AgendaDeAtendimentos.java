package com.barbearia.api.domain.atendimento;

import com.barbearia.api.domain.atendimento.validacoes.agendamento.ValidadorAgendamento;
import com.barbearia.api.domain.atendimento.validacoes.cancelamento.ValidadorCancelamento;
import com.barbearia.api.domain.barbeiro.Barbeiro;
import com.barbearia.api.domain.barbeiro.BarbeiroRepository;
import com.barbearia.api.domain.cliente.ClienteRepository;
import com.barbearia.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeAtendimentos {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private List<ValidadorAgendamento> validadores;

    @Autowired
    private List<ValidadorCancelamento> validadoresCancelamento;

    public DadosDetalhamentoAtendimento agendar(DadosAgendamentoAtendimento dados) {
        if (!clienteRepository.existsById(dados.idCliente())) {
            throw new ValidacaoException("Id do Cliente informado não existe!");
        }

        if (dados.idBarbeiro() != null && !barbeiroRepository.existsById(dados.idBarbeiro())) {
            throw new ValidacaoException("Id do Barbeiro informado não existe!");
        }

        validadores.forEach(v -> v.validar(dados));

        var cliente = clienteRepository.getReferenceById(dados.idCliente());
//        var barbeiro = barbeiroRepository.findById(dados.idBarbeiro()).get();
        var barbeiro = escolherBarbeiro(dados);
        if (barbeiro == null) {
            throw new ValidacaoException("Não existe barbeiro disponível nessa data!");
        }

        var atendimento = new Atendimento(null, barbeiro, cliente, dados.data(), null);
        atendimentoRepository.save(atendimento);

        return new DadosDetalhamentoAtendimento(atendimento);
    }

    public void cancelar(DadosCancelamentoAtendimento dados) {
        if (!atendimentoRepository.existsById(dados.idAtendimento())) {
            throw new ValidacaoException("Id do Atendimento informado não existe!");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));

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
