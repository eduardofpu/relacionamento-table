package com.relacionamento.table.service.impl;

import com.relacionamento.table.model.Classe;
import com.relacionamento.table.repository.ClasseRepository;
import com.relacionamento.table.representation.RequestClasse;
import com.relacionamento.table.representation.ResponseClasse;
import com.relacionamento.table.service.ClasseService;
import com.relacionamento.table.service.ValidateClasseService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClasseServiceImpl implements ClasseService {

    private ClasseRepository classeRepository;
    private ValidateClasseService validateClasseService;

    @Autowired
    public ClasseServiceImpl(ClasseRepository classeRepository, ValidateClasseService validateClasseService) {
        this.classeRepository = classeRepository;
        this.validateClasseService = validateClasseService;
    }

    @Override
    public List<Classe> findAll() {
        return classeRepository.findAll();
    }

    @Override
    @SneakyThrows
    @Transactional
    public ResponseClasse create(RequestClasse request) {
        Classe classe = Classe.builder()
                .nome(request.getNome())
                .build();
        validateClasseService.validate(classe.getNome());
        Classe save = classeRepository.save(classe);
        return new ResponseClasse(save.getId());
    }
}
