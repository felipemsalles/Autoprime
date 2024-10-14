package com.AutoPrime.autoPrime.Repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AutoPrime.autoPrime.Entities.Veiculo;
import com.AutoPrime.autoPrime.Utils.StatusVeiculo;

import java.util.List;
import java.math.BigDecimal;


@Repository
public interface RepositorioDeVeiculos extends CrudRepository<Veiculo, Long> {

  Veiculo findById(long id);

  List<Veiculo> findByAno(int ano);

  List<Veiculo> findByModelo(String modelo);

  List<Veiculo> findByPreco(BigDecimal preco);

  List<Veiculo> findByStatus(StatusVeiculo status);
  
}