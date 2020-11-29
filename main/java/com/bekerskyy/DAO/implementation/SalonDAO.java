package com.bekerskyy.DAO.implementation;

import com.bekerskyy.DAO.implementation.IGeneralDAO;
import com.bekerskyy.model.Salon;

import com.bekerskyy.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalonDAO implements IGeneralDAO <Salon> {

    public static final String Table = "my_lab444.salon";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (name, phone, salon_head, city_id, street_adress) VALUES (?,?,?,?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET  name = ?, phone = ?, salon_head=? , city_id=?, street_adress=? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<Salon> getAll() {
        List<Salon> salons = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Salon Salon = new Salon(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("salon_head"),
                        resultSet.getString("city_id"),
                        resultSet.getString("street_adress")


                );

                salons.add(Salon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salons;
    }

    @Override
    public Salon getById(int id) {
        Salon salon = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                salon = new Salon(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("salon_head"),
                        resultSet.getString("city_id"),
                        resultSet.getString("street_adress")


                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salon;
    }

    @Override
    public void create(Salon salon) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, salon.getName());
            statement.setString(2, salon.getPhone());
            statement.setString(3, salon.getSalon_head());
            statement.setString(4, salon.getCity_id());
            statement.setString(5, salon.getStreet_adress());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Salon salon) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, salon.getName());
            statement.setString(2, salon.getPhone());
            statement.setString(3, salon.getSalon_head());
            statement.setString(4, salon.getCity_id());
            statement.setString(5, salon.getStreet_adress());
            statement.setInt(6, id);
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
