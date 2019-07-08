package com.bookex.eBookExchange.Api;

import com.bookex.eBookExchange.Model.Book;
import com.bookex.eBookExchange.Service.Impl.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/book")
public class BookApiController {

    private BookServiceImpl bookService;

    public BookApiController(BookServiceImpl bookService) { this.bookService = bookService; }

    @GetMapping
    public List<Book> getAllBooks(){ return  bookService.getAllBooks(); }

    @RequestMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book addNewBook(@Valid @RequestBody Book post){
        return bookService.addNewBook(post);
    }

    @DeleteMapping("/{id}")
    public Book deleteBookById(@PathVariable("id") Long id){ return bookService.deleteBookById(id); }

    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable("id") Long id, @Valid @RequestBody Book book){
        return bookService.updateBookById(id, book);
    }

    @RequestMapping("/category/{categoryId}")
    public List<Book> getBooksByCategory(@PathVariable("categoryId") Long categoryId){
        return bookService.getBooksByCategory(categoryId);
    }
}
