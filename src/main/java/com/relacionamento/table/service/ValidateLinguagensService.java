package com.relacionamento.table.service;

import com.relacionamento.table.exception.BusinessException;

public interface ValidateLinguagensService {
    void validate(String nome) throws BusinessException;
}
