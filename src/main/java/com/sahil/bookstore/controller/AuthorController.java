package com.sahil.bookstore.controller;

import com.sahil.bookstore.model.Author;
import com.sahil.bookstore.repository.AuthorRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/author")
    public List<Author> getAuthor(){
        return authorRepository.findAll();
    }

    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author, HttpServletResponse response){
        System.out.println(author);
        if(author.getName()==null || author.getAddress()==null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return new Author();
        }
        return authorRepository.save(author);
    }
}
