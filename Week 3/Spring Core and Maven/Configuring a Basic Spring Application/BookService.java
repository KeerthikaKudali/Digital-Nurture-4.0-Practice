// src/main/java/com/library/service/BookService.java
package com.library.service;
import com.library.repository.BookRepository;
public class BookService {
    private final BookRepository bookRepository; 
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor called with BookRepository.");
    }
    public void addBook(String title) {
        System.out.println("BookService: Adding book '" + title + "'...");
        bookRepository.saveBook(title);
    }
    public String searchBook(String title) {
        System.out.println("BookService: Searching for book '" + title + "'...");
        return bookRepository.findBook(title);
    }
    public void initMethod() {
        System.out.println("BookService: Initializing...");
    }
    public void destroyMethod() {
        System.out.println("BookService: Destroying...");
    }
}
