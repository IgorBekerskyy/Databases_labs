package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.GoodDAO;
import com.bekerskyy.model.Good;


import java.sql.SQLException;
import java.util.List;

public class GoodController implements GeneralController<Good> {

    private static final GoodDAO goods = new GoodDAO();

    public GoodController() {
    }

    @Override
    public List<Good> getAll() throws SQLException {
        return goods.getAll();
    }

    @Override
    public Good getById(int id) throws SQLException {
        return goods.getById(id);
    }

    @Override
    public void create(Good object) throws SQLException {
        goods.create(object);

    }

    @Override
    public void update(int id, Good object) {
        goods.update(id, object);
    }

    @Override
    public void delete(int id) {
        goods.delete(id);
    }
}
