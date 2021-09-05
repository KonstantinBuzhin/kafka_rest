package com.company.dao;

import com.company.exceptions.DaoException;
import com.company.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.Collection;

@Slf4j
@Repository("UserDaoHibernate")
public class UserDaoHibernate implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Collection<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public Collection<User> getAllActive() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT u FROM User u WHERE u.status = 'ACTIVE'", User.class).getResultList();
    }

    @Override
    public User getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        if (user == null) {
            throw new DaoException("Can't find user by passed id: %d", id);
        }
        log.debug("Get user by id: {}", id);
        return user;
    }

    @Override
    public User create(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(user);
        } catch (ConstraintViolationException e) {
            throw new DaoException("Unique index or primary key violation", e);
        }
        log.debug("Create user: {}", user);
        return user;
    }

    @Override
    public User update(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(user);
        } catch (PersistenceException e) {
            throw new DaoException("Unique index or primary key violation", e);
        }
        log.debug("Update user: {}", user);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (user != null) {
            session.delete(user);
        }
        log.debug("Delete user: {}", user);
    }

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username).getSingleResult();
    }
}
