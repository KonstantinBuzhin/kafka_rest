package com.company.dao;

import com.company.model.Role;

public interface RoleDao extends Dao<Role> {

    Role findByName(String name);
}
