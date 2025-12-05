package com.example.Biblioteca.Loan;

import com.example.Biblioteca.Book.BookRepository;
import com.example.Biblioteca.Usuarios.UsuarioMapper;
import com.example.Biblioteca.Usuarios.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;
    private final BookRepository bookRepository;
    private final UsuarioRepository usuarioRepository;

    public LoanService(LoanRepository loanRepository, LoanMapper loanMapper, BookRepository bookRepository, UsuarioRepository usuarioRepository) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
        this.bookRepository = bookRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<LoanDTO> listarLoans() {
        List<LoanModel> loans = loanRepository.findAll();
        return loans.stream()
                .map(loanMapper::mapDTO)
                .collect(Collectors.toList());
    }

    public LoanDTO criarLoan(LoanDTO dto) {

        var user = usuarioRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        boolean ativo = loanRepository.existsByBook_IdAndStatus(dto.getBookId(), "ACTIVE");
        if (ativo) {
            throw new RuntimeException("Este livro já está emprestado");
        }

        LoanModel loan = new LoanModel();
        loan.setUsuarioModel(user);
        loan.setBook(book);
        loan.setStatus("ACTIVE");
        loan.setLoanDate(LocalDateTime.now());
        loan.setReturnDate(null);

        LoanModel saved = loanRepository.save(loan);
        return loanMapper.mapDTO(saved);
    }

    public LoanDTO devolverLivro(Long loanId) {
        LoanModel loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado."));

        if (!loan.getStatus().equals("ACTIVE")) {
            throw new RuntimeException("Este empréstimo já foi devolvido.");
        }
        loan.setStatus("RETURNED");
        loan.setReturnDate(LocalDateTime.now());
        LoanModel atualizado = loanRepository.save(loan);
        return loanMapper.mapDTO(atualizado);
    }
}
