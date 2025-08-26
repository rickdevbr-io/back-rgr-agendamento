package com.agendamento.mapper;

import com.agendamento.dtos.response.TaxasTransferenciaDtoGetRes;
import com.agendamento.model.TaxaTransferenciaModel;

public class TaxaTransferenciaMapper {

    public static TaxasTransferenciaDtoGetRes modelToTaxasTransferenciaDtoGetRes(TaxaTransferenciaModel model) {
        return TaxasTransferenciaDtoGetRes.builder()
                .diaDe(model.getDiaDe())
                .diaAte(model.getDiaAte())
                .taxa(model.getTaxa())
                .porcentagem(model.getPorcentagem())
                .build();
    }
}
