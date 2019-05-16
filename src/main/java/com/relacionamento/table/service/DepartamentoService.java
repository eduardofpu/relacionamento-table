package com.relacionamento.table.service;

import com.relacionamento.table.model.Departamento;
import com.relacionamento.table.representation.RequestDepartamento;
import com.relacionamento.table.representation.ResponseDepartamento;

import java.util.List;

public interface DepartamentoService {
    List<Departamento> findAll();
    ResponseDepartamento create(RequestDepartamento request);
}
