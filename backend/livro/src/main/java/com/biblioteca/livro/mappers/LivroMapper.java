package com.biblioteca.livro.mappers;

import com.biblioteca.livro.modelos.dto.LivroDto;
import com.biblioteca.livro.modelos.dto.LivroRequestDto;
import com.biblioteca.livro.modelos.entidades.Livro;

public class LivroMapper {
  
  public static Livro toEntity(LivroRequestDto livroRequestDto){
    Livro livro = new Livro();
    livro.setTitulo(livroRequestDto.getTitulo());
    livro.setNota(livroRequestDto.getNota());
    return livro;
  }

  public static LivroDto toDto(Livro livro) {
    return new LivroDto(livro);
  }
}
