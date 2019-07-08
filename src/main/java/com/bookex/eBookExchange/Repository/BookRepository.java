package com.bookex.eBookExchange.Repository;

import com.bookex.eBookExchange.Model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addNewBook(Book book);

    Book deleteBookById(Long id);

    Book updateBookById(Long id, Book book);

    List<Book> getBooksByCategory(Long categoryId);
}
