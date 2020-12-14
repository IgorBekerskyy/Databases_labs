package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.AbstractGenericDaoImpl;

import java.util.List;

public abstract class AbstractGenericControllerImpl<E>
        implements AbstractGenericController<E> {

    public abstract AbstractGenericDaoImpl<E> getDao();

    @Override
    public List<E> getAll() {
        return (List<E>) getDao().findAll();
    }

    @Override
    public E getById(Integer id) {
        return getDao().findOne(id);
    }

    @Override
    public void create(E object) {
        getDao().create(object);
    }

    @Override
    public void update(Integer id, E object) {
        getDao().update(id, object);
    }

    @Override
    public void delete(Integer id) {
        getDao().delete(id);
    }

}

