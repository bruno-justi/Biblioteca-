package com.example.Biblioteca.Book.mapper;

import com.example.Biblioteca.Book.BookDTO;
import com.example.Biblioteca.Book.BookFactory;
import com.example.Biblioteca.Book.dto.req.IncluirBookDTO;
import com.example.Biblioteca.Book.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    private final BookFactory bookFactory;

    public BookMapper(BookFactory bookFactory) {
        this.bookFactory = bookFactory;
    }

    // Transforma o DTO de entrada em uma Entidade (usando a Factory)
    public BookModel toEntity(IncluirBookDTO dto) {
        return bookFactory.criar(dto);
    }

    //(Transforma a Entidade em um DTO de resposta usando o métdo estatico do DTO)
    public BookDTO  toDTO(BookModel model) {
        return BookDTO.from(model);
    }
}
    //    public BookModel mapE(BookDTO bookDTO) {
//        BookModel bookModel = new BookModel();
//        bookModel.setId(bookDTO.getId());
//        bookModel.setNome(bookDTO.getNome());
//        bookModel.setAutor(bookDTO.getAutor());
//        bookModel.setAnoPublicacao(bookDTO.getAnoPublicacao());
//
//        return bookModel;
//    }

//    public BookDTO mapD(BookModel bookModel) {
//        BookDTO bookDTO = new BookDTO();
//        bookDTO.setId(bookModel.getId());
//        bookDTO.setNome(bookModel.getNome());
//        bookDTO.setAutor(bookModel.getAutor());
//        bookDTO.setAnoPublicacao(bookModel.getAnoPublicacao());
//
//        return bookDTO;
//    }
// TODO CHAMA DE FABRICA
// TODO essa logica do mapD fica no dto de retorno BOOKDTO
