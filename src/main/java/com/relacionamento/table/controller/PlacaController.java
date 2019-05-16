package com.relacionamento.table.controller;

import com.relacionamento.table.model.Placa;
import com.relacionamento.table.representation.RequestPlaca;
import com.relacionamento.table.representation.ResponsePlaca;
import com.relacionamento.table.service.PlacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v6")
public class PlacaController {

    private PlacaService placaService;

    @Autowired
    public PlacaController(PlacaService placaService) {
        this.placaService = placaService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Placa> findAll(){
        return placaService.findAll();
    }

    @PostMapping("/request-placa")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponsePlaca create(@Valid @RequestBody RequestPlaca request){
        return placaService.create(request);
    }
}
