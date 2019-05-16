package com.relacionamento.table.service;

import com.relacionamento.table.model.Classe;
import com.relacionamento.table.representation.RequestClasse;
import com.relacionamento.table.representation.ResponseClasse;

import java.util.List;

public interface ClasseService {
    List<Classe> findAll();
    ResponseClasse create(RequestClasse request);
}
