package com.agendamento.controller;

import com.agendamento.dtos.request.CriarAgendamentoDtoPostReq;
import com.agendamento.dtos.response.AgendamentoDtoGetRes;
import com.agendamento.dtos.response.CriarAgendamentoDtoPostRes;
import com.agendamento.facade.TransferenciaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/agendamento")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private TransferenciaFacade transferenciaFacade;

    @GetMapping
    public ResponseEntity<List<AgendamentoDtoGetRes>> agendamentos() {
        List<AgendamentoDtoGetRes> agendamentos = transferenciaFacade.listarAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }

    @PostMapping
    public ResponseEntity<CriarAgendamentoDtoPostRes> criarAgendamento(@Valid @RequestBody CriarAgendamentoDtoPostReq dto) {
        
        try {
            CriarAgendamentoDtoPostRes novoAgendamento = transferenciaFacade.criarAgendamento(dto);

            return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
        } catch (Exception e) {
            throw e; 
        }
    }
}
