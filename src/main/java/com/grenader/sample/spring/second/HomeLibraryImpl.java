package com.grenader.sample.spring.second;

import com.grenader.sample.spring.model.Author;
import com.grenader.sample.spring.model.Book;

import java.util.HashMap;
import java.util.Map;

public class HomeLibraryImpl implements Library {

    Map<String, Book> shelves = new HashMap<String, Book>();
    Map<Long, Book> shelves2 = new HashMap<Long, Book>();

    public Book getBook(String title, Author author) {
        return shelves.get(title + author.toString());
    }

    public Book getBook(long isbn) {
        return shelves2.get(new Long(isbn));
    }

    public void addBook(Book book) {
        shelves.put(book.getTitle() + book.getAuthor().toString(), book);
        shelves2.put(new Long(book.getIsbn()), book);
    }
}