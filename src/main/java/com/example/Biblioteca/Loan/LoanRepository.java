package com.example.Biblioteca.Loan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<LoanModel,Long> {
    boolean existsByBook_IdAndStatus(Long bookId, String status);

    List<LoanModel> Id(Long id);
}
