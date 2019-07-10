package com.bookex.eBookExchange.Service.Impl;

import com.bookex.eBookExchange.Model.User;
import com.bookex.eBookExchange.Repository.Impl.UserRepositoryImpl;
import com.bookex.eBookExchange.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepositoryImpl repository;

    public UserServiceImpl(UserRepositoryImpl repository) { this.repository = repository; }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return repository.getUserById(id);
    }

    @Override
    public User addNewUser(User user) {
        return repository.addNewUser(user);
    }

    @Override
    public User deleteUserBy(Long id) {
        return repository.deleteUserBy(id);
    }
}
