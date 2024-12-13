package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.config.DatabaseConfig;
import com.pluralsight.dealership.Dealership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealershipDaoImpl implements DealershipDao {
    private final String url;
    private final String user;
    private final String password;

    public DealershipDaoImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Dealership> findAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();
        String query = "SELECT * FROM Dealerships";
        int id;
        String name;
        String address;
        String phone;

        try (Connection connection = DatabaseConfig.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                id = resultSet.getInt("Id");
                name = resultSet.getString("Name");
                address = resultSet.getString("Address");
                phone = resultSet.getString("Phone number");
                Dealership dealership = new Dealership(id, name, address,phone);


                        dealerships.add(dealership);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dealerships;
    }

    @Override
    public List<Dealership> findDealershipById() {
        return List.of();
    }
}

