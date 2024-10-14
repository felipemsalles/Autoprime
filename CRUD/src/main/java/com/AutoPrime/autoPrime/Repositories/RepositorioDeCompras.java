package com.AutoPrime.autoPrime.Repositories;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AutoPrime.autoPrime.Entities.Cliente;
import com.AutoPrime.autoPrime.Entities.Compra;
import com.AutoPrime.autoPrime.Entities.Veiculo;

import jakarta.transaction.Transactional;
@Repository
public interface RepositorioDeCompras extends CrudRepository<Compra, Long> {

  Compra findById(long id);

  Compra findByData(LocalDate data);

  Compra findByStatus(String status);

  Compra findByVeiculo(Veiculo veiculo);

  List<Compra> findByCliente(Cliente cliente);

  @Modifying
  @Transactional
  @Query("UPDATE Compra c SET c.veiculo = :veiculo, c.cliente = :cliente, c.data = :data, c.valor = :valor, c.desconto = :desconto, c.status = :status  WHERE c.id = :id")
  void atualizarCompra(@Param("veiculo") Veiculo veiculo, @Param("cliente") Cliente cliente,@Param("data") LocalDate data, @Param("valor") BigDecimal valor, @Param("desconto") BigDecimal desconto, @Param("status") String status, @Param("id") long id);
}