// src/main/java/com/library/MainApp.java
package com.library; // Adjust package if MainApp is in a different one
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApp {
    public static void main(String[] args) { // Corrected: Removed the generic type parameter here
        System.out.println("--- Starting Spring Application ---");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Spring Application Context loaded successfully.");
        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println("BookService bean retrieved from context.");
        bookService.addBook("The Adventures of Tom Sawyer");
        bookService.addBook("Pride and Prejudice");
        String foundBook = bookService.searchBook("The Adventures of Tom Sawyer");
        System.out.println(foundBook);
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("--- Spring Application Finished ---");
    }
}
