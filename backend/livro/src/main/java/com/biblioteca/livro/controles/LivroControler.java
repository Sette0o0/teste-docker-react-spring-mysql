package com.biblioteca.livro.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.livro.modelos.dto.LivroDto;
import com.biblioteca.livro.modelos.dto.LivroRequestDto;
import com.biblioteca.livro.servicos.livro.BuscadorLivro;
import com.biblioteca.livro.servicos.livro.CadastradorLivro;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroControler {
 
  @Autowired
  BuscadorLivro buscador;
  @Autowired
  CadastradorLivro cadastrador;

  @GetMapping("/{id}")
  public LivroDto buscar(@PathVariable Long id){
    return buscador.buscarPorId(id);    
  }

  @GetMapping
  public List<LivroDto> buscarTodos(){
    return buscador.buscarTodos();
  }

  @PostMapping
  public LivroDto cadastrar(@RequestBody @Valid LivroRequestDto livroRequestDto){
    return cadastrador.cadastrar(livroRequestDto);
  }
}
