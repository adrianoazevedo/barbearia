package com.barbearia.api.controller;

import com.barbearia.api.domain.atendimento.AgendaDeAtendimentos;
import com.barbearia.api.domain.atendimento.DadosAgendamentoAtendimento;
import com.barbearia.api.domain.atendimento.DadosCancelamentoAtendimento;
import com.barbearia.api.domain.atendimento.DadosDetalhamentoAtendimento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("atendimentos")
public class AtendimentoController {

    @Autowired
    private AgendaDeAtendimentos agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoAtendimento dados){

        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAtendimento(null, null, null, null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoAtendimento dados) {
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
