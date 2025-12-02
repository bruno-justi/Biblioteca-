package com.example.Biblioteca.Usuarios;

import com.example.Biblioteca.Book.BookModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_usuarios ")

//Trabalhando com Lombok, tirando o gasto de ficar fazendo overload.
@NoArgsConstructor
@AllArgsConstructor

@Data //Cria todos os getters e setters.
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @Column(unique = true)
    private String email;

    @Column(name = "CPF", length = 11, unique = true, nullable = false)
    private String cpf;

    //@ManyToOne Um usuário terá direito a pegar apenas um livro por vez!
    @ManyToOne
    @JoinColumn(name = "books_id") //Foreing Key ou Chave estrangeira.
    private BookModel books;

}
