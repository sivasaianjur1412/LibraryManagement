package com.cis.librarymanagement.service;

import com.cis.librarymanagement.model.Book;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class BookService {
    private final Map<Integer, Book> integerbookMap = new HashMap<>();
    public Book createBook(Book book) {
        book.setBookId(Math.abs(new Random().nextInt()));
        integerbookMap.put(book.getBookId(), book);
        return book;
    }

    public Book readBook(int bookId) {
        return integerbookMap.get(bookId);
    }

    public Collection<Book> readAllBooks() {
        return integerbookMap.values();
    }

    public Book updateBookData(int bookId, Book updatedbook) {
        System.out.println(integerbookMap);
        if(integerbookMap.containsKey(bookId)) {
            Book book = integerbookMap.get(bookId);
            if(!book.getBookName().isEmpty()) {
                book.setBookName(updatedbook.getBookName());
            }
            if(!book.getAuthor().isEmpty()) {
                book.setAuthor(updatedbook.getAuthor());
            }
            if(!book.getEdition().isEmpty()) {
                book.setEdition(updatedbook.getEdition());
            }
            if(!book.getPrice().isEmpty()) {
                book.setPrice(updatedbook.getPrice());
            }
            integerbookMap.put(bookId, book);
            System.out.println("updated successfully");
            return book;
        }
        return null;
    }

    public Book deletebook(int bookId) {
        return integerbookMap.remove(bookId);
    }
}
