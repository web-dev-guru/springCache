package com.grenader.sample.spring;

import com.grenader.sample.spring.model.Author;
import com.grenader.sample.spring.model.Book;
import com.grenader.sample.spring.second.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "library-spring.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();

        LibraryService serv = (LibraryService)context.getBean("libraryService");

        //preload HashMap with a book
        Book bk = new Book("My First Book", new Author("Apple", "Bee"), 1);
        serv.addBook(bk);

        Book myBk = serv.getBook("My First Book", new Author("Apple", "Bee"));
        System.out.println("myBk = " + myBk);
        Book myBk2 = serv.getBook("My First Book", new Author("Apple", "Bee"));
        System.out.println("myBk2 = " + myBk2);

    }
}