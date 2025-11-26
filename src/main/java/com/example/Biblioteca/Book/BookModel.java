package com.example.Biblioteca.Book;

import com.example.Biblioteca.Usuarios.UsuarioModel;
import jakarta.persistence.*;

import java.util.List;

//JPA = Java persistence API
//Entity transforma uma classe em uma entidade do Banco de dados.
@Entity
//Table Cria uma tabela com as colunas(Definindo o nome da tabela inteira!)
@Table(name = "tb_livros")
public class BookModel {

        //Definindo o ID com a annotation
        @Id
        //Passando a estrategia de definir a sequencia dos ID's
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String autor;
        private int anoPublicacao;

        //@OneToMany Um tipo de Livro pode ser usado por varios usuários.
        @OneToMany(mappedBy = "books")
        private List<UsuarioModel> usuario;

    public BookModel() {
    }

    public BookModel(Long id, String nome, String autor, int anoPublicacao) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
