package com.relacionamento.table.service;

import com.relacionamento.table.model.Empregado;
import com.relacionamento.table.representation.RequestEmpregado;
import com.relacionamento.table.representation.ResponseEmpregado;

import java.util.List;

public interface EmpregadoService {
    List<Empregado> findAll();
    ResponseEmpregado create(RequestEmpregado request);
}
