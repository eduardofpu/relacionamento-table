package com.relacionamento.table.controller;

import com.relacionamento.table.model.Carro;
import com.relacionamento.table.representation.RequestCarro;
import com.relacionamento.table.representation.ResponseCarro;
import com.relacionamento.table.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v5")
public class CarroController {

    private CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Carro> findAll(){
        return carroService.findAll();
    }

    @PostMapping("/request-carro")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseCarro create(@Valid @RequestBody RequestCarro request){
        return carroService.create(request);
    }
}
