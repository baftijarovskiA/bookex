package com.bookex.eBookExchange.Service;

import com.bookex.eBookExchange.Model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role addNewRole(Role role);

}
