package com.bekerskyy.DAO.implementation;

import com.bekerskyy.DAO.implementation.IGeneralDAO;
import com.bekerskyy.model.Client;
import com.bekerskyy.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements IGeneralDAO<Client> {

    public static final String Table = "my_lab444.client";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (surname, name , birthday, gender, adresse, native_language , zip_code, phone, email, bonus_account_id) VALUES (?,?,?,?,?,?,?,?,?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET surname = ?,  name = ?, birthday = ?, gender = ? adresse = ?, native_language = ?, zip_code = ?, phone = ?, email = ?, bonus_account_id= ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Client Client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("birthday"),
                        resultSet.getString("gender"),
                        resultSet.getString("adresse"),
                        resultSet.getString("native_language"),
                        resultSet.getString("zip_code"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("bonus_account_id")

                );

                clients.add(Client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client getById(int id) {
        Client client = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("birthday"),
                        resultSet.getString("gender"),
                        resultSet.getString("adresse"),
                        resultSet.getString("native_language"),
                        resultSet.getString("zip_code"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("bonus_account_id")

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void create(Client client) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, client.getSurname());
            statement.setString(2, client.getName());
            statement.setString(3, client.getBirthday());
            statement.setString(4, client.getGender());
            statement.setString(5, client.getAdresse());
            statement.setString(6, client.getNative_language());
            statement.setString(7, client.getZip_code());
            statement.setString(8, client.getPhone());
            statement.setString(9, client.getEmail());
            statement.setString(10, client.getBonus_account_id());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Client client) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, client.getSurname());
            statement.setString(2, client.getName());
            statement.setString(3, client.getBirthday());
            statement.setString(4, client.getGender());
            statement.setString(5, client.getAdresse());
            statement.setString(6, client.getNative_language());
            statement.setString(7, client.getZip_code());
            statement.setString(8, client.getPhone());
            statement.setString(9, client.getEmail());
            statement.setString(10, client.getBonus_account_id());
            statement.setInt(11, id);
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

