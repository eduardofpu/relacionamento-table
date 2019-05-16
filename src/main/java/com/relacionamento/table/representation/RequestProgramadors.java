package com.relacionamento.table.representation;

import com.relacionamento.table.model.Linguagens;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class RequestProgramadors {
    private String nome;
    private List<Linguagens> linguagens;
}
