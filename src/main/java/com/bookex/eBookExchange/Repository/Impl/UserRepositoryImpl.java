package com.bookex.eBookExchange.Repository.Impl;

import com.bookex.eBookExchange.Model.User;
import com.bookex.eBookExchange.Repository.JpaRepository.UserJpaRepository;
import com.bookex.eBookExchange.Repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl  implements UserRepository {

    private UserJpaRepository repository;

    public UserRepositoryImpl(UserJpaRepository repository) { this.repository = repository; }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public User addNewUser(User user) {
        repository.save(user);
        return user;
    }

    @Override
    public User deleteUserBy(Long id) {
        User user = repository.findById(id).get();
        repository.delete(user);
        return user;
    }
}
