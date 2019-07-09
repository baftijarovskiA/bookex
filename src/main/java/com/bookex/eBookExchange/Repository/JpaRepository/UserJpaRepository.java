package com.bookex.eBookExchange.Repository.JpaRepository;

import com.bookex.eBookExchange.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
