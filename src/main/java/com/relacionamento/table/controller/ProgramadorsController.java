package com.relacionamento.table.controller;

import com.relacionamento.table.model.Programadors;
import com.relacionamento.table.representation.RequestProgramadors;
import com.relacionamento.table.representation.ResponseProgramadors;
import com.relacionamento.table.service.ProgramadorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v4")
public class ProgramadorsController {

    private ProgramadorsService linguagemService;

    @Autowired
    public ProgramadorsController(ProgramadorsService linguagemService) {

        this.linguagemService = linguagemService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Programadors> findAll() {
        List<Programadors> list = linguagemService.findAll();
        return list;
    }

    @PostMapping("/request-programador")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseProgramadors create(@Valid @RequestBody RequestProgramadors request) {
        ResponseProgramadors save = linguagemService.create(request);
        return new ResponseProgramadors(save.getId());
    }
}
