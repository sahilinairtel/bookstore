package com.sahil.bookstore.repository;

import com.sahil.bookstore.model.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;

    @Test
    void authRepo_findByNameRegex_authorsList(){
        List<Author> authors = authorRepository.findByNameRegex("sa");
        Assertions.assertFalse(authors.isEmpty());

        authors = authorRepository.findByNameRegex("zz");
        Assertions.assertTrue(authors.isEmpty());
    }

    @Test
    void authRepo_findByName_authorList(){
        List<Author> authors = authorRepository.findByName("Sai");
        Assertions.assertTrue(authors.isEmpty());

        authors = authorRepository.findByName("Sai Ram");
        Assertions.assertFalse(authors.isEmpty());
    }
}
