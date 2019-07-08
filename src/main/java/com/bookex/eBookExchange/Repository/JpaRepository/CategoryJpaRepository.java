package com.bookex.eBookExchange.Repository.JpaRepository;

import com.bookex.eBookExchange.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryJpaRepository extends JpaRepository<Category, Long>{

    @Query(value = "select c from Category c order by c.popularity desc")
    List<Category> sortedByPopularity();
}