package com.agendamento.service;

import com.agendamento.mapper.AgendamentoMapper;
import com.agendamento.model.AgendamentoModel;
import com.agendamento.enums.StatusAgendamentoEnum;
import com.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import com.agendamento.dtos.request.CriarAgendamentoDtoPostReq;
import com.agendamento.dtos.response.AgendamentoDtoGetRes;
import com.agendamento.dtos.response.CriarAgendamentoDtoPostRes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
    public CriarAgendamentoDtoPostRes criar(CriarAgendamentoDtoPostReq dto, BigDecimal valorTaxaTotal) {
        AgendamentoModel agendamentoNovo = AgendamentoMapper.criarAgendamentoDtoPostReqToModel(dto);
        
        agendamentoNovo.setCodigoAgendamento(UUID.randomUUID().toString());
        agendamentoNovo.setStatusAgendamento(StatusAgendamentoEnum.PENDENTE.getCodigo());
        agendamentoNovo.setTaxa(valorTaxaTotal);

        agendamentoNovo = agendamentoRepository.save(agendamentoNovo);
        return AgendamentoMapper.modelToAgendamentoDtoPostRes(agendamentoNovo);
    }

}
