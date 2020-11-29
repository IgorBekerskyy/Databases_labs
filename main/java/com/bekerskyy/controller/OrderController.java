package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.OrderDAO;
import com.bekerskyy.model.Order;


import java.sql.SQLException;
import java.util.List;

public class OrderController implements GeneralController<Order> {

    private static final OrderDAO orders = new OrderDAO();

    public OrderController() {
    }

    @Override
    public List<Order> getAll() throws SQLException {
        return orders.getAll();
    }

    @Override
    public Order getById(int id) throws SQLException {
        return orders.getById(id);
    }

    @Override
    public void create(Order object) throws SQLException {
        orders.create(object);

    }

    @Override
    public void update(int id, Order object) {
        orders.update(id, object);
    }

    @Override
    public void delete(int id) {
        orders.delete(id);
    }
}

