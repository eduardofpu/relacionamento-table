package com.relacionamento.table.service.impl;

import com.relacionamento.table.model.Departamento;
import com.relacionamento.table.repository.DepartamentoRepository;
import com.relacionamento.table.representation.RequestDepartamento;
import com.relacionamento.table.representation.ResponseDepartamento;
import com.relacionamento.table.service.DepartamentoService;
import com.relacionamento.table.service.ValidateDepartamentoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    private DepartamentoRepository departamentoRepository;
    private ValidateDepartamentoService validateDepartamentoService;
    @Autowired
    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository, ValidateDepartamentoService validateDepartamento) {
        this.departamentoRepository = departamentoRepository;
        this.validateDepartamentoService = validateDepartamento;
    }

    @Override
    public List<Departamento> findAll() {

        List<Departamento> list = departamentoRepository.findAll();
        return list;
    }

    @Override
    @Transactional
    @SneakyThrows
    public ResponseDepartamento create(RequestDepartamento request) {
        Departamento departamento = Departamento.builder()
                .nome(request.getNome())
                .build();
        validateDepartamentoService.validate(request.getNome());
        Departamento req = departamentoRepository.save(departamento);
        return new ResponseDepartamento(req.getId());
    }
}
