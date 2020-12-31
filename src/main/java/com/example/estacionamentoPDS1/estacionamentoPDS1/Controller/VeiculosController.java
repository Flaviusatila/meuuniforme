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

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("{id_estacionamento}")
    public ResponseEntity<VeiculoDTO> cadastrarVeiculo(@RequestBody VeiculoDTO dto, @PathVariable Long id_estacionamento){
        VeiculoDTO veiculoDTO = veiculoService.cadastraVeiculo( dto ,id_estacionamento );
        return ResponseEntity.ok().body( veiculoDTO );
    }

    @GetMapping
    public ResponseEntity<VeiculoDTO> pesquisarPlaca(@RequestParam String placa){
        VeiculoDTO dto = veiculoService.pesquisarPlaca(placa);
        return ResponseEntity.ok().body( dto );
    }

    @PatchMapping("/{id_veiculo}")
    public ResponseEntity<VeiculoDTO> atualizarHoraSaida(@PathVariable Long id_veiculo){
        VeiculoDTO dto = veiculoService.atualizaHoraSaida(id_veiculo);
        return ResponseEntity.ok().body( dto );
    }

}
