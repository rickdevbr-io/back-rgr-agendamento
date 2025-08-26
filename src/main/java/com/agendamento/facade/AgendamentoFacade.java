package com.agendamento.facade;

import com.agendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.dtos.request.CriarAgendamentoDtoPostReq;
import com.agendamento.dtos.response.AgendamentoDtoGetRes;
import com.agendamento.dtos.response.CriarAgendamentoDtoPostRes;
import com.agendamento.dtos.response.TaxasTransferenciaDtoGetRes;
import com.agendamento.service.TaxaTransferenciaService;

import java.util.List;
import java.time.temporal.ChronoUnit;
import java.math.BigDecimal;

@Service
public class AgendamentoFacade {
    
    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private TaxaTransferenciaService taxaTransferenciaService;

    public List<AgendamentoDtoGetRes> listarTodos() {
        return agendamentoService.listarTodos();
    }
    
    public CriarAgendamentoDtoPostRes criar(CriarAgendamentoDtoPostReq dto) {

        int dateDiff = (int) dto.getDataAgendamento().until(dto.getDataTransferencia(), ChronoUnit.DAYS);

        if (dateDiff > 50)
            throw new IllegalArgumentException("Não há taxa aplicável para o período de agendamento, por favor, escolher uma data de transferência abaixo de 50 dias.");

        TaxasTransferenciaDtoGetRes taxaTransferencia = taxaTransferenciaService.buscarPorDia(dateDiff, dateDiff);

        BigDecimal valorAdicional = taxaTransferencia.getTaxa();
        BigDecimal valorTaxaTransferencia = dto.getValor().multiply(taxaTransferencia.getPorcentagem()).divide(new BigDecimal(100));
        BigDecimal valorTaxaTotal = valorAdicional.add(valorTaxaTransferencia);

        BigDecimal valorTotal = dto.getValor().add(valorTaxaTotal);

        dto.setValor(valorTotal);

        return agendamentoService.criar(dto, valorTaxaTotal);
    }

}
