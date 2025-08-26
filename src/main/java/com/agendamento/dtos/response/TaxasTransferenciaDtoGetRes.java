package com.agendamento.dtos.response;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaxaTransferencia {

    private Integer diaDe;
    private Integer diaAte;
    private BigDecimal taxa;
    private BigDecimal porcentagem;
    
}
