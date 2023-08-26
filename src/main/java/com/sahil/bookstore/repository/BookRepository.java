package com.sahil.bookstore.repository;

import com.sahil.bookstore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {
}
