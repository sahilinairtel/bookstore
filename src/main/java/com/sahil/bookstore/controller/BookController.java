package com.sahil.bookstore.controller;

import com.sahil.bookstore.model.Book;
import com.sahil.bookstore.repository.BookRepository;
import com.sahil.bookstore.service.BookService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List<Book> checkHealth(){
        return bookService.getAllBooks();
    }

    @PostMapping("/book")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/book/genre/{query}")
    public List<Book> getBooksByGenre(@PathVariable String query){
        return bookService.getBooksByGenre(query);
    }

    @GetMapping("/book/genre-copies")
    public List<Book> getBooksWithGenreAndCopiesMoreThan(@RequestParam(name="genre") String genre, @RequestParam(name="copiesAvailable") int copiesAvailable){
        return bookService.getBooksWithGenreAndCopiesMoreThan(genre,copiesAvailable);
    }

    @GetMapping("/book/author")
    public List<Book> getBookByAuthorName(@RequestParam(name="authorName") String authorName){
        return bookService.getBookByAuthorName(authorName);
    }

}
