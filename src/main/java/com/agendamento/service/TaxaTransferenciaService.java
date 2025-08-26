package com.agendamento.service;

import com.agendamento.model.TaxaTransferencia;
import com.agendamento.repository.TaxaTransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxaTransferenciaService {

    @Autowired
    private TaxaTransferenciaRepository taxaTransferenciaRepository;

    public List<TaxaTransferencia> listarTodos() {
        return taxaTransferenciaRepository.findAll();
    }

}
