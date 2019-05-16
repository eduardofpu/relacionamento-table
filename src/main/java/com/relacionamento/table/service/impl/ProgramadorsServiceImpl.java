package com.relacionamento.table.service.impl;

import com.relacionamento.table.model.Programadors;
import com.relacionamento.table.repository.ProgramadorsRepository;
import com.relacionamento.table.repository.LinguagensRepository;
import com.relacionamento.table.representation.RequestProgramadors;
import com.relacionamento.table.representation.ResponseProgramadors;
import com.relacionamento.table.service.ProgramadorsService;
import com.relacionamento.table.service.ValidateProgramadorsService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProgramadorsServiceImpl implements ProgramadorsService {
    private ProgramadorsRepository programadorsRepository;
    private ValidateProgramadorsService validateLimguagem;
    private LinguagensRepository programadorRepository;

    @Autowired
    public ProgramadorsServiceImpl(ProgramadorsRepository linguagemRepository, ValidateProgramadorsService validateLimguagem, LinguagensRepository programadorRepository) {
        this.programadorsRepository = linguagemRepository;
        this.validateLimguagem = validateLimguagem;
        this.programadorRepository = programadorRepository;
    }

    @Override
    public List<Programadors> findAll() {
        return programadorsRepository.findAll();
    }

    @Override
    @Transactional
    @SneakyThrows
    public ResponseProgramadors create(RequestProgramadors request) {

        Programadors linguagem = Programadors.builder()
                .nome(request.getNome())
                .linguagens(request.getLinguagens())
                .build();

        validateLimguagem.validate(linguagem.getNome(), linguagem.getLinguagens());
        Programadors save = programadorsRepository.save(linguagem);
        return new ResponseProgramadors(save.getId());
    }
}
