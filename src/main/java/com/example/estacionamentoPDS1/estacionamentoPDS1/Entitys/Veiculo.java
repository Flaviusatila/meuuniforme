package com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys;

import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Enum.TipoVeiculo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//Classe diretamente ligada a base de dados para fazer as tabelas e atributos
@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 8865133686521959531L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long estacionamentoId;

    private String placa;

    private String marca;

    private String modelo;

    private Double fatorEstacionamento;

    private String horaEntrada;

    private String horaSaida;

    private Double totalEstacionamento;

    private TipoVeiculo tipoVeiculo;

    public Veiculo() {
    }

    public Veiculo(Long id, String placa, String marca, String modelo, Double fatorEstacionamento, String horaEntrada, String horaSaida, Double totalEstacionamento, TipoVeiculo tipoVeiculo) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.fatorEstacionamento = fatorEstacionamento;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.totalEstacionamento = totalEstacionamento;
        setTipoVeiculo( tipoVeiculo );
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getFatorEstacionamento() {
        return fatorEstacionamento;
    }

    public void setFatorEstacionamento(Double fatorEstacionamento) {
        this.fatorEstacionamento = fatorEstacionamento;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Double getTotalEstacionamento() {
        return totalEstacionamento;
    }

    public void setTotalEstacionamento(Double totalEstacionamento) {
        this.totalEstacionamento = totalEstacionamento;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Long getEstacionamentoId() {
        return estacionamentoId;
    }

    public void setEstacionamentoId(Long estacionamentoId) {
        this.estacionamentoId = estacionamentoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = ( Veiculo ) o;
        return id.equals( veiculo.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}
