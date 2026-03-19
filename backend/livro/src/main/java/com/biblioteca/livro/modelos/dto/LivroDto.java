package com.biblioteca.livro.modelos.dto;

import com.biblioteca.livro.modelos.entidades.Livro;

import lombok.Data;

@Data
public class LivroDto {
  private Long id;
  private String titulo;
  private Long nota;

  public LivroDto(Livro livro){
    this.id = livro.getId();
    this.titulo = livro.getTitulo();
    this.nota = livro.getNota();
  }
}
