package com.bookex.eBookExchange.Repository.JpaRepository;

import com.bookex.eBookExchange.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b from Book b order by b.updated_at desc")
    List<Book> sortedByDate();
}
