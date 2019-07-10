package com.bookex.eBookExchange.Repository;

import com.bookex.eBookExchange.Model.User;

import java.util.List;

public interface UserRepository {

    User findByUsername(String username);

    List<User> getAllUsers();

    User getUserById(Long id);

    User addNewUser(User user);

    User deleteUserBy(Long id);
}
