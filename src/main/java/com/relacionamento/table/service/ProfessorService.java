package com.relacionamento.table.service;

import com.relacionamento.table.model.Professor;
import com.relacionamento.table.representation.RequestProfessor;
import com.relacionamento.table.representation.ResponseProfessor;

import java.util.List;

public interface ProfessorService {
    List<Professor> findAll();
    ResponseProfessor create(RequestProfessor request);
}
