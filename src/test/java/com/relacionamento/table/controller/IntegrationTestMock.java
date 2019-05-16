package com.relacionamento.table.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relacionamento.table.Application;
import com.relacionamento.table.model.Departamento;
import com.relacionamento.table.model.Empregado;
import com.relacionamento.table.repository.DepartamentoRepository;
import com.relacionamento.table.repository.EmpregadoRepository;
import com.relacionamento.table.service.EmpregadoService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class IntegrationTestMock {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;


    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    EmpregadoRepository empregadoRepository;

    protected byte[] buildCompany(String name) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(Departamento.builder().nome(name).build());
    }

    protected Departamento getDepartamento() {
        Departamento request = Departamento
                .builder()
                .nome("RH")
                .build();
        departamentoRepository.save(request);
        return request;
    }

    protected Empregado getEmpregado() {
        Empregado request = Empregado.builder()
                .nome("Daniel").salario("3900")
                .departamento(getDepartamento())
                .build();
        empregadoRepository.save(request);
        return request;
    }
}
