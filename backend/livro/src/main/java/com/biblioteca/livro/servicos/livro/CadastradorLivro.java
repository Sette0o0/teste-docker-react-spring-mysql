package com.biblioteca.livro.servicos.livro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.livro.mappers.LivroMapper;
import com.biblioteca.livro.modelos.dto.LivroDto;
import com.biblioteca.livro.modelos.dto.LivroRequestDto;
import com.biblioteca.livro.modelos.entidades.Livro;
import com.biblioteca.livro.repositorios.LivroRepositorio;

@Service
public class CadastradorLivro {
  
  @Autowired
  LivroRepositorio repositorio;

  public LivroDto cadastrar(LivroRequestDto livroRequestDto){
    Livro livro = LivroMapper.toEntity(livroRequestDto);
    return LivroMapper.toDto(repositorio.save(livro));
  }

  public List<LivroDto> cadastrarVarios(List<LivroRequestDto> livrosRequestDto){
    List<Livro> livros = new ArrayList<>();
    for (LivroRequestDto livroRequesDto : livrosRequestDto){
      livros.add(LivroMapper.toEntity(livroRequesDto));
    }

    List<Livro> livrosSalvos = repositorio.saveAll(livros);
    List<LivroDto> livrosSalvosDto = new ArrayList<>();
    for (Livro livroSalvo : livrosSalvos){
      livrosSalvosDto.add(LivroMapper.toDto(livroSalvo));
    }
    return livrosSalvosDto;
  }
}
