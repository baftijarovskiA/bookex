package com.bookex.eBookExchange.Repository.JpaRepository;

import com.bookex.eBookExchange.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Long>{
    
}