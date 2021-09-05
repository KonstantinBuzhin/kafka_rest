package com.company.dao;

import com.company.model.User;

import java.util.Collection;

public interface UserDao extends Dao<User> {

    Collection<User> getAllActive();

    
    User findByUsername(String username);
}
