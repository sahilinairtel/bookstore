package com.sahil.bookstore.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class Book {
    private String id;
    private int copiesAvailable;
    private Author author;
    private String genre;

    public Book() {
    }

    public Book(String id, int copiesAvailable, Author author, String genre) {
        this.id = id;
        this.copiesAvailable = copiesAvailable;
        this.author = author;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", copiesAvailable=" + copiesAvailable +
                ", authorId='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
