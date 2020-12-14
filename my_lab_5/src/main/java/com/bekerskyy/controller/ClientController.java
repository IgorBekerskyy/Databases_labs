package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.AbstractGenericDaoImpl;
import com.bekerskyy.DAO.implementation.ClientDAO;
import com.bekerskyy.model.Client;


public class ClientController
        extends AbstractGenericControllerImpl<Client> {

    private final ClientDAO clientDAO = new ClientDAO();

    @Override
    public AbstractGenericDaoImpl<Client> getDao() {
        return clientDAO;
    }


}
