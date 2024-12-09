
import config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static config.DatabaseConfig.dataSource;

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
        return List.of(); ArrayList<Vehicle> vehicleByMake = new ArrayList<>();
        int vin;
        int year;
        String model;
        String make;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE make = ?;
                    """);

            statement.setString(1, make);
            ResultSet results = statement.executeQuery();

            while (results.next()){
                vin = results.getInt("vin");
                year = results.getInt("year");
                make = results.getString("make");
                model = results.getString("model");
                vehicleType = results.getString("type");
                color = results.getString("color");
                odometer = results.getInt("odometer");
                price = results.getDouble("price");
                sold = results.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicleByMake.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByMake;
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
