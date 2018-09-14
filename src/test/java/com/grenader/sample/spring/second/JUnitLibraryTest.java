package com.grenader.sample.spring.second;

import com.grenader.sample.spring.model.Author;
import com.grenader.sample.spring.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:library-spring.xml") //reads XML file within the test folder
public class JUnitLibraryTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testLibraryService() throws Exception {

        LibraryService serv = (LibraryService)applicationContext.getBean("libraryService");

        //preload HashMap with a book
        Book bk = new Book("My First Book", new Author("Apple", "Bee"), 1);
        serv.addBook(bk);

        // will be loaded from getBook method
        Book myBk = serv.getBook("My First Book", new Author("Apple", "Bee"));
        System.out.println("myBk = " + myBk);
        assertEquals(bk, myBk);

        // will be loaded from cache
        Book myBk2 = serv.getBook("My First Book", new Author("Apple", "Bee"));
        System.out.println("myBk2 = " + myBk2);
        assertEquals(bk, myBk2);

        // Clean cache
        serv.clearCacheRegularly();

        // will be loaded from getBook method
        myBk = serv.getBook("My First Book", new Author("Apple", "Bee"));
        System.out.println("after cleaning myBk = " + myBk);
        assertEquals(bk, myBk);

        // will be loaded from cache
        myBk2 = serv.getBook("My First Book", new Author("Apple", "Bee"));
        System.out.println("after cleaning myBk2 = " + myBk2);
        assertEquals(bk, myBk2);

    }
}