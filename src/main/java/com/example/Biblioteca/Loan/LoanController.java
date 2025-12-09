package com.example.Biblioteca.Loan;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // Retorna todos os empréstimos e suas situações
    @GetMapping("/situacao")
    public ResponseEntity<List<LoanDTO>> listarLoans() {
        List<LoanDTO> loans = loanService.listarLoans();
        return ResponseEntity.ok(loans);
    }

    // Retorna os empréstimos por um ID de empréstimo específico
    @GetMapping("/situacao/{id}")
    public ResponseEntity<?> listarLoansPorId(@PathVariable Long id) {
        LoanDTO loan = loanService.listarLoansPorId(id);
        if (loan != null) {
            return ResponseEntity.ok(loan);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Empréstimo com o (ID) " + id + " não foi encontrado.");
        }
    }


    /*verificar se o livro existe
    verificar se o usuário existe
    verificar se NÃO tem um empréstimo ativo
    cria um Loan com status ACTIVE
     */
    @PostMapping("/criar")
    public ResponseEntity<?> criarLoan(@RequestBody LoanDTO loanDTO) {
        try {
            LoanDTO criarLoan = loanService.criarLoan(loanDTO);
            return ResponseEntity.ok(criarLoan);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Devolver emprestimo do livro
    @PutMapping("/devolver/{id}")
    public ResponseEntity<?> devolverLoan(@PathVariable Long id) {
        try {
            LoanDTO devolvido = loanService.devolverLivro(id);
            return ResponseEntity.ok(devolvido);
        } catch (RuntimeException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

      /*verificar se o livro existe
    verificar se o usuário existe
    verificar se NÃO tem um empréstimo ativo
    */
}






