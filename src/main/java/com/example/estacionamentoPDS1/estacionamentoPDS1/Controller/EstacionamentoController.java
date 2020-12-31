package com.example.estacionamentoPDS1.estacionamentoPDS1.Controller;

import com.example.estacionamentoPDS1.estacionamentoPDS1.DTO.EstacionamentoDTO;
import com.example.estacionamentoPDS1.estacionamentoPDS1.Service.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/estacionamento")
//Classe entrada dos end-points do sistema que acessa estacionamento e faz
//as interações com o usuario
public class EstacionamentoController implements Serializable {

    private static final long serialVersionUID = -5366041254110567709L;

    //esta injetando a dependencia do service, entao esta criando automaticamente quando sobre o projeto
    @Autowired
    private EstacionamentoService service;

    //annotation que funciona para fazer Inserção no banco
    @PostMapping
    public ResponseEntity<EstacionamentoDTO> cadastrarEstacionamento(@RequestBody EstacionamentoDTO dto){
        EstacionamentoDTO estacionamento = service.cadastrarEstacionamento(dto);
        return ResponseEntity.ok().body( estacionamento );
    }

    //annotation que funciona para fazer atualização no banco
    @PatchMapping("/{id_estacionamento}")
    public ResponseEntity<EstacionamentoDTO> atualizarValorHora(@RequestBody EstacionamentoDTO dto, @PathVariable Long id_estacionamento){
        EstacionamentoDTO estacionamento = service.atulizaHoraEstacionamento(id_estacionamento,dto);
        return ResponseEntity.ok().body( estacionamento );
    }

    //annotation que funciona para buscar informações no banco
    @GetMapping
    public ResponseEntity<EstacionamentoDTO> buscarFaturamento(){
        EstacionamentoDTO estacionamento = service.buscarFaturamento();
        return ResponseEntity.ok().body( estacionamento );
    }
}
