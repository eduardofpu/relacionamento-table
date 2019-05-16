package com.relacionamento.table.representation;

import com.relacionamento.table.model.Placa;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class RequestCarro {
    private String modelo;
    private Placa placa;
}
