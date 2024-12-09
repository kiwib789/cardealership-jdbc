import java.util.ArrayList;

public class Dealership {
    private final int Id;
    private final String name;
    private final String address;
    private final String phone;
    private ArrayList<Vehicle> inventory; // No longer static


    // Constructor


    public Dealership(int id, String name, String address, String phone) {
        this.Id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;

        this.inventory = new ArrayList<>();
    }

    // Get vehicles by price range
    public void getVehicleByPrice(double min, double max) {
        boolean found = false;
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                System.out.println(v);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found in this price range.");
        }
    }

    // Get vehicles by make and model
    public void getVehiclesByMakeModel(String make, String model) {
        boolean found = false;
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                System.out.println(v);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found with the make and model.");
        }
    }

    // Get vehicles by year range
    public void getVehiclesByYear(int min, int max) {
        boolean found = false;
        for (Vehicle v : inventory) {
            int year = v.getYear();
            if (year >= min && year <= max) {
                System.out.println(v);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found in this year range.");
        }
    }

    // Get vehicles by color
    public void getVehiclesByColor(String color) {
        boolean found = false;
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)) {
                System.out.println(v);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found with this color.");
        }
    }

    // Get vehicles by mileage range
    public void getVehiclesByMileage(double min, double max) {
        boolean found = false;
        for (Vehicle v : inventory) {
            double mileage = v.getOdometer();
            if (mileage >= min && mileage <= max) {
                System.out.println(v);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found in this mileage range.");
        }
    }

    // Get vehicles by type
    public void getVehiclesByType(String type) {
        boolean found = false;
        for (Vehicle v : inventory) {
            if (v.getVehicleType().equalsIgnoreCase(type)) {
                System.out.println(v);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found with this type.");
        }
    }

    // Get all vehicles in the inventory
    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    // Remove a vehicle from the inventory
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    // Add a vehicle to the inventory and save
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
}
