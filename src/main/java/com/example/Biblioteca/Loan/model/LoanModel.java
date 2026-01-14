package com.example.Biblioteca.Loan.model;


import com.example.Biblioteca.Book.model.BookModel;
import com.example.Biblioteca.Usuarios.model.UsuarioModel;
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

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookModel book;

    @Column(name = "status")
    private String status;

    @Column(name = "data_emprestimo", nullable = false)
    private LocalDateTime loanDate;

    @Column(name = "data_devolucao")
    private LocalDateTime returnDate;


    /*
    * 1 empréstimo → pertence a 1 usuário
      1 usuário -> pode ter vários empréstimos
    */

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuarioModel;
}
