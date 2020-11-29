package com.bekerskyy.controller;


import com.bekerskyy.DAO.implementation.SalonDAO;
import com.bekerskyy.model.Salon;

import java.sql.SQLException;
import java.util.List;

public class SalonController implements GeneralController<Salon> {

    private static final SalonDAO salons = new SalonDAO();
    public SalonController() {
    }

    @Override
    public List<Salon> getAll() throws SQLException {
        return salons.getAll();
    }

    @Override
    public Salon getById(int id) throws SQLException {
        return salons.getById(id);
    }

    @Override
    public void create(Salon object) throws SQLException {
        salons.create(object);

    }

    @Override
    public void update(int id, Salon object) {
        salons.update(id, object);
    }

    @Override
    public void delete(int id) {
        salons.delete(id);
    }
}
