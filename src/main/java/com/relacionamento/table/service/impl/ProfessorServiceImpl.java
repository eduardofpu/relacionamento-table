package com.relacionamento.table.service.impl;

import com.relacionamento.table.model.Professor;
import com.relacionamento.table.repository.ProfessorRepository;
import com.relacionamento.table.representation.RequestProfessor;
import com.relacionamento.table.representation.ResponseProfessor;
import com.relacionamento.table.service.ProfessorService;
import com.relacionamento.table.service.ValidateProfessorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;
    private ValidateProfessorService validateProfessorService;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository, ValidateProfessorService validateProfessorService) {
        this.professorRepository = professorRepository;
        this.validateProfessorService = validateProfessorService;
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    @SneakyThrows
    @Transactional
    public ResponseProfessor create(RequestProfessor request) {

        Professor professor = Professor.builder()
                .nome(request.getNome())
                .materia(request.getMateria())
                .classe(request.getClasse())
                .build();
        validateProfessorService.validate(professor.getNome(), professor.getMateria());
        Professor save = professorRepository.save(professor);
        return new ResponseProfessor(save.getId());
    }
}
