package com.bookex.eBookExchange.Repository.JpaRepository;

import com.bookex.eBookExchange.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

    @Query(value = "select p from Post p order by p.updated_at desc")
    List<Post> sortedPostsByDate();
}
