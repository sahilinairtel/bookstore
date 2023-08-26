package com.sahil.bookstore.controller;

import com.sahil.bookstore.model.Book;
import com.sahil.bookstore.repository.BookRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        if(book.getCopiesAvailable()==0 || book.getGenre()==null || book.getAuthorId()==null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return new Book();
        }
        return bookRepository.save(book);
    }

}
