package com.agendamento.repository;

import com.agendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, String> {


}
