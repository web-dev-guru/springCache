package com.grenader.sample.spring.second;

import com.grenader.sample.spring.model.Author;
import com.grenader.sample.spring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;

public class LibraryService {

    @Autowired
    private Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public LibraryService() {
    }

    @Cacheable(value = "books", key = "#title + #author")
    public Book getBook(String title, Author author) {
        System.out.println("!!! We are in the getBook(...) method");
        Book book = library.getBook(title, author);
        if (book != null)
            System.out.println("Book Found! " + book.toString());
        else
            System.out.println("Book Not Found");
        return book;
    }


//    @Scheduled(fixedDelay=2000)
    @CacheEvict(value = "books", allEntries = true)
    public void clearCacheRegularly() {
        System.out.println("Will be called every 2 seconds");
    }

//    @Scheduled(cron="0 0 6 * * *") /* 6am every day */
    @Scheduled(cron="0 58 8 * * *") /* every day at 8:56am*/
    public void clearCacheAtNight() {
        System.out.println("clearCacheAtNight");
    }


    public void addBook(Book book) {
        library.addBook(book);
        System.out.println("Book Added!");
    }

}