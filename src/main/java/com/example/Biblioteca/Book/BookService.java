package com.example.Biblioteca.Book;

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
                .map(bookMapper::mapD)
                .collect(Collectors.toList());
    }

    // Listar os livros por Id
    public BookDTO listarLivrosPorId(Long id) {
        Optional<BookModel> bookPorId = bookRepository.findById(id);
        return bookPorId.map(bookMapper::mapD).orElse(null);
    }

    // Adicionar um livro na biblioteca
    public BookDTO adicionarLivro(BookDTO bookDTO) {
        BookModel book = bookMapper.mapE(bookDTO);
        book = bookRepository.save(book);
        return bookMapper.mapD(book);
    }

    // Deletar um livro da biblioteca por ID
    public void deletarLivroPorId(Long id) {
        bookRepository.deleteById(id);
    }
}


    // 1. Buscar o Livro pelo ID no repositório.
    // 2. Se não existir, lançar exceção (Livro não encontrado).
    // 3. Verificar a quantidadeDisponivel ou o campo disponivel.
    // 4. Retornar true ou false.
    // Disponibilidade do livro

