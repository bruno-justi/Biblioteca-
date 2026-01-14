package com.example.Biblioteca.Book.controller;

import com.example.Biblioteca.Book.BookDTO;
import com.example.Biblioteca.Book.mapper.BookMapper;
import com.example.Biblioteca.Book.model.BookModel;
import com.example.Biblioteca.Book.repository.BookRepository;
import com.example.Biblioteca.Book.service.BookService;
import com.example.Biblioteca.Book.dto.req.IncluirBookDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Biblioteca.constants.authorities.AuthoritiesConstants.ROLE_ADMIN;

//LOCALHOST:8080/adicionar

@RestController
@RequestMapping("/livros")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    // Mandar uma requisição para mostrar os livros por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<BookDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.listarLivrosPorId(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<BookDTO>> listarLivros() {
        return ResponseEntity.ok(bookService.listarLivros());
    }


    // POST -- Mandar uma requisição para adicionar livro
    @PostMapping("/criar")
    public ResponseEntity<BookDTO> criarLivro(@RequestBody IncluirBookDTO dto) {
        BookDTO bookCriado = bookService.adicionarLivro(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookCriado);
    }



    // DELETE -- Mandar uma requisição para deletar os livros
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        bookService.deletarLivroPorId(id);
        return ResponseEntity.noContent().build();
    }
    }
//TODO nao pode chamar o repository no controller tem que passar pelo service

//    @GetMapping("/teste")
//    @PreAuthorize("hasRole('" + ROLE_ADMIN + "')")  //Exemplo de proteção de endpoint
//    @Operation(summary = "Endpoint de teste protegido para ADMIN")
//    public

