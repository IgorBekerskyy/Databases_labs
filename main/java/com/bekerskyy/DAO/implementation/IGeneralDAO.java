package com.bekerskyy.DAO.implementation;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralDAO<T> {

    List<T> getAll() throws SQLException;

    T getById(int id) throws SQLException;

    void create(T entity) throws SQLException;

    void update(int id, T entity) throws SQLException;

    void delete(int id) throws SQLException;
}