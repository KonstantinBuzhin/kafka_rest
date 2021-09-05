package com.company.dao;

import com.company.config.TestConfig;
import com.company.exceptions.DaoException;
import com.company.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringJUnitConfig(TestConfig.class)
@Transactional
public class UserDaoHibernateTest {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private UserDaoHibernate userDao;

    private Session session;

    @BeforeEach
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }

//    @Test
//    public void shouldReturnCorrectUsers() {
//        Collection<User> actual = userDao.getAll();
//
//        List<User> expected = session.createQuery("SELECT u FROM User u", User.class).getResultList();
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnCorrectUser() {
//        User actual = userDao.getById(1);
//
//        User expected = session.load(User.class, 1);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldThrowExceptionWhenFindUserByNonExistentId() {
//        assertThrows(DaoException.class, () -> userDao.getById(0));
//    }
//
//    @Test
//    public void shouldCreateUser() {
//        User user = new User("name");
//
//        userDao.create(user);
//
//        assertEquals(user, session.load(User.class, user.getId()));
//    }
//
//    @Test
//    public void shouldUpdateUser() {
//        User expected = new User(1L, "name");
//
//        userDao.update(expected);
//
//        assertEquals(expected, session.load(User.class, expected.getId()));
//    }
//
//    @Test
//    public void shouldDeleteUser() {
//        userDao.deleteById(1);
//
//        assertNull(session.get(User.class, 1));
//    }
}
