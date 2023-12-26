package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom query to find a book by its ISBN
    Optional<Book> findByIsbn(String isbn);
}

