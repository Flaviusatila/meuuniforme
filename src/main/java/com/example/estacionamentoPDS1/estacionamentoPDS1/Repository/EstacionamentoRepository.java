package com.example.estacionamentoPDS1.estacionamentoPDS1.Repository;

import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Classe que faz a conexão do banco de dados para o sistema transformando
//linguagem sql em linguagem java
@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento,Long> {
}
