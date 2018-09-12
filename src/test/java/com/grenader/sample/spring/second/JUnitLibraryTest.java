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

        Book myBk = serv.getBook("My First Book", new Author("Apple", "Bee"));
        assertEquals(bk, myBk);
        myBk = serv.getBook("My First Book", new Author("Apple", "Bee"));
        assertEquals(bk, myBk);
    }
}