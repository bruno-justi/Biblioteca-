package com.example.Biblioteca.Book;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookModel mapE(BookDTO bookDTO) {
        BookModel bookModel = new BookModel();
        bookModel.setId(bookDTO.getId());
        bookModel.setNome(bookDTO.getNome());
        bookModel.setAutor(bookDTO.getAutor());
        bookModel.setAnoPublicacao(bookDTO.getAnoPublicacao());

        return bookModel;
    }

    public BookDTO mapD(BookModel bookModel) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(bookModel.getId());
        bookDTO.setNome(bookModel.getNome());
        bookDTO.setAutor(bookModel.getAutor());
        bookDTO.setAnoPublicacao(bookModel.getAnoPublicacao());

        return bookDTO;
    }
}
