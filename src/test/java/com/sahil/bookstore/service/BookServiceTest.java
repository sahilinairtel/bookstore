package com.sahil.bookstore.service;

import com.sahil.bookstore.model.Book;
import com.sahil.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTest {

    @Autowired BookService bookService;
    @MockBean
    BookRepository bookRepository;

    @Test
    void booksService_functionName_returnValue(){
        when(bookRepository.findAll()).thenReturn(Stream.of(new Book()))
        List<Book> books = bookService.getAllBooks();
    }

}
