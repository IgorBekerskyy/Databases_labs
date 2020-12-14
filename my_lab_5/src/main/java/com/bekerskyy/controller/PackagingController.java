package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.AbstractGenericDaoImpl;
import com.bekerskyy.DAO.implementation.PackagingDAO;
import com.bekerskyy.model.Packaging;


public class PackagingController
        extends AbstractGenericControllerImpl<Packaging> {

    private final PackagingDAO packagingDAO = new PackagingDAO();

    @Override
    public AbstractGenericDaoImpl<Packaging> getDao() {
        return packagingDAO;
    }


}
