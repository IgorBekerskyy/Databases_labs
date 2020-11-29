package com.bekerskyy.DAO.implementation;

import com.bekerskyy.DAO.implementation.IGeneralDAO;
import com.bekerskyy.model.BonusAccount;
import com.bekerskyy.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BonusAccountDAO implements IGeneralDAO<BonusAccount> {

    public static final String Table = "my_lab444.bonus_account";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (type, promocode) VALUES (?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET type = ?,  promocode = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<BonusAccount> getAll() {
        List<BonusAccount> bonusAccounts = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BonusAccount BonusAccount = new BonusAccount(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("promocode")

                );

                bonusAccounts.add(BonusAccount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bonusAccounts;
    }

    @Override
    public BonusAccount getById(int id) {
       BonusAccount bonusAccount = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bonusAccount = new BonusAccount(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("promocode")


                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bonusAccount;
    }

    @Override
    public void create(BonusAccount bonusAccount) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, bonusAccount.getType());
            statement.setString(2, bonusAccount.getPromocode());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, BonusAccount bonusAccount) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, bonusAccount.getType());
            statement.setString(2, bonusAccount.getPromocode());
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

