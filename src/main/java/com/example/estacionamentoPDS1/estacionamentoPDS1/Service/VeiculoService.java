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

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;


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
