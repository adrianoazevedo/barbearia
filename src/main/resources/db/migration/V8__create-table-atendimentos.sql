create table atendimentos(

          id bigserial not null,
          barbeiro_id bigint not null,
          cliente_id bigint not null,
          data TIMESTAMP not null,

          primary key(id),
          constraint fk_atendimentos_barbeiro_id foreign key(barbeiro_id) references barbeiros(id),
          constraint fk_atendimentos_cliente_id foreign key(cliente_id) references clientes(id)

);