package com.company.service;

import com.company.model.User;

import java.util.Collection;

public interface UserService extends Service<User> {

    Collection<User> getAllActive();

    User register(User user);

    User findByUsername(String username);
}
