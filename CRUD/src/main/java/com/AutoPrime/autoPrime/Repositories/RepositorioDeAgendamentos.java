package com.AutoPrime.autoPrime.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.AutoPrime.autoPrime.Entities.Agendamento;
import com.AutoPrime.autoPrime.Entities.Veiculo;

import jakarta.transaction.Transactional;

import java.util.List;
import java.time.LocalDate;


public interface RepositorioDeAgendamentos extends CrudRepository<Agendamento, Long> {

  Agendamento findById(long id);

  List<Agendamento> findByData(LocalDate data);
  
  List<Agendamento> findByInfo(String info);

  List<Agendamento> findByStatus(String status);

  List<Agendamento> findByTipo(String tipo);

  List<Agendamento> findByVeiculo(Veiculo veiculo);

  @Modifying
  @Transactional
  @Query("UPDATE Agendamento a SET a.status = 'Desmarcado' WHERE a.id = :id")
  void desmarcarAgendamento(@Param("id") long id);
}