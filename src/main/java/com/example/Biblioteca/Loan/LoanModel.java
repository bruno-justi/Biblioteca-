package com.example.Biblioteca.Loan;


import com.example.Biblioteca.Book.BookModel;
import com.example.Biblioteca.Usuarios.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table (name = "tb_loan")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "book_id")
    private String book;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "data_emprestimo")
    private LocalDateTime loanDate;

    @Column(name = "data_devolucao")
    private LocalDateTime returnDate;

    /*
    * 1 empréstimo → pertence a 1 usuário
      1 usuário -> pode ter vários empréstimos
    */
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) //Foreing Key ou Chave estrangeira.
    private UsuarioModel usuarioModel;
}
