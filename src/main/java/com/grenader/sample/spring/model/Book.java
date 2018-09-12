package com.grenader.sample.spring.model;

public class Book {

    private String title;
    private Author author;
    private long isbn;

    public Book(String title, Author author, long isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

//setters and getters omitted


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", isbn=" + isbn +
                '}';
    }
}