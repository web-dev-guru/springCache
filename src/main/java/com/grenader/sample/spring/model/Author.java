package com.grenader.sample.spring.model;

import java.util.List;
import java.util.Objects;

public class Author {

    private String firstName;
    private String middleName;
    private String lastName;

    private List<Book> books;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        lastName = lastName;
    }

    //setters and getters omitted

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) &&
                Objects.equals(middleName, author.middleName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, middleName, lastName, books);
    }
}