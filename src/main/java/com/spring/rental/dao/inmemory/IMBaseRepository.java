package com.spring.rental.dao.inmemory;

import com.spring.rental.dao.BaseRepository;
import com.spring.rental.domain.AbstractModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class IMBaseRepository<T extends AbstractModel> implements BaseRepository<T> {

    private Map<Long, T> models = new HashMap<Long, T>();

    private static AtomicLong ID = new AtomicLong(System.currentTimeMillis());

    @Override
    public Collection<T> getAll() {

        return models.values();
    }

    @Override
    public T findById(Long id) {

        return models.get(id);
    }

    @Override
    public T update(T model) {
        if (model.getId() <= 0) {
            model.setId(ID.getAndIncrement());
        }

        models.put(model.getId(), model);
        return model;
    }

    @Override
    public boolean delete(T model) {
        boolean result = models.containsKey(model.getId());

        if (result)
            models.remove(model.getId());
        return result;
    }
}
