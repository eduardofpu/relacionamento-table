package com.relacionamento.table.service.impl;

import com.relacionamento.table.exception.BusinessException;
import com.relacionamento.table.service.ValidatePlacaService;
import org.springframework.stereotype.Service;

@Service
public class ValidatePlacaServiceImpl implements ValidatePlacaService {
    @Override
    public void validate(String placa) throws BusinessException {
        if (placa == null || placa.isEmpty()){
            throw new BusinessException("A placa é obrigatória");
        }
    }
}
