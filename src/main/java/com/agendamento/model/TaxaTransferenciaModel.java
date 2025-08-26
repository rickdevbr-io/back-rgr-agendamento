package com.agendamento.model;

import javax.persistence.*;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_taxas_dias_tranferencias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxaTransferenciaModel {

    @Id
    @Column(name = "codigo_taxa_dia_tranferencia")
    private Integer codigoTaxaDiaTransferencia;

    @Column(name = "nr_dia_de", nullable = false)
    private Integer diaDe;

    @Column(name = "nr_dia_ate", nullable = false)
    private Integer diaAte;

    @Column(name = "dc_taxa", precision = 19, scale = 2)
    private BigDecimal taxa;

    @Column(name = "dc_porcentagem", precision = 19, scale = 2)
    private BigDecimal porcentagem;
}
