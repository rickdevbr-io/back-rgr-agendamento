package com.agendamento.service;

import com.agendamento.model.Agendamento;
import com.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }
    
    @Transactional
    public Agendamento criar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

}
