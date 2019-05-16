package com.relacionamento.table.service.impl;

import com.relacionamento.table.exception.BusinessException;
import com.relacionamento.table.service.ValidateProfessorService;
import org.springframework.stereotype.Service;

@Service
public class ValidateProfessorImpl implements ValidateProfessorService {
    @Override
    public void validate(String nome, String materia) throws BusinessException {
        if(nome == null || nome.isEmpty() || materia == null || materia.isEmpty()){
            throw new BusinessException("Existe campos que não foram inseridos");
        }
    }
}
