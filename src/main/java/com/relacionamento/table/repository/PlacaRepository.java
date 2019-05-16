package com.relacionamento.table.repository;

import com.relacionamento.table.model.Placa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacaRepository extends JpaRepository<Placa, Long> {
}
