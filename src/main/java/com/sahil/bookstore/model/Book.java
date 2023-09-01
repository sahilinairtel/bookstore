package com.sahil.bookstore.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class Book {
    @Id
    private String id;

    @Positive(message = "copies available can not be negative")
    private int copiesAvailable;

    @NotBlank(message = "Author id can't be blank")
    private String authorId;

    @NotBlank(message = "genre can't be blank")
    private String genre;

    public Book() {
    }

    public Book(String id, int copiesAvailable, String authorId, String genre) {
        this.id = id;
        this.copiesAvailable = copiesAvailable;
        this.authorId = authorId;
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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthor(String authorId) {
        this.authorId = authorId;
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
                ", authorId='" + authorId + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
