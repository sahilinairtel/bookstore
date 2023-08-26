package com.sahil.bookstore.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "author")
public class Author {
    private String id;
    private String name;
    private Address address;

    public Author() {
    }

    public Author(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
