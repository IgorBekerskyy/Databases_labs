package com.bekerskyy.DAO.implementation;

import com.bekerskyy.DAO.implementation.IGeneralDAO;
import com.bekerskyy.model.Order;
import com.bekerskyy.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IGeneralDAO<Order> {

    public static final String Table = "my_lab444.order";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (client_id, salon_id, packaging_id, delivery_in_days, good_id) VALUES (?,?,?,?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET client_id = ?,  salon_id = ?, packaging_id = ?, delivery_in_days = ?, good_id = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Order Order = new Order(
                        resultSet.getInt("id"),
                        resultSet.getString("client_id"),
                        resultSet.getString("salon_id"),
                        resultSet.getString("packaging_id"),
                        resultSet.getString("delivery_in_days"),
                        resultSet.getString("good_id")

                );

               orders.add(Order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order getById(int id) {
        Order order = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order = new Order(
                        resultSet.getInt("id"),
                        resultSet.getString("client_id"),
                        resultSet.getString("salon_id"),
                        resultSet.getString("packaging_id"),
                        resultSet.getString("delivery_in_days"),
                        resultSet.getString("good_id")

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void create(Order order) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, order.getClient_id());
            statement.setString(2, order.getSalon_id());
            statement.setString(3, order.getPackaging_id());
            statement.setString(4, order.getDelivery_in_days());
            statement.setString(5, order.getGood_id());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Order order) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, order.getClient_id());
            statement.setString(2, order.getSalon_id());
            statement.setString(3, order.getPackaging_id());
            statement.setString(4, order.getDelivery_in_days());
            statement.setString(5, order.getGood_id());
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

