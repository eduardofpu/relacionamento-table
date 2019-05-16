package com.relacionamento.table.repository;

import com.relacionamento.table.model.Programadors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramadorsRepository extends JpaRepository<Programadors, Long> {
}
