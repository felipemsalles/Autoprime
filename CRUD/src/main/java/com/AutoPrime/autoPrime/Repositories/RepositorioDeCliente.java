package com.AutoPrime.autoPrime.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AutoPrime.autoPrime.Entities.Cliente;
import java.time.LocalDate;


@Repository
public interface RepositorioDeCliente extends CrudRepository<Cliente, String> {

    Cliente findByNome(String nome);

    Cliente findByEmail(String email);

    Cliente findByTelefone(String telefone);

    Cliente findByDataDeNascimento(LocalDate dataDeNascimento);

    Cliente findByCpf(String cpf);

    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf AND c.senha = :senha")
    Cliente getCliente(@Param("cpf") String cpf, @Param("senha") String senha);

}
