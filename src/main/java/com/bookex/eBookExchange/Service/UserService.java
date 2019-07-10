package com.bookex.eBookExchange.Service;

import com.bookex.eBookExchange.Model.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);

    List<User> getAllUsers();

    User getUserById(Long id);

    User addNewUser(User user);

    User deleteUserBy(Long id);
}
