package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.AbstractGenericDaoImpl;
import com.bekerskyy.DAO.implementation.CityDAO;
import com.bekerskyy.model.City;


public class CityController
        extends AbstractGenericControllerImpl<City> {

    private final CityDAO cityDAO = new CityDAO();

    @Override
    public AbstractGenericDaoImpl<City> getDao() {
        return cityDAO;
    }


}