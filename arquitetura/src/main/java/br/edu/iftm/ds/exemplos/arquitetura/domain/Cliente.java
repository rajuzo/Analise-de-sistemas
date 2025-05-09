package br.edu.iftm.ds.exemplos.arquitetura.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Cliente {

    private Integer codigo;

    private String nome;

}
