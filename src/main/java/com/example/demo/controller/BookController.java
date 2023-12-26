package com.example.demo.controller;

import com.example.demo.service.BookService;
import com.example.demo.model.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/{isbn}")
    public Optional<Book> getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }
}

