package com.example.estacionamentoPDS1.estacionamentoPDS1.Repository;

import com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento,Long> {
}
