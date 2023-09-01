package com.sahil.bookstore.service;

import com.sahil.bookstore.model.Author;
import com.sahil.bookstore.repository.AuthorRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    public AuthorRepository authorRepository;

    public List<Author> getAuthor(){
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author){
        return authorRepository.insert(author);
    }

    public List<Author> getAuthorByNameRegex(String query){
        return authorRepository.findByNameRegex(query);
    }
}
