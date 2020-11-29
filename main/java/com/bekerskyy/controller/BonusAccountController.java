package com.bekerskyy.controller;

import com.bekerskyy.DAO.implementation.BonusAccountDAO;
import com.bekerskyy.model.BonusAccount;


import java.sql.SQLException;
import java.util.List;

public class BonusAccountController implements GeneralController<BonusAccount> {

    private static final BonusAccountDAO bonusAccounts = new BonusAccountDAO();

    public BonusAccountController() {
    }

    @Override
    public List<BonusAccount> getAll() throws SQLException {
        return bonusAccounts.getAll();
    }

    @Override
    public BonusAccount getById(int id) throws SQLException {
        return bonusAccounts.getById(id);
    }

    @Override
    public void create(BonusAccount object) throws SQLException {
        bonusAccounts.create(object);

    }

    @Override
    public void update(int id, BonusAccount object) {
        bonusAccounts.update(id, object);
    }

    @Override
    public void delete(int id) {
        bonusAccounts.delete(id);
    }
}

