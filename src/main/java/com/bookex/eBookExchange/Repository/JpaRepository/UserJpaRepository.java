package com.bookex.eBookExchange.Repository.JpaRepository;

import com.bookex.eBookExchange.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJpaRepository extends JpaRepository<User, Long> {

//    @Query(value = "select u from User u where u.username = username")
    User findByUsername(String username);

}
