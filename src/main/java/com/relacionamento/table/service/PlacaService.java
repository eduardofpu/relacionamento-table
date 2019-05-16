package com.relacionamento.table.service;

import com.relacionamento.table.model.Placa;
import com.relacionamento.table.representation.RequestPlaca;
import com.relacionamento.table.representation.ResponsePlaca;

import java.util.List;

public interface PlacaService {
    List<Placa> findAll();
    ResponsePlaca create(RequestPlaca request);
}
