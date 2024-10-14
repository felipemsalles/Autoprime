package com.AutoPrime.autoPrime.Entities;

import java.math.BigDecimal;

import com.AutoPrime.autoPrime.Utils.StatusVeiculo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String modelo;
    private int ano;
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status = StatusVeiculo.Disponivel;

    public Veiculo() {
    }

    public Veiculo(String modelo, int ano, BigDecimal preco) {
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("%s %d", modelo, ano);
    }

    public boolean validar(String[] parametros) {
        return true;
    }

    public boolean atualizarDados(String[] parametros) {
        return true;
    }

    // Return personalizacao
    public void getPersonalizacao() {
        // não será implementada
    }

    public void updatePreco(String[] personalizacao) {
        // não será implementada
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }
}
