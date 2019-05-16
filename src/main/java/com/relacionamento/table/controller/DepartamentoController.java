package com.relacionamento.table.controller;

import com.relacionamento.table.model.Departamento;
import com.relacionamento.table.representation.RequestDepartamento;
import com.relacionamento.table.representation.ResponseDepartamento;
import com.relacionamento.table.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class DepartamentoController {

    private DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Departamento> findAll(){
        List<Departamento> list = departamentoService.findAll();
        return list;
    }

    @PostMapping("/request-departamento")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDepartamento create(@Valid @RequestBody RequestDepartamento request){
        ResponseDepartamento resp = departamentoService.create(request);
        return new ResponseDepartamento(resp.getId());
    }
}
