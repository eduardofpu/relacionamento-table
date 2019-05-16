package com.relacionamento.table.service.impl;

import com.relacionamento.table.exception.BusinessException;
import com.relacionamento.table.service.ValidateDepartamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValidateDepartamentoImpl implements ValidateDepartamentoService {
    @Override
    public void validate(String nome) throws BusinessException {
        if (nome == null || nome.isEmpty()) {
            log.info("O campo nome não foi inserido no payload");
            throw new BusinessException("O campo nome não foi inserido no payload");
        }
    }
}
