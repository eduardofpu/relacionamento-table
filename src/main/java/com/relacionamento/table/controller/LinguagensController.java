package com.relacionamento.table.controller;

import com.relacionamento.table.model.Linguagens;
import com.relacionamento.table.representation.RequestLinguagens;
import com.relacionamento.table.representation.ResponseLinguagens;
import com.relacionamento.table.service.LinguagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v3")
public class LinguagensController {

    private LinguagensService programadorService;

    @Autowired
    public LinguagensController(LinguagensService programadorService) {
        this.programadorService = programadorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Linguagens> findAll() {
        List<Linguagens> list = programadorService.findAll();
        return list;
    }

    @PostMapping("/request-linguagem")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseLinguagens create(@Valid @RequestBody RequestLinguagens request) {
        ResponseLinguagens save = programadorService.create(request);
        return new ResponseLinguagens(save.getId());
    }
}
