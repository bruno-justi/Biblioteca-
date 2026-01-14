package com.example.Biblioteca.Loan.mapper;

import com.example.Biblioteca.Book.model.BookModel;
import com.example.Biblioteca.Loan.LoanDTO;
import com.example.Biblioteca.Loan.model.LoanModel;
import com.example.Biblioteca.Usuarios.model.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    // DTO -> Model
    public LoanModel toModel(LoanDTO dto) {
        LoanModel model = new LoanModel();

        model.setId(dto.getId());
        model.setStatus(dto.getStatus());
        model.setLoanDate(dto.getLoanDate());
        model.setReturnDate(dto.getReturnDate());

        // relacionamentos
        if (dto.getBookId() != null) {
            BookModel book = new BookModel();
            book.setId(dto.getBookId());
            model.setBook(book);
        }

        if (dto.getUserId() != null) {
            UsuarioModel user = new UsuarioModel();
            user.setId(dto.getUserId());
            model.setUsuarioModel(user);
        }

        return model;
    }

    // Model -> DTO
    public LoanDTO mapDTO(LoanModel model) {
        LoanDTO dto = new LoanDTO();

        dto.setId(model.getId());
        dto.setStatus(model.getStatus());
        dto.setLoanDate(model.getLoanDate());
        dto.setReturnDate(model.getReturnDate());
        dto.setBookId(model.getBook().getId());
        dto.setUserId(model.getUsuarioModel().getId());

        return dto;
    }
}

