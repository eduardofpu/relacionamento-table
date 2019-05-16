package com.relacionamento.table.controller;

import com.relacionamento.table.model.Professor;
import com.relacionamento.table.representation.RequestProfessor;
import com.relacionamento.table.representation.ResponseProfessor;
import com.relacionamento.table.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v8")
public class ProfessorController {

    private ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> findAll(){
        return professorService.findAll();
    }
    @PostMapping("/request-professor")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseProfessor create(@Valid @RequestBody RequestProfessor request){
        return professorService.create(request);
    }
}
