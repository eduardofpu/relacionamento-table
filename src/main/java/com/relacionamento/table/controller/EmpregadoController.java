package com.relacionamento.table.controller;

import com.relacionamento.table.model.Empregado;
import com.relacionamento.table.representation.RequestEmpregado;
import com.relacionamento.table.representation.ResponseEmpregado;
import com.relacionamento.table.service.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v2")
public class EmpregadoController {

    private EmpregadoService empregadoService;

    @Autowired
    public EmpregadoController(EmpregadoService empregadoService) {
        this.empregadoService = empregadoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Empregado> findAll() {
        List<Empregado> list = empregadoService.findAll();
        return list;
    }

    @PostMapping("/request-empregado")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEmpregado create(@Valid @RequestBody RequestEmpregado request) {
        ResponseEmpregado save = empregadoService.create(request);
        return new ResponseEmpregado(save.getId());
    }
}
