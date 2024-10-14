package com.AutoPrime.autoPrime.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.cglib.core.Local;

@Entity
public class Compra implements Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal valor;
    private BigDecimal desconto;
    @OneToOne
    private Veiculo veiculo;
    @OneToOne
    private Cliente cliente;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate data = LocalDate.now();

    public Compra(BigDecimal valor, BigDecimal desconto, Veiculo veiculo, String status, LocalDate data, Cliente cliente) {
        this.setValor(valor);
        this.setDesconto(desconto);
        this.setVeiculo(veiculo);
        this.setStatus(status);
        this.setData(data);
        this.setCliente(cliente);
    }

    public Compra() {
    }

    @Override
    public void exibirStatus(Registro registro) {
        System.out.println(getStatus());
    }

    public void getDetalhes() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
