package com.example.Biblioteca.Book.service;

import com.example.Biblioteca.Book.*;
import com.example.Biblioteca.Book.dto.req.IncluirBookDTO;
import com.example.Biblioteca.Book.mapper.BookMapper;
import com.example.Biblioteca.Book.model.BookModel;
import com.example.Biblioteca.Book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    // Listar todos os livros disponíveis.
    public List<BookDTO> listarLivros() {
        List<BookModel> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Listar os livros por Id
    public BookDTO listarLivrosPorId(Long id) {
        Optional<BookModel> bookPorId = bookRepository.findById(id);
        return bookPorId.map(bookMapper::toDTO).orElse(null);
    }

    // Adicionar um livro na biblioteca
    public BookDTO adicionarLivro(IncluirBookDTO bookDTO) {
        BookModel book = bookMapper.toEntity(bookDTO);
        book = bookRepository.save(book);
        return bookMapper.toDTO(book);
    }

    // Deletar um livro da biblioteca por ID
    public void deletarLivroPorId(Long id) {
        bookRepository.deleteById(id);
    }
}
// TODO SEMPRE TEM Q CRIAR UM SERVICE COMO INTERFACE ENTRE O CONTROLLER E O SERVICE IMPL (IMPLEMENTACAO)
// TODO SEMPRE TEM Q CRIAR PACKAGES SEPARADOS PARA CADA TIPO DE CLASSE (CONTROLLER JUNTO COM DTO, SERVICE JUNTO COM IMPL, REPOSITORY JUNTO COM MODEL, MAPPER)
    // 1. Buscar o Livro pelo ID no repositório.
    // 2. Se não existir, lançar exceção (Livro não encontrado).
    // 3. Verificar a quantidadeDisponivel ou o campo disponivel.
    // 4. Retornar true ou false.
    // Disponibilidade do livro

