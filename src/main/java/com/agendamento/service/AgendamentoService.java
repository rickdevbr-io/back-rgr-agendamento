package com.agendamento.service;

import com.agendamento.mapper.AgendamentoMapper;
import com.agendamento.model.AgendamentoModel;
import com.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agendamento.dtos.request.CriarAgendamentoDtoPostReq;
import com.agendamento.dtos.response.AgendamentoDtoGetRes;
import com.agendamento.dtos.response.CriarAgendamentoDtoPostRes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<AgendamentoDtoGetRes> listarTodos() {
        List<AgendamentoModel> agendamentos = agendamentoRepository.findAll();
        
        if (agendamentos.isEmpty())
            return new ArrayList<AgendamentoDtoGetRes>();

        return agendamentos.stream()
            .map(AgendamentoMapper::modelToAgendamentoDtoGetRes)
            .collect(Collectors.toList());
    }
    
    @Transactional
    public CriarAgendamentoDtoPostRes criar(CriarAgendamentoDtoPostReq dto) {
        AgendamentoModel agendamentoNovo = AgendamentoMapper.criarAgendamentoDtoPostReqToModel(dto);
        agendamentoNovo = agendamentoRepository.save(agendamentoNovo);
        return AgendamentoMapper.modelToAgendamentoDtoPostRes(agendamentoNovo);
    }

}
