package com.sahil.bookstore.controller;

import com.sahil.bookstore.model.Book;
import com.sahil.bookstore.repository.BookRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public List<Book> checkHealth(){
        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book, HttpServletResponse response) throws IOException {
        if(book.getCopiesAvailable()==0 || book.getGenre()==null || book.getAuthor()==null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return new Book();
        }
        return bookRepository.save(book);
    }

    @GetMapping("/book/{query}")
    public List<Book> getBooksWithGenre(@PathVariable String query){
        return bookRepository.findByGenre(query);
    }

    @GetMapping("/book/genre-copies")
    public List<Book> getBooksWithGenreAndCopiesMoreThan(@RequestParam(name="genre") String genre, @RequestParam(name="copiesAvailable") int copiesAvailable){
        return bookRepository.findByGenreAndCopiesAvailableGreaterThan(genre,copiesAvailable);
    }

    @GetMapping("/book/author")
    public List<Book> getBookByAuthorName(@RequestParam(name="authorName") String authorName){
        return bookRepository.findBooksByAuthorName(authorName);
    }

}
