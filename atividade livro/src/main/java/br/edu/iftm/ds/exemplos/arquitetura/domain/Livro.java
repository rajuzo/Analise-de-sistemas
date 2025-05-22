package br.edu.iftm.ds.exemplos.arquitetura.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String isbn;
}
