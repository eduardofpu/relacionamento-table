package com.relacionamento.table.service.impl;

import com.relacionamento.table.exception.BusinessException;
import com.relacionamento.table.service.ValidateLinguagensService;
import org.springframework.stereotype.Service;

@Service
public class ValidateLinguagensImpl implements ValidateLinguagensService {
    @Override
    public void validate(String nome) throws BusinessException {
        if(nome == null || nome.isEmpty()){
            throw new BusinessException("O Campo nome não foi inserido");
        }
    }
}
