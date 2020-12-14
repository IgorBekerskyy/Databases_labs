package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.AbstractGenericDaoImpl;
import com.bekerskyy.DAO.implementation.SalonDAO;
import com.bekerskyy.model.Salon;


public class SalonController
        extends AbstractGenericControllerImpl<Salon> {

    private final SalonDAO salonDAO = new SalonDAO();

    @Override
    public AbstractGenericDaoImpl<Salon> getDao() {
        return salonDAO;
    }


}
