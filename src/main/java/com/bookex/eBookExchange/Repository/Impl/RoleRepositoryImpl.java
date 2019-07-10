package com.bookex.eBookExchange.Repository.Impl;

import com.bookex.eBookExchange.Model.Role;
import com.bookex.eBookExchange.Repository.JpaRepository.RoleJpaRepository;
import com.bookex.eBookExchange.Repository.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private RoleJpaRepository repository;

    public RoleRepositoryImpl(RoleJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public Role addNewRole(Role role) {
        return repository.save(role);
    }
}
