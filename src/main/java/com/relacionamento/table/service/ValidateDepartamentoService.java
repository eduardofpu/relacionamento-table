package com.relacionamento.table.service;

import com.relacionamento.table.exception.BusinessException;

public interface ValidateDepartamentoService {
    void validate(String nome) throws BusinessException;
}
