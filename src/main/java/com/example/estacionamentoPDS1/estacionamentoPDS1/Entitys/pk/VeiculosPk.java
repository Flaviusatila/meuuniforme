package com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.pk;

import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Estacionamento;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Veiculo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;
//Classe para fazer a ligação entre veiculo e estacionamento
@Embeddable
public class VeiculosPk implements Serializable {

    private static final long serialVersionUID = 4444243865091832581L;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "estacionamento_id")
    private Estacionamento estacionamento;

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculosPk that = ( VeiculosPk ) o;
        return Objects.equals( veiculo, that.veiculo ) && Objects.equals( estacionamento, that.estacionamento );
    }

    @Override
    public int hashCode() {
        return Objects.hash( veiculo, estacionamento );
    }
}
