package com.company.service;

import com.company.dao.UserDao;
import com.company.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserDao userDao;
    @InjectMocks
    private UserServiceImpl userService;

//    @Test
//    public void shouldReturnCorrectUsers() {
//        Collection<User> expected = new ArrayList<>();
//        expected.add(new User(1, "name1"));
//        expected.add(new User(2, "name2"));
//
//        when(userDao.getAll()).thenReturn(expected);
//
//        assertEquals(expected, userService.getAll());
//    }
//
//    @Test
//    public void shouldReturnCorrectUser() {
//        User expected = new User(1, "name1");
//
//        when(userDao.getById(1)).thenReturn(expected);
//
//        assertEquals(expected, userService.getById(1));
//    }
//
//    @Test
//    public void shouldCreateUser() {
//        User user = new User("name");
//
//        userService.create(user);
//
//        verify(userDao).create(user);
//    }
//
//    @Test
//    public void shouldUpdateUser() {
//        User user = new User(1, "name");
//
//        userService.update(user);
//
//        verify(userDao).update(user);
//    }
//
//    @Test
//    public void shouldDeleteUser() {
//        userService.deleteById(1);
//
//        verify(userDao).deleteById(1);
//    }
}
