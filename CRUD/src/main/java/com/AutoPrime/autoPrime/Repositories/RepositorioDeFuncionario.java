package com.AutoPrime.autoPrime.Repositories;
import java.math.BigDecimal;
import java.time.LocalDate;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AutoPrime.autoPrime.Entities.Funcionario;

@Repository
public interface RepositorioDeFuncionario extends CrudRepository<Funcionario, String>{
    Funcionario findByNome(String nome);

    Funcionario findByEmail(String email);

    Funcionario findByTelefone(String telefone);

    Funcionario findByDataDeNascimento(LocalDate dataDeNascimento);
    
    Funcionario findByCpf(String cpf);

    Funcionario findByBonificacao(BigDecimal bonificacao);

    Funcionario findByCargo(String cargo);

    Funcionario findBySalario(BigDecimal salario);

    @Query("SELECT f FROM Funcionario f WHERE f.cpf = :cpf AND f.senha = :senha")
    Funcionario getFuncionario(@Param("cpf") String cpf, @Param("senha") String senha);

}
