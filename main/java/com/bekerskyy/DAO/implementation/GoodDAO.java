package com.bekerskyy.DAO.implementation;

import com.bekerskyy.DAO.implementation.IGeneralDAO;
import com.bekerskyy.model.Good;
import com.bekerskyy.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDAO implements IGeneralDAO<Good> {

    public static final String Table = "my_lab444.good";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (name, firm, description, guarantee_in_months, response,in_stock) VALUES (?,?,?,?,?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET name = ?,  firm = ?, description = ?, guarantee_in_months  = ?,response = ?,  in_stock = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<Good> getAll() {
        List<Good> goods = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
               Good Good = new Good(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("firm"),
                        resultSet.getString("description"),
                        resultSet.getString("guarantee_in_months"),
                       resultSet.getString("response"),
                       resultSet.getBoolean("in_stock")

                );

                goods.add(Good);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public Good getById(int id) {
        Good good = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                good = new Good(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("firm"),
                        resultSet.getString("description"),
                        resultSet.getString("guarantee_in_months"),
                        resultSet.getString("response"),
                        resultSet.getBoolean("in_stock")

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return good;
    }

    @Override
    public void create(Good good) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, good.getName());
            statement.setString(2, good.getFirm());
            statement.setString(3, good.getDescription());
            statement.setString(4, good.getGuarantee_in_months());
            statement.setString(5, good.getResponse());
            statement.setBoolean(6, good.getIn_Stock());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Good good) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, good.getName());
            statement.setString(2, good.getFirm());
            statement.setString(3, good.getDescription());
            statement.setString(4, good.getGuarantee_in_months());
            statement.setString(5, good.getResponse());
            statement.setBoolean(6, good.getIn_Stock());
            statement.setInt(7, id);
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

