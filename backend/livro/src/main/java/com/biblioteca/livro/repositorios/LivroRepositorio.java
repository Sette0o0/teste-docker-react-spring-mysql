package com.biblioteca.livro.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.livro.modelos.entidades.Livro;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {
  
}
