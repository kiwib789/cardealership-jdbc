package com.pluralsight.dealership;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String type;
    private String color;
    private int odometer;
    private double price;


    public Vehicle(int vin, int year, String make, String model, String type, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getType(){
        return type;
    }


    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }


    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {

        return String.format("Vehicle{vin: %-10s, year: %-4d, make: %-10s, model: %-10s, vehicleType: %-10s, color: %-10s, odometer: %-10.2f, price: $%.2f}",
                vin, year, make, model, color, odometer, price);
    }
}