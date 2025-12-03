package com.example.Biblioteca.Book;
import com.example.Biblioteca.Usuarios.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String nome;
    private String autor;
    private int anoPublicacao;
    private UsuarioModel usuario;

}
