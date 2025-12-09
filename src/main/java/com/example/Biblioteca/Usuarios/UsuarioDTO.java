package com.example.Biblioteca.Usuarios;

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

    // Lista contendo ID do empréstimo e ID do livro
    private List<LoanInfo> loans;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoanInfo {
        private Long loanId;
        private Long bookId;
        private String status;
        private String dataEmprestimo;
        private String dataDevolucao;
    }

}

