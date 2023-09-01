package com.sahil.bookstore.repository;

import com.sahil.bookstore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    List<Book> findByGenre(String genre);
    List<Book> findByGenreAndCopiesAvailableGreaterThan(String genre, int copiesAvailable);

    List<Book> findBooksByAuthorId(String authorId);
}
