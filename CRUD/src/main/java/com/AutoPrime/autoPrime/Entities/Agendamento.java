package com.AutoPrime.autoPrime.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

import com.AutoPrime.autoPrime.Utils.StatusAgendamento;
import com.AutoPrime.autoPrime.Utils.TipoAgendamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Agendamento implements Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Veiculo veiculo;

    private String info;
    
    @Enumerated(EnumType.STRING)
    private StatusAgendamento status = StatusAgendamento.Marcado;
    @Enumerated(EnumType.STRING)
    private TipoAgendamento tipo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate data;

    public Agendamento(TipoAgendamento tipo, Veiculo veiculo, String info, LocalDate data) {
        this.tipo = tipo;
        this.veiculo = veiculo;
        this.info = info;
        this.data = data;
    }

    public Agendamento() {
    }

    public LocalDate getData() {
        return data;
    }

    public long getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public TipoAgendamento getTipo() {
        return tipo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public void setTipo(TipoAgendamento tipo) {
        this.tipo = tipo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void exibirStatus(Registro registro) {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String answer = "Id = %d\nData = %s\nStatus = %s\nTipo = %s\nVeiculo = %s";
        return String.format(answer, id, data.toString(), status, tipo, veiculo.toString());
    }
}