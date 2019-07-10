package com.bookex.eBookExchange.Repository;

import com.bookex.eBookExchange.Model.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> getAllRoles();

    Role addNewRole(Role role);
}
