package com.relacionamento.table.service.impl;

import com.relacionamento.table.model.Placa;
import com.relacionamento.table.repository.PlacaRepository;
import com.relacionamento.table.representation.RequestPlaca;
import com.relacionamento.table.representation.ResponsePlaca;
import com.relacionamento.table.service.PlacaService;
import com.relacionamento.table.service.ValidatePlacaService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PlacaServiceImpl implements PlacaService {

    private PlacaRepository placaRepository;
    private ValidatePlacaService validatePlacaService;

    @Autowired
    public PlacaServiceImpl(PlacaRepository placaRepository, ValidatePlacaService validatePlacaService) {
        this.placaRepository = placaRepository;
        this.validatePlacaService = validatePlacaService;
    }

    @Override
    public List<Placa> findAll() {
        return placaRepository.findAll();
    }

    @Override
    @SneakyThrows
    @Transactional
    public ResponsePlaca create(RequestPlaca request) {

        Placa placa = Placa.builder()
                .placa(request.getPlaca())
                .build();
        validatePlacaService.validate(placa.getPlaca());
        Placa save = placaRepository.save(placa);

        return new ResponsePlaca(save.getId());
    }
}
