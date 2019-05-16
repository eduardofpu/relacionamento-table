package com.relacionamento.table.service.impl;

import com.relacionamento.table.exception.BusinessException;
import com.relacionamento.table.service.ValidateCarroService;
import org.springframework.stereotype.Service;

@Service
public class ValidateCarroServiceImpl implements ValidateCarroService {
    @Override
    public void validate(String modelo) throws BusinessException {
        if (modelo == null || modelo.isEmpty()){
            throw new BusinessException("O modelo deo carro é obrigatório");
        }
    }
}
