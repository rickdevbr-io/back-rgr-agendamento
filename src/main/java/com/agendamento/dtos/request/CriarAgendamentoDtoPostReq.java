package com.agendamento.dtos.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CriarAgendamentoDtoPostReq {

    @NotBlank(message = "Conta origem é obrigatória")
    private String contaOrigem;
    
    @NotBlank(message = "Conta destino é obrigatória")
    private String contaDestino;
    
    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.01", message = "Valor deve ser maior que zero")
    private BigDecimal valor;
    
    @NotNull(message = "Data de transferência é obrigatória")
    private LocalDateTime dataTransferencia;
    
    @NotNull(message = "Data de agendamento é obrigatória")
    private LocalDateTime dataAgendamento;

}
