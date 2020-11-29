package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.ClientDAO;
import com.bekerskyy.model.Client;


import java.sql.SQLException;
import java.util.List;

public class ClientController implements GeneralController<Client> {

    private static final ClientDAO clients = new ClientDAO();

    public ClientController() {
    }

    @Override
    public List<Client> getAll() throws SQLException {
        return clients.getAll();
    }

    @Override
    public Client getById(int id) throws SQLException {
        return clients.getById(id);
    }

    @Override
    public void create(Client object) throws SQLException {
        clients.create(object);

    }

    @Override
    public void update(int id, Client object) {
        clients.update(id, object);
    }

    @Override
    public void delete(int id) {
        clients.delete(id);
    }
}

