package com.relacionamento.table.service.impl;

import com.relacionamento.table.exception.BusinessException;
import com.relacionamento.table.model.Linguagens;
import com.relacionamento.table.service.ValidateProgramadorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ValidateProgramadorsImpl implements ValidateProgramadorsService {
    @Override
    public void validate(String nome, List<Linguagens> programadores) throws BusinessException {
        int decrementador = programadores.size();
        for (Linguagens j : programadores) {
            while (decrementador > 0) {
                Long id = j.getId();
                if (id == null) {
                    throw new BusinessException("Existe parametros que não foram inseridos");
                }

                if (nome == null || nome.isEmpty() || programadores.size() == 0 || id == null || programadores.isEmpty()) {
                    log.info("Existe parametros que não foram inseridos");
                    throw new BusinessException("Existe parametros que não foram inseridos");
                }
                break;
            }
            decrementador--;
        }
    }
}
