package com.agendamento.repository;

import com.agendamento.model.StatusAgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusAgendamentoRepository extends JpaRepository<StatusAgendamentoModel, Integer> {


}
