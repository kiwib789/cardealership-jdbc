package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.Vehicle;

import java.util.List;

public interface VehicleDao {
    List<Vehicle> findAllVehicles();
    List<Vehicle> findVehicleByMakeModel(String make, String model);
    List<Vehicle> findVehicleByPrice(double minPrice, double maxPrice);
    List<Vehicle> findVehicleByYear(int year);
    List<Vehicle> findVehicleByColor(String color);
    List<Vehicle> findVehicleByMileage(int mileage);
    List<Vehicle> findVehicleByType(String type);
    void addVehicle(Vehicle vehicle);
    void removeVehicle(int vin);
}
