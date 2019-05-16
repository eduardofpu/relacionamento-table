package com.relacionamento.table.representation;

import com.relacionamento.table.model.Departamento;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class RequestEmpregado {
    private Long id;
    private String nome;
    private String salario;
    private Departamento departamento;
}
