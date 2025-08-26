package com.agendamento.controller;

import com.agendamento.dtos.response.TaxasTransferenciaDtoGetRes;
import com.agendamento.service.TaxaTransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/taxa-transferencia")
@CrossOrigin(origins = "*")
public class TaxaTransferenciaController {

    @Autowired
    private TaxaTransferenciaService taxaTransferenciaService;

    @GetMapping
    public ResponseEntity<List<TaxasTransferenciaDtoGetRes>> taxasTransferencia() {
        List<TaxasTransferenciaDtoGetRes> taxasTransferencia = taxaTransferenciaService.listarTodos();
        return ResponseEntity.ok(taxasTransferencia);
    }

}
