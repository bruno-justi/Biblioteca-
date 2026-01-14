package com.example.Biblioteca.Book.repository;

import com.example.Biblioteca.Book.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {
}
//TODO PRECISA SEMPRE COLOCAR O @REPOSITORY