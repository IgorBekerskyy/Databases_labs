package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.AbstractGenericDaoImpl;
import com.bekerskyy.DAO.implementation.GoodDAO;
import com.bekerskyy.model.Good;


public class GoodController
        extends AbstractGenericControllerImpl<Good> {

    private final GoodDAO goodDAO = new GoodDAO();

    @Override
    public AbstractGenericDaoImpl<Good> getDao() {
        return goodDAO;
    }


}
