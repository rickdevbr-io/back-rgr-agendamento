package com.agendamento.mapper;

import com.agendamento.dtos.request.CriarAgendamentoDtoPostReq;
import com.agendamento.dtos.response.AgendamentoDtoGetRes;
import com.agendamento.dtos.response.CriarAgendamentoDtoPostRes;
import com.agendamento.model.AgendamentoModel;

public class AgendamentoMapper {

    public static AgendamentoModel criarAgendamentoDtoPostReqToModel(CriarAgendamentoDtoPostReq dto) {
        return AgendamentoModel.builder()
                .contaOrigem(dto.getContaOrigem())
                .contaDestino(dto.getContaDestino())
                .valor(dto.getValor())
                .taxa(dto.getTaxa())
                .dataTransferencia(dto.getDataTransferencia())
                .dataAgendamento(dto.getDataAgendamento())
                .build();
    }

    public static CriarAgendamentoDtoPostRes modelToAgendamentoDtoPostRes(AgendamentoModel model) {
        return CriarAgendamentoDtoPostRes.builder()
                .codigoAgendamento(model.getCodigoAgendamento())
                .contaOrigem(model.getContaOrigem())
                .contaDestino(model.getContaDestino())
                .valor(model.getValor())
                .taxa(model.getTaxa())
                .dataTransferencia(model.getDataTransferencia())
                .dataAgendamento(model.getDataAgendamento())
                .build();
    }

    public static AgendamentoDtoGetRes modelToAgendamentoDtoGetRes(AgendamentoModel model) {
        return AgendamentoDtoGetRes.builder()
                .codigoAgendamento(model.getCodigoAgendamento())
                .contaOrigem(model.getContaOrigem())
                .contaDestino(model.getContaDestino())
                .valor(model.getValor())
                .taxa(model.getTaxa())
                .dataTransferencia(model.getDataTransferencia())
                .dataAgendamento(model.getDataAgendamento())
                .build();
    }
}
