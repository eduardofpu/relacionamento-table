package com.relacionamento.table.repository;

import com.relacionamento.table.model.Linguagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinguagensRepository extends JpaRepository<Linguagens, Long> {
}
