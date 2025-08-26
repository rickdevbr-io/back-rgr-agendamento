package com.agendamento.repository;

import com.agendamento.model.TaxaTransferenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxaTransferenciaRepository extends JpaRepository<TaxaTransferenciaModel, Integer> {


}
