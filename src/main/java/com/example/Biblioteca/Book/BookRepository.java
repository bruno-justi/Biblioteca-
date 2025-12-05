package com.example.Biblioteca.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Long> {
    @Query("""
    SELECT b FROM BookModel b
    WHERE b.id NOT IN (
        SELECT l.book.id FROM LoanModel l WHERE l.status = 'ACTIVE'
    )
""")
    List<BookModel> findBooksWithoutActiveLoan();
}
