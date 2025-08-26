package com.agendamento.dtos.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AgendamentoCriarPostReq {

    private String contaOrigem;
    private String contaDestino;
    private BigDecimal valor;
    private BigDecimal taxa;
    private LocalDateTime dataTransferencia;
    private LocalDateTime dataAgendamento;
    
}
