package com.example.estacionamentoPDS1.estacionamentoPDS1.Controller;

import com.example.estacionamentoPDS1.estacionamentoPDS1.DTO.VeiculoDTO;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/veiculos")
//Classe entrada dos end-points do sistema que acessa veiculos e faz
//as interações com o usuario
public class VeiculosController implements Serializable {


    private static final long serialVersionUID = 9168200945787279257L;

    //esta injetando a dependencia do service, entao esta criando automaticamente quando sobre o projeto
    @Autowired
    private VeiculoService veiculoService;

    //annotation que funciona para fazer Inserção no banco
    @PostMapping("{id_estacionamento}")
    public ResponseEntity<VeiculoDTO> cadastrarVeiculo(@RequestBody VeiculoDTO dto, @PathVariable Long id_estacionamento){
        VeiculoDTO veiculoDTO = veiculoService.cadastraVeiculo( dto ,id_estacionamento );
        return ResponseEntity.ok().body( veiculoDTO );
    }

    //annotation que funciona para buscar informações no banco
    @GetMapping
    public ResponseEntity<VeiculoDTO> pesquisarPlaca(@RequestParam String placa){
        VeiculoDTO dto = veiculoService.pesquisarPlaca(placa);
        return ResponseEntity.ok().body( dto );
    }

    //annotation que funciona para fazer Atualização no banco
    @PatchMapping("/{id_veiculo}")
    public ResponseEntity<VeiculoDTO> atualizarHoraSaida(@PathVariable Long id_veiculo){
        VeiculoDTO dto = veiculoService.atualizaHoraSaida(id_veiculo);
        return ResponseEntity.ok().body( dto );
    }

}
