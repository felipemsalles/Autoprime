package com.AutoPrime.autoPrime.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Gerente extends Funcionario {
    protected Gerente(String nome, String email, String telefone, String cpf, LocalDate dataDeNascimento, String cargo,
            BigDecimal bonificacao, BigDecimal salario) {
        super(nome, email, telefone, cpf, dataDeNascimento, cargo, bonificacao, salario);
    }

    public void validarValor(BigDecimal valor, Funcionario func) {
        // nao sera implementada por agora
    }
}
