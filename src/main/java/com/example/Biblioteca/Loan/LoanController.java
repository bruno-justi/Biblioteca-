package com.example.Biblioteca.Loan;

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

    // Deve retornar apenas livros que NÃO possuem Loan ativo.
    @GetMapping("/situacao")
    public ResponseEntity<List<LoanDTO>> listarLoans() {
        List<LoanDTO> loans = loanService.listarLoans();
        return ResponseEntity.ok(loans);
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






