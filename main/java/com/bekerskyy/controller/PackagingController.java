package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.PackagingDAO;
import com.bekerskyy.model.Packaging;


import java.sql.SQLException;
import java.util.List;

public class PackagingController implements GeneralController<Packaging> {

    private static final PackagingDAO packagings = new PackagingDAO();

    public PackagingController() {
    }

    @Override
    public List<Packaging> getAll() throws SQLException {
        return packagings.getAll();
    }

    @Override
    public Packaging getById(int id) throws SQLException {
        return packagings.getById(id);
    }

    @Override
    public void create(Packaging object) throws SQLException {
        packagings.create(object);

    }

    @Override
    public void update(int id,Packaging object) {
        packagings.update(id, object);
    }

    @Override
    public void delete(int id) {
        packagings.delete(id);
    }
}
