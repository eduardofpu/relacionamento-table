package com.relacionamento.table.service;

import com.relacionamento.table.exception.BusinessException;

public interface ValidateProfessorService {
    void validate(String nome, String materia) throws BusinessException;
}
