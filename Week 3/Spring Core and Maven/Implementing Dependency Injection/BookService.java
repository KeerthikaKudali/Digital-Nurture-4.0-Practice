package com.library.service;
import com.library.repository.BookRepository;
public class BookService {
    private BookRepository bookRepository; 
    public BookService() {
        System.out.println("BookService: Default constructor called.");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: setBookRepository() called for injection.");
    }
    public void addBook(String title) {
        System.out.println("BookService: Adding book '" + title + "'...");
        if (bookRepository != null) { // Add a null check for safety during development
            bookRepository.saveBook(title);
        } else {
            System.out.println("ERROR: BookRepository not injected!");
        }
    }
    public String searchBook(String title) {
        System.out.println("BookService: Searching for book '" + title + "'...");
        if (bookRepository != null) {
            return bookRepository.findBook(title);
        }
        return "ERROR: BookRepository not injected!";
    }

    public void initMethod() {
        System.out.println("BookService: Initializing...");
    }
    public void destroyMethod() {
        System.out.println("BookService: Destroying...");
    }
}
