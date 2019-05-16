package com.relacionamento.table.service;

import com.relacionamento.table.model.Carro;
import com.relacionamento.table.representation.RequestCarro;
import com.relacionamento.table.representation.ResponseCarro;

import java.util.List;

public interface CarroService {
    List<Carro> findAll();
    ResponseCarro create(RequestCarro request);
}
