package com.agendamento.dtos.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class TaxasTransferenciaDtoGetRes {

    private Integer diaDe;
    private Integer diaAte;
    private BigDecimal taxa;
    private BigDecimal porcentagem;
    
}
