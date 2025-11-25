package com.example.Biblioteca;

import jakarta.persistence.*;

//JPA = Java persistence API
// Entity transforma uma classe em uma entidade do BD;
@Entity

//Table Cria uma tabela com as colunas(Definindo o nome da tabela inteira!)
@Table(name = "tb_cadastro") //nome da tabela.
public class BookModel {

        //Definindo o ID com a annotation
        @Id
        //Passando a estrategia de definir a sequencia dos ID's
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String nome;
        String autor;
        int anoPublicacao;


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
