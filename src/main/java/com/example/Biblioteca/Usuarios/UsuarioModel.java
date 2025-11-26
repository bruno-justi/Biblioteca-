package com.example.Biblioteca.Usuarios;

import com.example.Biblioteca.Book.BookModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_usuarios ")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;

    //@ManyToOne Um usuário terá direito a pegar apenas um livro por vez!
    @ManyToOne
    @JoinColumn(name = "books_id") //Foreing Key ou Chave estrangeira.
    private BookModel books;


    public UsuarioModel() {
    }

    public UsuarioModel(long id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
