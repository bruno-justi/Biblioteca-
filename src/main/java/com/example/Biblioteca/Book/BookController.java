package com.example.Biblioteca.Book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Mandar uma requisição para mostrar os livros por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarLivrosPorId(@PathVariable Long id) {
        BookDTO book = bookService.listarLivrosPorId(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro com o (ID) " + id + " não foi encontrado.");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List> listarLivros() {
        List<BookDTO> books = bookService.listarLivros();
        return ResponseEntity.ok(books);
    }

    // POST -- Mandar uma requisição para adicionar livro
      @PostMapping("/criar")
    public ResponseEntity<String> criarLivro(@RequestBody BookDTO book) {
        BookDTO novoBook = bookService.adicionarLivro(book);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Livro adicionado com sucesso: " + novoBook.getNome() + " (ID) " + novoBook.getId() );
    }


    // PUT -- Mandar uma requisição para alterar os livros
/*
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarLivro(@PathVariable Long id, @RequestBody BookDTO book) {
        if (bookRepository.existsById(id)) {
            bookService.alterarLivro(id, book);
            return ResponseEntity.ok("Livro alterado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
    }
*/


    // DELETE -- Mandar uma requisição para deletar os livros
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable Long id) {
        if (bookRepository.existsById(id)) {
            bookService.deletarLivroPorId(id);
            return ResponseEntity.ok("Livro com ID: " + id + " deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
    }
}
