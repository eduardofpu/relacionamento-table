package com.relacionamento.table.service.impl;

import com.relacionamento.table.exception.BusinessException;
import com.relacionamento.table.service.ValidateClasseService;
import org.springframework.stereotype.Service;

@Service
public class ValidateClasseImpl implements ValidateClasseService {
    @Override
    public void validate(String nome) throws BusinessException {

        if(nome == null || nome.isEmpty()){
            throw new BusinessException("O nome é obrigatório");
        }
    }
}
