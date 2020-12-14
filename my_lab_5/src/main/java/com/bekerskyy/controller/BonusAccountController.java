package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.AbstractGenericDaoImpl;
import com.bekerskyy.DAO.implementation.BonusAccountDAO;
import com.bekerskyy.model.BonusAccount;


public class BonusAccountController
        extends AbstractGenericControllerImpl<BonusAccount> {

    private final BonusAccountDAO bonusAccountDAO = new BonusAccountDAO();

    @Override
    public AbstractGenericDaoImpl<BonusAccount> getDao() {
        return bonusAccountDAO;
    }


}
