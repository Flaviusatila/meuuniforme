package com.example.estacionamentoPDS1.estacionamentoPDS1.DTO;

import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Enum.TipoVeiculo;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Veiculo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VeiculoDTO implements Serializable {

    private static final long serialVersionUID = -5471136664363970029L;

    private Long id;

    @JsonProperty("placa")
    private String placa;

    @JsonProperty("marca")
    private String marca;

    @JsonProperty("modelo")
    private String modelo;

    @JsonProperty("fator_estacionamento")
    private Double fatorEstacionamento;

    @JsonProperty("hora_entrada")
    private String horaEntrada;

    @JsonProperty("hora_saida")
    private String horaSaida;

    @JsonProperty("total_estacionamento")
    private Double totalEstacionamento;

    @JsonProperty("tipo_veiculo")
    private TipoVeiculo tipoVeiculo;

    public VeiculoDTO() {
    }

    public VeiculoDTO(String placa, String marca, String modelo, Double fatorEstacionamento, String horaEntrada, String horaSaida, Double totalEstacionamento, TipoVeiculo tipoVeiculo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.fatorEstacionamento = fatorEstacionamento;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.totalEstacionamento = totalEstacionamento;
        setTipoVeiculo( tipoVeiculo );
    }

    public VeiculoDTO(Veiculo entity) {
        this.placa = entity.getPlaca();
        this.marca = entity.getMarca();
        this.modelo = entity.getModelo();
        this.fatorEstacionamento = entity.getFatorEstacionamento();
        this.horaEntrada = entity.getHoraEntrada();
        this.horaSaida = entity.getHoraSaida();
        this.totalEstacionamento = entity.getTotalEstacionamento();
        this.tipoVeiculo = entity.getTipoVeiculo();
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

    public Veiculo toEntity(){
        return new Veiculo(id,placa,marca,modelo,fatorEstacionamento,horaEntrada,horaSaida,totalEstacionamento,tipoVeiculo);
    }

}
