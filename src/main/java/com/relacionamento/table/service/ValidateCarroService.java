package com.relacionamento.table.service;

import com.relacionamento.table.exception.BusinessException;

public interface ValidateCarroService {
    void validate(String modelo) throws BusinessException;
}
