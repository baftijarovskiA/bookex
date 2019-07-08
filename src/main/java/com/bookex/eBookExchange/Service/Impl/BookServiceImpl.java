package com.bookex.eBookExchange.Service.Impl;

import com.bookex.eBookExchange.Model.Book;
import com.bookex.eBookExchange.Repository.Impl.BookRepositoryImpl;
import com.bookex.eBookExchange.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepositoryImpl repository;

    public BookServiceImpl(BookRepositoryImpl repository) { this.repository = repository; }

    @Override
    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }

    @Override
    public Book getBookById(Long id) {
        return repository.getBookById(id);
    }

    @Override
    public Book addNewBook(Book book) {
        return repository.addNewBook(book);
    }

    @Override
    public Book deleteBookById(Long id) {
        return repository.deleteBookById(id);
    }

    @Override
    public Book updateBookById(Long id, Book book) {
        return repository.updateBookById(id, book);
    }

    @Override
    public List<Book> getBooksByCategory(Long categoryId) {
        return repository.getBooksByCategory(categoryId);
    }
}
