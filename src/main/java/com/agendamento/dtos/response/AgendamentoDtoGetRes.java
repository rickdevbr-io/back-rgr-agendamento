package com.agendamento.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class AgendamentoDtoGetRes {

    private String codigoAgendamento;
    private String statusAgendamento;
    private String contaOrigem;
    private String contaDestino;
    private BigDecimal valor;
    private BigDecimal taxa;
    private LocalDateTime dataTransferencia;
    private LocalDateTime dataAgendamento;

}
