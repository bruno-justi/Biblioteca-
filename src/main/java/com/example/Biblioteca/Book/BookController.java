package com.example.Biblioteca.Book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

//LOCALHOST:8080/adicionar

@RestController
@RequestMapping("/livros")
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    // Mandar uma requisição para mostrar os livros
    @Operation(summary = "Lista todas as missões",  description = "A rota entrega uma lista de todas as missões")
    @ApiResponses(value = {@ApiResponse (responseCode = "200", description = "Livros listados com sucesso!")})
    public ResponseEntity<List<BookDTO>> listarBooks() {
        return ResponseEntity.ok(bookService.listarLivros());
    }

    // POST -- Mandar uma requisição para adicionar livro
    @PostMapping("/criar")
    public ResponseEntity<String> criarLivro(@RequestBody BookDTO book) {
        BookDTO novoBook = bookService.adicionarLivro(book);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Livro adicionado com sucesso: " + novoBook.getNome() + "(ID:) " + novoBook.getId() );
    }


    // PUT -- Mandar uma requisição para alterar os livros
    @PutMapping("/alterar")
    public String alterarLivro() {
        return ("Livro alterado com sucesso!");
    }

    // DELETE -- Mandar uma requisição para deletar os livros
    @DeleteMapping("/devolucao")
    public String deletarLivro() {
        return ("Livro deletado com sucesso!");
    }
}
