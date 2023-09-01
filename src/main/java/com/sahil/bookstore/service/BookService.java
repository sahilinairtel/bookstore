package com.sahil.bookstore.service;

import com.sahil.bookstore.model.Author;
import com.sahil.bookstore.model.Book;
import com.sahil.bookstore.repository.AuthorRepository;
import com.sahil.bookstore.repository.BookRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

     public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book createBook(Book book){
        return bookRepository.insert(book);
    }

    public List<Book> getBooksByGenre(String query){
        return bookRepository.findByGenre(query);
    }

    public List<Book> getBooksWithGenreAndCopiesMoreThan(String genre,int copiesAvailable){
        return bookRepository.findByGenreAndCopiesAvailableGreaterThan(genre,copiesAvailable);
    }

    public List<Book> getBookByAuthorName(String authorName){
        List<Author> authors = authorRepository.findByName(authorName);
        List<Book> books = new ArrayList<>();
        for(Author author: authors){
            books.addAll(bookRepository.findBooksByAuthorId(author.getId()));
        }
        return books;
    }
}
