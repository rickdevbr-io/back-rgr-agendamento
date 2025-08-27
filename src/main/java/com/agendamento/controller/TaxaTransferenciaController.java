package com.agendamento.controller;

import com.agendamento.dtos.request.CriarAgendamentoDtoPostReq;
import com.agendamento.dtos.response.CalcularTaxaTransferenciaDtoPostRes;
import com.agendamento.dtos.response.TaxasTransferenciaDtoGetRes;
import com.agendamento.facade.TransferenciaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/taxa-transferencia")
@CrossOrigin(origins = "*")
public class TaxaTransferenciaController {

    @Autowired
    private TransferenciaFacade transferenciaFacade;

    @GetMapping
    public ResponseEntity<List<TaxasTransferenciaDtoGetRes>> taxasTransferencia() {
        List<TaxasTransferenciaDtoGetRes> taxasTransferencia = transferenciaFacade.listarTaxasTransferencia();
        return ResponseEntity.ok(taxasTransferencia);
    }

    @PostMapping("/calcular")
    public ResponseEntity<CalcularTaxaTransferenciaDtoPostRes> calcularTaxaTransferencia(@RequestBody CriarAgendamentoDtoPostReq dto) {
        CalcularTaxaTransferenciaDtoPostRes taxaTransferencia = transferenciaFacade.calcularTaxaTransferencia(dto);
        return ResponseEntity.ok(taxaTransferencia);
    }

}
