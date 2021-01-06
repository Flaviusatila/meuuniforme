package com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
//Classe diretamente ligada a base de dados para fazer as tabelas e atributos
@Entity
@Table(name = "tb_estacionamento")
public class Estacionamento implements Serializable {

    private static final long serialVersionUID = -3772648744234375999L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorHora;

    private Double totalFaturamento;

    private Double totalFaturamentoCarro;

    private Double totalFaturamentoMoto;

    private Double totalFaturamentoUtilitario;

    public Estacionamento() {
    }

    public Estacionamento(Long id, Double valorHora, Double totalFaturamento, Double totalFaturamentoCarro, Double totalFaturamentoMoto, Double totalFaturamentoUtilitario) {
        this.id = id;
        this.valorHora = valorHora;
        this.totalFaturamento = totalFaturamento;
        this.totalFaturamentoCarro = totalFaturamentoCarro;
        this.totalFaturamentoMoto = totalFaturamentoMoto;
        this.totalFaturamentoUtilitario = totalFaturamentoUtilitario;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Double getTotalFaturamento() {
        return totalFaturamento;
    }

    public void setTotalFaturamento(Double totalFaturamento) {
        this.totalFaturamento = totalFaturamento;
    }

    public Double getTotalFaturamentoCarro() {
        return totalFaturamentoCarro;
    }

    public void setTotalFaturamentoCarro(Double totalFaturamentoCarro) {
        this.totalFaturamentoCarro = totalFaturamentoCarro;
    }

    public Double getTotalFaturamentoMoto() {
        return totalFaturamentoMoto;
    }

    public void setTotalFaturamentoMoto(Double totalFaturamentoMoto) {
        this.totalFaturamentoMoto = totalFaturamentoMoto;
    }

    public Double getTotalFaturamentoUtilitario() {
        return totalFaturamentoUtilitario;
    }

    public void setTotalFaturamentoUtilitario(Double totalFaturamentoUtilitario) {
        this.totalFaturamentoUtilitario = totalFaturamentoUtilitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estacionamento that = ( Estacionamento ) o;
        return Objects.equals( id, that.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}
