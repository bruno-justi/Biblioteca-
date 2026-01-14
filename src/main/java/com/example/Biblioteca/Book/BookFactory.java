package com.example.Biblioteca.Book;

import com.example.Biblioteca.Book.dto.req.IncluirBookDTO;
import com.example.Biblioteca.Book.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookFactory {

    public BookModel criar(IncluirBookDTO dto) {
        BookModel book = new BookModel();
        book.setNome(dto.getNome());
        book.setAutor(dto.getAutor());
        book.setAnoPublicacao(dto.getAnoPublicacao());
        return book;
    }

}
