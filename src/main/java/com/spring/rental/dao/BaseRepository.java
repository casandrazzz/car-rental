package com.spring.rental.dao;

import com.spring.rental.domain.AbstractModel;

import java.util.Collection;

public interface BaseRepository<T extends AbstractModel> {

    Collection<T> getAll();

    T findById(Long id);

    T update(T model);

    boolean delete(T model);
}