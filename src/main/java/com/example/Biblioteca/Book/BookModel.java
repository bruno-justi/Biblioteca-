package com.example.Biblioteca.Book;

import com.example.Biblioteca.Usuarios.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//JPA = Java persistence API
@Entity //Entity transforma uma classe em uma entidade do Banco de dados.
@Table(name = "tb_livros") //Table Cria uma tabela com as colunas(Definindo o nome da tabela inteira!)
@NoArgsConstructor
@AllArgsConstructor
@Data
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
}
