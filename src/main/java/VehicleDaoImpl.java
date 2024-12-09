
import config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDaoImpl implements VehicleDao {

    private final String url;
    private final String usr;
    private final String password;

    public VehicleDaoImpl(String url, String usr, String password) {
        this.url = url;
        this.usr = usr;
        this.password = password;
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM Vehicles";

        try (Connection connection = DatabaseConfig.getConnection(url,usr,password);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                vehicles.add(createVehicleFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) {

        return null;
    }

    @Override
    public List<Vehicle> findVehicleByMakeModel(String make, String model) {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehicleByPrice(double minPrice, double maxPrice) {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehicleByYear(int year) {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehicleByColor(String color) {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehicleByMileage(int mileage) {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehicleByType(String type) {
        return List.of();
    }

    @Override
    public void removeVehicle(int vin) {

    }

    @Override
    public void addVehicle(Vehicle vehicle) {

    }
}
