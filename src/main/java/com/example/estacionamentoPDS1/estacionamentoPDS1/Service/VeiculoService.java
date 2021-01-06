package com.example.estacionamentoPDS1.estacionamentoPDS1.Service;

import com.example.estacionamentoPDS1.estacionamentoPDS1.DTO.VeiculoDTO;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Veiculo;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Repository.VeiculoRepository;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

//Classe que faz toda a logica de sistema de negocios do sistema;
@Service
public class VeiculoService {

    //esta injetando a dependencia do service, entao esta criando automaticamente quando sobre o projeto
    @Autowired
    private VeiculoRepository repository;

    //metodo que cadastra o veiculo em um estacionamento na base de dados atraves do veiculoRepository
    public VeiculoDTO cadastraVeiculo(VeiculoDTO dto , Long id) {

        try{
            Veiculo obj = dto.toEntity();
            obj.setEstacionamentoId( id );
            repository.save( obj );
            return dto;
        }catch (Exception e){
            throw new ResourceNotFoundException( e );
        }


    }


    //Anotation que faz o controle de busca de acordo com o tempo
    //Metodo que busca os o veiculo pela placa
    @Transactional
    public VeiculoDTO pesquisarPlaca(String placa){
        try {
            List<Veiculo> veiculos = repository.findAll();
            for (Veiculo veiculo :
                    veiculos) {
                if (veiculo.getPlaca().equals( placa )) {
                    return new VeiculoDTO( veiculo );
                }
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException( e );
        }
            throw new ResourceNotFoundException( "Nao Encontrada nenhuma placa" );
    }
    //Anotation que faz o controle de busca de acordo com o tempo
    //Metodo que atuliza a hora de saida de um veiculo pelo id do veiculo
    @Transactional
    public VeiculoDTO atualizaHoraSaida(Long id) {
        try {
            Veiculo entity = repository.getOne( id );
            entity.setHoraSaida( "Saiu" );
            entity = repository.save( entity );
            return new VeiculoDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException( id );
        }
    }
}
