package com.bookex.eBookExchange.Repository.Impl;

import com.bookex.eBookExchange.Model.Book;
import com.bookex.eBookExchange.Repository.BookRepository;
import com.bookex.eBookExchange.Repository.JpaRepository.BookJpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private BookJpaRepository repository;

    public BookRepositoryImpl(BookJpaRepository repository) { this.repository = repository; }

    @Override
    public List<Book> getAllBooks() {
        return repository.sortedByDate();
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Book addNewBook(Book book) {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.now();
        String localTimeString = FOMATTER.format(localTime);

        book.setCreated_at(localTimeString);
        book.setUpdated_at(localTimeString);

        repository.save(book);
        return null;
    }

    @Override
    public Book deleteBookById(Long id) {
        Optional<Book> book = repository.findById(id);
        repository.delete(book.get());
        return book.get();
    }

    @Override
    public Book updateBookById(Long id, Book book) {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.now();
        String localTimeString = FOMATTER.format(localTime);

        Book b = repository.findById(id).get();

        b.setUpdated_at(localTimeString);
        b.setName(book.getName());
        b.setAuthors(book.getAuthors());
        b.setDescription(book.getDescription());
        b.setPublished(book.getPublished());
        b.setPicture(book.getPicture());
        repository.save(b);
        return b;
    }

    @Override
    public List<Book> getBooksByCategory(Long categoryId) {
        List<Book> books = new ArrayList<>();
        for (Book item : repository.findAll()) {
            if(item.getCategory().getId().equals(categoryId)){
                books.add(item);
            }
        }
        return books;
    }
}
