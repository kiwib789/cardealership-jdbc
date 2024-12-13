package com.pluralsight.dealership;

import com.pluralsight.dealership.config.DatabaseConfig;
import com.pluralsight.dealership.dao.SalesContractDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesContractImpl implements SalesContractDao {

    @Override
    public List<SalesContract> findAllSalesContracts() {
        List<SalesContract> salesContracts = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement();
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String field1 = resultSet.getString("field1");
                String field2 = resultSet.getString("field2");

                SalesContract salesContract = new SalesContract(id, field1, field2);
                salesContracts.add(salesContract);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Add proper logging here
        }
     return salesContracts;
    }


    @Override
    public SalesContract findSalesContractById(int id) {
        SalesContract salesContract = null;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement()) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salesContract;
    }


    @Override
    public void addSalesContract(SalesContract salesContract) {

    }

    @Override
    public void updateSalesContract(SalesContract salesContract) {

    }

    @Override
    public void deleteSalesContract(int id) {

    }
}

