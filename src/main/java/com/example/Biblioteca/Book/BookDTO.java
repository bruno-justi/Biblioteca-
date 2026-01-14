package com.example.Biblioteca.Book;
import com.example.Biblioteca.Book.model.BookModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String nome;
    private String autor;
    private int anoPublicacao;

        public static BookDTO from(BookModel model) {
            BookDTO dto = new BookDTO();
            dto.id = model.getId();
            dto.nome = model.getNome();
            dto.autor = model.getAutor();
            dto.anoPublicacao = model.getAnoPublicacao();
            return dto;
        }
    }


