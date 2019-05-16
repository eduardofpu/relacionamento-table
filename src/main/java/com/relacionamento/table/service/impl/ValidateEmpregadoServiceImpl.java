package com.relacionamento.table.service.impl;

import com.relacionamento.table.exception.BusinessException;
import com.relacionamento.table.service.ValidateEmpregadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValidateEmpregadoServiceImpl implements ValidateEmpregadoService {
    @Override
    public void validate(String nome, String salario, Long id) throws BusinessException {
        if (nome == null || nome.isEmpty() || salario == null || salario.isEmpty() || id == null ) {
            log.info("Existe parametros que não foram inseridos");
            throw new BusinessException("Existe parametros que não foram inseridos");
        }
    }
}
