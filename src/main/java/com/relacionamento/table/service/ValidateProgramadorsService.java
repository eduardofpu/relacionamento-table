package com.relacionamento.table.service;

import com.relacionamento.table.exception.BusinessException;
import com.relacionamento.table.model.Linguagens;

import java.util.List;

public interface ValidateProgramadorsService {
    void validate(String nome, List<Linguagens> programadores) throws BusinessException;
}
