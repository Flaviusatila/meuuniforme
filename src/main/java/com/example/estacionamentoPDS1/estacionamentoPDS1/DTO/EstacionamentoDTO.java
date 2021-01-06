package com.example.estacionamentoPDS1.estacionamentoPDS1.DTO;

import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Estacionamento;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
//Classe que faz a integração dos dados
// recebidos para o sistema sem acessar diretamente a base de dados
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstacionamentoDTO implements Serializable {

    private static final long serialVersionUID = -2279197097929539041L;

    //Identificador do objeto
    private Long id;

    //Anotation para identificar o nome no json e linkar com o atributo
    @JsonProperty("valor_hora")
    private Double valorHora;

    //Anotation para identificar o nome no json e linkar com o atributo
    @JsonProperty("total_faturamento")
    private Double totalFaturamento;

    //Anotation para identificar o nome no json e linkar com o atributo
    @JsonProperty("total_faturamento_carro")
    private Double totalFaturamentoCarro;

    //Anotation para identificar o nome no json e linkar com o atributo
    @JsonProperty("total_faturamento_moto")
    private Double totalFaturamentoMoto;

    //Anotation para identificar o nome no json e linkar com o atributo
    @JsonProperty("total_faturamento_utilitario")
    private Double totalFaturamentoUtilitario;

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

    public Estacionamento toEntity(){
        return new Estacionamento(id,valorHora,totalFaturamento,totalFaturamentoCarro,totalFaturamentoMoto,totalFaturamentoUtilitario);
    }
}
