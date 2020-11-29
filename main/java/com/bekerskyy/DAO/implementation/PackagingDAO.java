package com.bekerskyy.DAO.implementation;

import com.bekerskyy.DAO.implementation.IGeneralDAO;
import com.bekerskyy.model.Packaging;

import com.bekerskyy.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackagingDAO implements IGeneralDAO<Packaging> {

    public static final String Table = "my_lab444.packaging";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (name, for_a_gift) VALUES (?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET  name = ?, for_a_gift = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<Packaging> getAll() {
        List<Packaging> packagings = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Packaging Packaging = new Packaging(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("for_a_gift")

                );

                packagings.add(Packaging);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packagings;
    }

    @Override
    public Packaging getById(int id) {
        Packaging packaging = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                packaging = new Packaging(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("for_a_gift")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packaging;
    }

    @Override
    public void create(Packaging packaging) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, packaging.getName());
            statement.setBoolean(2, packaging.getFor_a_gift());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Packaging packaging) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, packaging.getName());
            statement.setBoolean(2, packaging.getFor_a_gift());
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
