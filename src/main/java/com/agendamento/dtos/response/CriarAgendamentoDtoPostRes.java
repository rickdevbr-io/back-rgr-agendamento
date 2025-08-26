package com.agendamento.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CriarAgendamentoDtoPostRes {

    private String codigoAgendamento;
    private String contaOrigem;
    private String contaDestino;
    private BigDecimal valor;
    private BigDecimal taxa;
    private LocalDateTime dataTransferencia;
    private LocalDateTime dataAgendamento;
    
}
