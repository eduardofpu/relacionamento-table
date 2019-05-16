package com.relacionamento.table.service;

import com.relacionamento.table.model.Programadors;
import com.relacionamento.table.representation.RequestProgramadors;
import com.relacionamento.table.representation.ResponseProgramadors;

import java.util.List;

public interface ProgramadorsService {
    List<Programadors> findAll();
    ResponseProgramadors create(RequestProgramadors request);
}
