package com.relacionamento.table.controller;

import com.relacionamento.table.model.Classe;
import com.relacionamento.table.representation.RequestClasse;
import com.relacionamento.table.representation.ResponseClasse;
import com.relacionamento.table.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v7")
public class ClasseController {

    private ClasseService classeService;

    @Autowired
    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Classe> findAll(){
        return classeService.findAll();
    }

    @PostMapping("/request-classe")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseClasse create(@Valid @RequestBody RequestClasse request){

        return classeService.create(request);
    }
}
