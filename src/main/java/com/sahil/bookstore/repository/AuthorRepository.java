package com.sahil.bookstore.repository;

import com.sahil.bookstore.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author,String> {
}
