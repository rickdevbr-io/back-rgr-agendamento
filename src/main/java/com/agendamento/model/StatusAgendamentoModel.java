package com.agendamento.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_status_agendamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusAgendamentoModel {

    @Id
    @Column(name = "codigo_status_agendamento")
    private Integer codigoStatusAgendamento;

    @Column(name = "st_nome", nullable = false, length = 50)
    private String nome;
}
