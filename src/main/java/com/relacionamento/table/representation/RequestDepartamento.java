package com.relacionamento.table.representation;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class RequestDepartamento {
    private Long id;
    private String nome;
}
