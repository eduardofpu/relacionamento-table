package com.relacionamento.table.service;

import com.relacionamento.table.exception.BusinessException;

public interface ValidateClasseService {
    void validate(String nome) throws BusinessException;
}
