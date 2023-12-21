package com.barbearia.api.domain.barbeiro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
    Page<Barbeiro> findAllByAtivoTrue(Pageable paginacao);


    @Query("""
            select b from Barbeiro b
                    where
                    b.ativo = true
                    and
                    b.especialidade = :especialidade
                    and
                    b.id not in(
                            select a.barbeiro.id from Atendimento a
                            where
                            a.data = :data
                    )
                    order by rand()
                    limit 1

            """)
    Barbeiro escolherBarbeiroAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);
}
