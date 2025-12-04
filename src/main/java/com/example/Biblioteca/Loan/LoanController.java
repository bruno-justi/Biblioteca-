/*package com.example.Biblioteca.Loan;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // Deve retornar apenas livros que NÃO possuem Loan ativo.
    @GetMapping("/livros_disponiveis")
    public String listarLivrosDisponiveis() {
        return "Lista de livros disponíveis para empréstimo.";
    }


    *//*verificar se o livro existe
    verificar se o usuário existe
    verificar se NÃO tem um empréstimo ativo
    criar um Loan com status ACTIVE

    @PostMapping("/loan/{bookId}")
    public ResponseEntity<String> Book(@PathVariable Long bookId) {

    }


    /*localizar Loan ativo
    mudar status para RETURNED
    adicionar endDate
    *//*
    @PostMapping("/loan/return/{bookId}")


    *//*
    todos os empréstimos do usuário
    inclusive ativos e devolvidos
    *//*
    @GetMapping("/loans/usuarios/{userId}")
}*/

