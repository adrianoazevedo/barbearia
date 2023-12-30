package com.barbearia.api.domain.barbeiro;

import com.barbearia.api.domain.atendimento.Atendimento;
import com.barbearia.api.domain.cliente.Cliente;
import com.barbearia.api.domain.cliente.DadosCadastroCliente;
import com.barbearia.api.domain.endereco.DadosEndereco;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class BarbeiroRepositoryTest {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private TestEntityManager em;

//    @Test
//    @DisplayName("Deveria devolver null quando unico barbeiro cadastrado nao esta disponivel na data")
//    void escolherBarbeiroAleatorioLivreNaDataDataCenario1() {
//
//        var proximaSegundaAs9 = LocalDate.now()
//                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
//                .atTime(9, 0);
//
//        var barbeiro = cadastrarBarbeiro("João da Silva", "joao@gmail.com", "555555555", Especialidade.BARBA);
//        var cliente = cadastrarCliente("Maria da Silva", "maria@gmail.com", "8888888888");
//        cadastrarAtendimento(barbeiro, cliente, proximaSegundaAs9);
//
//        var barbeiroLivre = barbeiroRepository.escolherBarbeiroAleatorioLivreNaData(Especialidade.BARBA, proximaSegundaAs9);
//
//        assertThat(barbeiroLivre).isNull();
//    }

    private void cadastrarAtendimento(Barbeiro barbeiro, Cliente cliente, LocalDateTime data) {
        em.persist(new Atendimento(null, barbeiro, cliente, data, null));
    }

    private Barbeiro cadastrarBarbeiro(String nome, String email, String cpf, Especialidade especialidade) {
        var barbeiro = new Barbeiro(dadosCadastroBarbeiro(nome, email, cpf, especialidade));
        em.persist(barbeiro);
        return barbeiro;
    }

    private Cliente cadastrarCliente(String nome, String email, String cpf) {
        var cliente = new Cliente(dadosCadastroCliente(nome, email, cpf));
        em.persist(cliente);
        return cliente;
    }

    private DadosCadastroBarbeiro dadosCadastroBarbeiro(String nome, String email, String cpf, Especialidade especialidade) {
        return new DadosCadastroBarbeiro(
                nome,
                email,
                "61999999999",
                cpf,
                especialidade,
                dadosEndereco()
        );
    }

    private DadosCadastroCliente dadosCadastroCliente(String nome, String email, String cpf) {
        return new DadosCadastroCliente(
                nome,
                email,
                "61999999999",
                cpf,
                dadosEndereco()
        );
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }
}