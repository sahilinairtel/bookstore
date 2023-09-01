package com.sahil.bookstore.repository;

import com.sahil.bookstore.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author,String> {
    @Query("{ 'name': { $regex: ?0, '$options' : 'i' } }")
    List<Author> findByNameRegex(String regexPattern);

    List<Author> findByName(String name);
}
