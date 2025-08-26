package com.agendamento.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_agendamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendamentoModel {

    @Id
    @Column(name = "codigo_agendamento", length = 36)
    private String codigoAgendamento;

    @Column(name = "codigo_status_agendamento", nullable = false)
    private Integer statusAgendamento;

    @Column(name = "st_conta_origem", nullable = false, length = 50)
    private String contaOrigem;

    @Column(name = "st_conta_destino", nullable = false, length = 50)
    private String contaDestino;

    @Column(name = "dc_valor", nullable = false, precision = 19, scale = 2)
    private BigDecimal valor;

    @Column(name = "dc_taxa", nullable = false, precision = 19, scale = 2)
    private BigDecimal taxa;

    @Column(name = "ts_data_transferencia", nullable = false)
    private LocalDateTime dataTransferencia;

    @Column(name = "ts_data_agendamento", nullable = false)
    private LocalDateTime dataAgendamento;

    @PrePersist
    protected void onCreate() {
        if (codigoAgendamento == null) {
            codigoAgendamento = UUID.randomUUID().toString();
        }
    }
}
