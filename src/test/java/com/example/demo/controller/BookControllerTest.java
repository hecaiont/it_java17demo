package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetBookByIsbn() throws Exception {
        // Setup mock behavior
        when(bookService.getBookByIsbn("123456")).thenReturn(Optional.of(new Book("Example Title", "Author Name", "123456", 2023, "Fiction")));

        // Perform the test
        mockMvc.perform(get("/books/123456"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Example Title")));
    }
}


