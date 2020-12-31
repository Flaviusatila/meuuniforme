package com.example.estacionamentoPDS1.estacionamentoPDS1.Service;

import com.example.estacionamentoPDS1.estacionamentoPDS1.DTO.EstacionamentoDTO;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Estacionamento;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Veiculo;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Repository.EstacionamentoRepository;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Repository.VeiculoRepository;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Service.exceptions.DataBaseException;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public EstacionamentoDTO cadastrarEstacionamento(EstacionamentoDTO dto) {
        try{
            Estacionamento obj = dto.toEntity();
            estacionamentoRepository.save( obj );
            return dto;
        }catch (Exception e){
            throw new ResourceNotFoundException( e );
        }
    }

    @Transactional
    public EstacionamentoDTO atulizaHoraEstacionamento(Long id, EstacionamentoDTO dto) {
        try {
            Estacionamento entity = estacionamentoRepository.getOne( id );
            entity.setValorHora( dto.getValorHora() );
            estacionamentoRepository.save( entity );
            return dto;
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException( id );
        }
    }

    @Transactional
    public EstacionamentoDTO buscarFaturamento() {
        try{
            Double valorTotal = 0.0;
            Double valorTotalCarro = 0.0;
            Double valorTotalMoto = 0.0;
            Double valorTotalUtilitario = 0.0;

            List<Veiculo> veiculos =  veiculoRepository.findAll();
            EstacionamentoDTO estacionamentoDTO =  new EstacionamentoDTO();
            for (Veiculo veiculo:
                    veiculos) {
                if (veiculo.getTotalEstacionamento() != null) {
                    valorTotal += veiculo.getTotalEstacionamento();
                    if (veiculo.getTipoVeiculo().getCode() == 2)
                        valorTotalUtilitario += veiculo.getTotalEstacionamento();
                    if (veiculo.getTipoVeiculo().getCode() == 1)
                        valorTotalMoto += veiculo.getTotalEstacionamento();
                    if (veiculo.getTipoVeiculo().getCode() == 0)
                        valorTotalCarro += veiculo.getTotalEstacionamento();
                }
            }
            estacionamentoDTO.setTotalFaturamento( valorTotal );
            estacionamentoDTO.setTotalFaturamentoUtilitario( valorTotalUtilitario );
            estacionamentoDTO.setTotalFaturamentoMoto( valorTotalMoto );
            estacionamentoDTO.setTotalFaturamentoCarro( valorTotalCarro );
            return estacionamentoDTO;
        }catch (DataIntegrityViolationException e ){
            throw new DataBaseException( e.getMessage() );
        }

    }
}
