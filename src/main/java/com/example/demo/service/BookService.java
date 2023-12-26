package com.example.demo.service;

import com.example.demo.repository.BookRepository;
import com.example.demo.model.Book;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor for dependency injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        // Implement the logic to retrieve a book by its ISBN
        // For example, this could involve a database call
        return bookRepository.findByIsbn(isbn);
    }
}
