package com.biblioteca.livro.modelos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LivroRequestDto {
  
  @NotBlank(message="título do livro em branco")
  private String titulo;

  private Long nota;
}
