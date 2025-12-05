package com.example.Biblioteca.Book;

import com.example.Biblioteca.Usuarios.UsuarioModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

//JPA = Java persistence API
@Entity //Entity transforma uma classe em uma entidade do Banco de dados.
@Table(name = "tb_livros") //Table Cria uma tabela com as colunas(Definindo o nome da tabela inteira!)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookModel {

        //Definindo o ID com a annotation
        @Id
        //Passando a estrategia de definir a sequencia dos ID's
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "nome")
        private String nome;

        @Column(name = "autor")
        private String autor;

        @Column(name = "anoPublicacao")
        private int anoPublicacao;

}
