package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.CityDAO;
import com.bekerskyy.model.City;


import java.sql.SQLException;
import java.util.List;

public class CityController implements GeneralController<City> {

    private static final CityDAO cities = new CityDAO();

    public CityController() {
    }

    @Override
    public List<City> getAll() throws SQLException {
        return cities.getAll();
    }

    @Override
    public City getById(int id) throws SQLException {
        return cities.getById(id);
    }

    @Override
    public void create(City object) throws SQLException {
        cities.create(object);

    }

    @Override
    public void update(int id, City object) {
        cities.update(id, object);
    }

    @Override
    public void delete(int id) {
        cities.delete(id);
    }
}
