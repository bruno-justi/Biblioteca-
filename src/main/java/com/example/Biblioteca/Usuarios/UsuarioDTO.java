package com.example.Biblioteca.Usuarios;
import com.example.Biblioteca.Book.BookModel;
import com.example.Biblioteca.Loan.LoanDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

        private Long id;
        private String nome;
        private String imgUrl;
        private int idade;
        private String email;
        private String cpf;
        private List<LoanDTO> loans;

    }

