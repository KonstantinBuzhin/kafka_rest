package com.company.dao;

import com.company.exceptions.DaoException;
import com.company.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.Collection;

@Slf4j
@Repository("RoleDaoHibernate")
public class RoleDaoHibernate implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Collection<Role> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Override
    public Role getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.get(Role.class, id);
        if (role == null) {
            throw new DaoException("Can't find role by passed id: %d", id);
        }
        log.debug("Get role by id: {}", id);
        return role;
    }

    @Override
    public Role create(Role entity) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(entity);
        } catch (ConstraintViolationException e) {
            throw new DaoException("Unique index or primary key violation", e);
        }
        log.debug("Create role: {}", entity);
        return entity;
    }

    @Override
    public Role update(Role entity) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(entity);
        } catch (PersistenceException e) {
            throw new DaoException("Unique index or primary key violation", e);
        }
        log.debug("Update role: {}", entity);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.load(Role.class, id);
        if (role != null) {
            session.delete(role);
        }
        log.debug("Delete role: {}", role);
    }

    @Override
    public Role findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class)
                .setParameter("name", name).getSingleResult();
    }
}
