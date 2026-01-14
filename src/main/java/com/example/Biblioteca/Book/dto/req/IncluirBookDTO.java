//DTO de entrada não tem conversão
//Só valida e carrega dados

package com.example.Biblioteca.Book.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IncluirBookDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String autor;

    private int anoPublicacao;
}
