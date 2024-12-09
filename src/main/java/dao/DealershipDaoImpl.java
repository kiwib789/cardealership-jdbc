package dao;

import com.pluralsight.car.dealership.Dealership;
import config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealershipDaoImpl implements DealershipDao{
    private final String url;
    private final String user;
    private final String password;

    public DealershipDaoImpl(String url, String usr, String password) {
        this.url = url;
        this.user = usr;
        this.password = password;
    }

    @Override
    public List<Dealership> findAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();
        String query = "SELECT * FROM Dealerships";

        try (Connection connection = DatabaseConfig.getConnection(url, user,password);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Dealership dealership = new Dealership(
                        resultSet.getString("Name"),
                        resultSet.getString("Address"),
                        resultSet.getString("Phone number"),
                        resultSet.ge
                );
                dealerships.add(dealership);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dealerships;
    }
    }
}
