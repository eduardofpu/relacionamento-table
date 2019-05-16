package com.relacionamento.table.service;

import com.relacionamento.table.model.Linguagens;
import com.relacionamento.table.representation.RequestLinguagens;
import com.relacionamento.table.representation.ResponseLinguagens;

import java.util.List;

public interface LinguagensService {
    List<Linguagens> findAll();
    ResponseLinguagens create(RequestLinguagens request);

}
