package com.company.service;

import java.util.Collection;

public interface Service<E> {

    Collection<E> getAll();

    E getById(Long id);

    E update(E entity);

    void deleteById(Long id);
}
