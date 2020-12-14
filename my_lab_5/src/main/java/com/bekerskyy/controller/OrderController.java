package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.AbstractGenericDaoImpl;
import com.bekerskyy.DAO.implementation.OrderDAO;
import com.bekerskyy.model.Order;


public class OrderController
        extends AbstractGenericControllerImpl<Order> {

    private final OrderDAO orderDAO = new OrderDAO();

    @Override
    public AbstractGenericDaoImpl<Order> getDao() {
        return orderDAO;
    }


}
