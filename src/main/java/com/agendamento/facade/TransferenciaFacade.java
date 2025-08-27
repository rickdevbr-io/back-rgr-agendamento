package com.agendamento.facade;

import com.agendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.dtos.request.CriarAgendamentoDtoPostReq;
import com.agendamento.dtos.response.AgendamentoDtoGetRes;
import com.agendamento.dtos.response.CriarAgendamentoDtoPostRes;
import com.agendamento.dtos.response.CalcularTaxaTransferenciaDtoPostRes;
import com.agendamento.dtos.response.TaxasTransferenciaDtoGetRes;
import com.agendamento.service.TaxaTransferenciaService;

import java.util.List;
import java.time.temporal.ChronoUnit;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransferenciaFacade {
    
    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private TaxaTransferenciaService taxaTransferenciaService;

    public List<AgendamentoDtoGetRes> listarAgendamentos() {
        return agendamentoService.listarTodos();
    }
    
    public CriarAgendamentoDtoPostRes criarAgendamento(CriarAgendamentoDtoPostReq dto) {

        TaxasTransferenciaDtoGetRes taxaTransferencia = this.buscarTaxaTransferencia(dto.getDataAgendamento(), dto.getDataTransferencia());

        BigDecimal valorAdicional = taxaTransferencia.getTaxa();
        BigDecimal valorTaxaTransferencia = dto.getValor().multiply(taxaTransferencia.getPorcentagem()).divide(new BigDecimal(100));
        BigDecimal valorTaxaTotal = valorAdicional.add(valorTaxaTransferencia);

        BigDecimal valorTotal = dto.getValor().add(valorTaxaTotal);

        dto.setValor(valorTotal);

        return agendamentoService.criar(dto, valorTaxaTotal);
    }

    public List<TaxasTransferenciaDtoGetRes> listarTaxasTransferencia() {
        return taxaTransferenciaService.listarTodos();
    }

    public CalcularTaxaTransferenciaDtoPostRes calcularTaxaTransferencia(CriarAgendamentoDtoPostReq dto) {
       
        TaxasTransferenciaDtoGetRes taxaTransferencia = this.buscarTaxaTransferencia(dto.getDataAgendamento(), dto.getDataTransferencia());

        BigDecimal valorAdicional = taxaTransferencia.getTaxa();
        BigDecimal valorTaxaTransferencia = dto.getValor().multiply(taxaTransferencia.getPorcentagem()).divide(new BigDecimal(100));

        return CalcularTaxaTransferenciaDtoPostRes.builder()
            .diaDe(taxaTransferencia.getDiaDe())
            .diaAte(taxaTransferencia.getDiaAte())
            .valorAdicional(valorAdicional)
            .valorTaxaTransferencia(valorTaxaTransferencia)
            .build();
    }

    private TaxasTransferenciaDtoGetRes buscarTaxaTransferencia(LocalDateTime dataAgendamento, LocalDateTime dataTransferencia) {
        int dateDiff = (int) dataAgendamento.until(dataTransferencia, ChronoUnit.DAYS);
        if (dateDiff > 50)
            throw new IllegalArgumentException("Não há taxa aplicável para o período de agendamento, por favor, escolher uma data de transferência abaixo de 50 dias.");

        TaxasTransferenciaDtoGetRes taxaTransferencia = taxaTransferenciaService.buscarPorDia(dateDiff, dateDiff);

        return taxaTransferencia;
    }

}

