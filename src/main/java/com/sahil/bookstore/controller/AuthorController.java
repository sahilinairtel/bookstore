package com.sahil.bookstore.controller;

import com.sahil.bookstore.model.Author;
import com.sahil.bookstore.model.Book;
import com.sahil.bookstore.repository.AuthorRepository;
import com.sahil.bookstore.service.AuthorService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")
    public List<Author> getAuthor(){
        return authorService.getAuthor();
    }

    @PostMapping("/author")
    public Author createAuthor(@Valid @RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @GetMapping("/author/{query}")
    public List<Author> getAuthorByNameRegex(@PathVariable String query){
        return authorService.getAuthorByNameRegex(query);
    }
}
