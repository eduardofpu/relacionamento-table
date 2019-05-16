package com.relacionamento.table.service.impl;

import com.relacionamento.table.model.Empregado;
import com.relacionamento.table.repository.EmpregadoRepository;
import com.relacionamento.table.representation.RequestEmpregado;
import com.relacionamento.table.representation.ResponseEmpregado;
import com.relacionamento.table.service.EmpregadoService;
import com.relacionamento.table.service.ValidateEmpregadoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpregadoServiceImpl implements EmpregadoService {

    private EmpregadoRepository empregadoRepository;
    private ValidateEmpregadoService validateEmpregadoService;


    @Autowired
    public EmpregadoServiceImpl(EmpregadoRepository empregadoRepository, ValidateEmpregadoService validateEmpregadoService) {
        this.empregadoRepository = empregadoRepository;
        this.validateEmpregadoService = validateEmpregadoService;
    }

    @Override
    public List<Empregado> findAll() {
        List<Empregado> list = empregadoRepository.findAll();
        return list;
    }

    @Override
    @Transactional
    @SneakyThrows
    public ResponseEmpregado create(RequestEmpregado request) {
        Empregado empregado = Empregado.builder()
                .nome(request.getNome())
                .salario(request.getSalario())
                .departamento(request.getDepartamento())
                .build();
        validateEmpregadoService.validate(request.getNome(), request.getSalario(), request.getDepartamento().getId());
        Empregado save = empregadoRepository.save(empregado);
        return new ResponseEmpregado(save.getId());
    }
}
