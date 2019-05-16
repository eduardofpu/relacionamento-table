package com.relacionamento.table.service.impl;

import com.relacionamento.table.model.Carro;
import com.relacionamento.table.repository.CarroRepository;
import com.relacionamento.table.representation.RequestCarro;
import com.relacionamento.table.representation.ResponseCarro;
import com.relacionamento.table.service.CarroService;
import com.relacionamento.table.service.ValidateCarroService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {
    private CarroRepository carroRepository;
    private ValidateCarroService validateCarroService;

    @Autowired
    public CarroServiceImpl(CarroRepository carroRepository, ValidateCarroService validateCarroService) {
        this.carroRepository = carroRepository;
        this.validateCarroService = validateCarroService;
    }

    @Override
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    @Override
    @SneakyThrows
    @Transactional
    public ResponseCarro create(RequestCarro request) {
        Carro carro = Carro.builder()
                .modelo(request.getModelo())
                .placa(request.getPlaca()).build();

        validateCarroService.validate(carro.getModelo());
        Carro save = carroRepository.save(carro);
        return new ResponseCarro(save.getId());
    }
}
