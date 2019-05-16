package com.relacionamento.table.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String materia;

    @ManyToMany(targetEntity = Classe.class, fetch=FetchType.EAGER)
    private Set classe;
}
