package com.bekerskyy.DAO.implementation;

import com.bekerskyy.DAO.implementation.IGeneralDAO;
import com.bekerskyy.model.City;

import com.bekerskyy.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements IGeneralDAO<City> {

    public static final String Table = "my_lab444.city";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (name, region_name) VALUES (?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET  name = ?, region_name = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<City> getAll() {
        List<City> cities = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                City City = new City(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("region_name")

                );

                cities.add(City);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public City getById(int id) {
        City city = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                city = new City(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("region_name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void create(City city) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, city.getName());
            statement.setString(2, city.getRegion_name());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, City city) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, city.getName());
            statement.setString(2, city.getRegion_name());
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