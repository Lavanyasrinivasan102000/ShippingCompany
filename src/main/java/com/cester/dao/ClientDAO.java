package com.cester.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cester.model.Client;

public class ClientDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/shippingrecords";
    private final String jdbcUsername = "admin";
    private final String jdbcPassword = "admin";
    
    private static final String SELECT_ALL_CLIENTS = "SELECT * FROM clients";
    private static final String INSERT_CLIENT = "INSERT INTO clients (Name, Contact, ItemShipped, Date_Received, Date_Shipped) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_CLIENT = "UPDATE clients SET Name=?, Contact=?, ItemShipped=?, Date_Received=?, Date_Shipped=? WHERE ClientID=?";
    private static final String DELETE_CLIENT = "DELETE FROM clients WHERE ClientID=?";
    
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setClientID(rs.getInt("ClientID"));
                client.setName(rs.getString("Name"));
                client.setContact(rs.getString("Contact"));
                client.setItemShipped(rs.getString("ItemShipped"));
                client.setDateReceived(rs.getString("Date_Received"));
                client.setDateShipped(rs.getString("Date_Shipped"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void addClient(Client client) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getContact());
            preparedStatement.setString(3, client.getItemShipped());
            preparedStatement.setString(4, client.getDateReceived());
            preparedStatement.setString(5, client.getDateShipped());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(Client client) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getContact());
            preparedStatement.setString(3, client.getItemShipped());
            preparedStatement.setString(4, client.getDateReceived());
            preparedStatement.setString(5, client.getDateShipped());
            preparedStatement.setInt(6, client.getClientID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int clientID) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT)) {
            preparedStatement.setInt(1, clientID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
