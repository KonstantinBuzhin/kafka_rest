package com.company.dao;

import java.util.Collection;

public interface Dao<E> {

    Collection<E> getAll();

    E getById(Long id);

    E create(E entity);

    
    E update(E entity);

    void deleteById(Long id);
}
