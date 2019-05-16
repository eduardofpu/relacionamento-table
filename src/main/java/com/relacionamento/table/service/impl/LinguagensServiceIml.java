package com.relacionamento.table.service.impl;

import com.relacionamento.table.model.Linguagens;
import com.relacionamento.table.repository.LinguagensRepository;
import com.relacionamento.table.representation.RequestLinguagens;
import com.relacionamento.table.representation.ResponseLinguagens;
import com.relacionamento.table.service.LinguagensService;
import com.relacionamento.table.service.ValidateLinguagensService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinguagensServiceIml implements LinguagensService {
    private LinguagensRepository programadorRepository;
    private ValidateLinguagensService validadeProgramador;

    @Autowired
    public LinguagensServiceIml(LinguagensRepository programadorRepository, ValidateLinguagensService validadeProgramador) {
        this.programadorRepository = programadorRepository;
        this.validadeProgramador = validadeProgramador;
    }

    @Override
    public List<Linguagens> findAll() {
        return programadorRepository.findAll();
    }

    @Override
    @SneakyThrows
    public ResponseLinguagens create(RequestLinguagens request) {
        Linguagens programador = Linguagens.builder()
                .nome(request.getNome())
                .build();
        validadeProgramador.validate(request.getNome());
        Linguagens save = programadorRepository.save(programador);
        return new ResponseLinguagens(save.getId());
    }
}
