package com.relacionamento.table.representation;

import com.relacionamento.table.model.Classe;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class RequestProfessor {

    private String nome;
    private String materia;
    private Set<Classe> classe;
}
