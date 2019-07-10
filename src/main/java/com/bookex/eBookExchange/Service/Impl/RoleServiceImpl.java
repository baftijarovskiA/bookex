package com.bookex.eBookExchange.Service.Impl;

import com.bookex.eBookExchange.Model.Role;
import com.bookex.eBookExchange.Repository.Impl.RoleRepositoryImpl;
import com.bookex.eBookExchange.Service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepositoryImpl repository;

    public RoleServiceImpl(RoleRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> getAllRoles() {
        return repository.getAllRoles();
    }

    @Override
    public Role addNewRole(Role role) {
        return repository.addNewRole(role);
    }
}
