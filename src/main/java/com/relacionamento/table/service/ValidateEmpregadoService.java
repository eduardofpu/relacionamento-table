package com.relacionamento.table.service;

import com.relacionamento.table.exception.BusinessException;

public interface ValidateEmpregadoService {
    void validate(String nome, String salario, Long id) throws BusinessException;
}
