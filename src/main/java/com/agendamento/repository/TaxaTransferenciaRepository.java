package com.agendamento.repository;

import com.agendamento.model.TaxaTransferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxaTransferenciaRepository extends JpaRepository<TaxaTransferencia, Integer> {


}
