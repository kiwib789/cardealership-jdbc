import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    private static final String filePath = "src/main/resources/inventory.csv";

    static Dealership getDealership(String file) {
        Dealership dealership = null;
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 8) {
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    vehicles.add(vehicle);
                }
            }
            dealership = new Dealership("Dealership Name", "Address", "Phone", vehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dealership;
    }

    public static void saveDealership(Dealership dealership) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String line = String.join("|",
                        String.valueOf(vehicle.getVin()),
                        String.valueOf(vehicle.getYear()),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        String.valueOf(vehicle.getOdometer()),
                        String.valueOf(vehicle.getPrice()));
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
