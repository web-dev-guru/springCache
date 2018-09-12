package com.grenader.sample.spring.second;

import com.grenader.sample.spring.model.Author;
import com.grenader.sample.spring.model.Book;

public interface Library {

    public Book getBook(String title, Author author);

    public Book getBook(long isbn);

    public void addBook(Book book);
}


