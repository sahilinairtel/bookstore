package com.sahil.bookstore.repository;


import com.sahil.bookstore.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    void booksRepo_findByGenre_booksList(){
        List<Book> books = bookRepository.findByGenre("horror");
        Assertions.assertFalse(books.isEmpty());
    }

    @Test
    void booksRepo_findByGenreAndCopiesAvailableGreaterThan_booksList(){
        List<Book> books = bookRepository.findByGenreAndCopiesAvailableGreaterThan("horror",5);
        Assertions.assertFalse(books.isEmpty());
    }

    @Test
    void booksRepo_findBooksByAuthorId_booksList(){
        List<Book> books = bookRepository.findBooksByAuthorId("wrong_id");
        Assertions.assertTrue(books.isEmpty());

        books = bookRepository.findBooksByAuthorId("1");
        Assertions.assertFalse(books.isEmpty());
    }


}
