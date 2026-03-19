package com.biblioteca.livro.servicos.livro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.livro.mappers.LivroMapper;
import com.biblioteca.livro.modelos.dto.LivroDto;
import com.biblioteca.livro.modelos.entidades.Livro;
import com.biblioteca.livro.repositorios.LivroRepositorio;

@Service
public class BuscadorLivro {
  
  @Autowired
  LivroRepositorio repositorio;

  public LivroDto buscarPorId(Long id){
    Livro livro = repositorio.findById(id).orElse(null);   
    return LivroMapper.toDto(livro);
  }

  public List<LivroDto> buscarTodos(){
    List<Livro> livros = repositorio.findAll();
    List<LivroDto> livrosDto = new ArrayList<>();
    for (Livro livro : livros) {
      livrosDto.add(LivroMapper.toDto(livro));
    }
    return livrosDto;
  }
}
