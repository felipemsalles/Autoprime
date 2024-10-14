package com.AutoPrime.autoPrime.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Usuario {

    private String cargo;
    private BigDecimal bonificacao;
    private BigDecimal salario;

    protected Funcionario(String nome, String email, String telefone, String cpf, LocalDate dataDeNascimento,
            String cargo, BigDecimal bonificacao, BigDecimal salario) {
        super();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.setCargo(cargo);
        this.setBonificacao(bonificacao);
        this.setSalario(salario);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Funcionario() {
    }

    public BigDecimal getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(BigDecimal bonificacao) {
        this.bonificacao = bonificacao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
