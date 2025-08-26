package com.agendamento.service;

import com.agendamento.mapper.TaxaTransferenciaMapper;
import com.agendamento.model.TaxaTransferenciaModel;
import com.agendamento.repository.TaxaTransferenciaRepository;
import com.agendamento.dtos.response.TaxasTransferenciaDtoGetRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxaTransferenciaService {

    @Autowired
    private TaxaTransferenciaRepository taxaTransferenciaRepository;

    public List<TaxasTransferenciaDtoGetRes> listarTodos() {
        List<TaxaTransferenciaModel> taxasTransferencia = taxaTransferenciaRepository.findAll();
        
        if (taxasTransferencia.isEmpty())
            return new ArrayList<TaxasTransferenciaDtoGetRes>();

        return taxasTransferencia.stream()
            .map(TaxaTransferenciaMapper::modelToTaxasTransferenciaDtoGetRes)
            .collect(Collectors.toList());
    }

    public TaxasTransferenciaDtoGetRes buscarPorDia(int diaDe, int diaAte) {
        TaxaTransferenciaModel taxaTransferencia = taxaTransferenciaRepository.findByDiaDeLessThanEqualAndDiaAteGreaterThanEqual(diaDe, diaAte);

        if (taxaTransferencia == null)
            return new TaxasTransferenciaDtoGetRes();

        return TaxaTransferenciaMapper.modelToTaxasTransferenciaDtoGetRes(taxaTransferencia);
    }
}
