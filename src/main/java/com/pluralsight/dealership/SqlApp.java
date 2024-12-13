package com.pluralsight.dealership;

import java.sql.*;
import java.util.Scanner;

public class SqlApp {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/cardealership";
        String user = "Keely";
        String password = "yearup";
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Enter the type you are looking for: ");
             String carType = scanner.nextLine();

            try(Connection connection = DriverManager.getConnection(url, user, password)) {

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE car_type = ?;");
                preparedStatement.setString(1, carType);
                preparedStatement.executeQuery();

                ResultSet resultSet = preparedStatement.getResultSet();

                while (resultSet.next()){
                   String ct = resultSet.getString("car_type");
                    System.out.println(ct);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
