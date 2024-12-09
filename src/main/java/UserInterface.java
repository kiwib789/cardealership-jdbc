import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager;
    private Scanner scanner;


    // gets information from cvs file
    public UserInterface() {
        this.fileManager = new DealershipFileManager();
        this.scanner = new Scanner(System.in);
        this.dealership = DealershipFileManager.getDealership("src/main/resources/inventory.csv");
    }


    // displays main menu
    public void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("""
                     Welcome Keely's Dealership
                    
                     1. Vehicles by Price
                     2. Vehicles by Make and Model
                     3. Vehicles by Year
                     4. Vehicles by Color
                     5. Vehicles by Mileage
                     6. Vehicles by Type
                     7. All Vehicles
                     8. Add a Vehicle
                     9. Remove a Vehicle
                     10. Record a sale
                     11. Record a lease
                     0. Exit
                    """);

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 0 -> {
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void processGetAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        vehicleList(allVehicles);
    }


    // adds vehicles to car dealership
    private void processAddVehicleRequest() {
        System.out.print("Enter VIN: "); // vin
        int vin = scanner.nextInt();

        System.out.print("Enter Make: ");  // make
        String make = scanner.nextLine();

        System.out.print("Enter Year: ");  // year
        int year = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Model: "); // model
        String model = scanner.nextLine();

        System.out.print("Enter vehicle type: "); // model
        String vehicleType = scanner.nextLine();

        System.out.print("Enter Color: ");  // color
        String color = scanner.nextLine();

        System.out.print("Enter Mileage: ");  // mileage
        int odometer = scanner.nextInt();

        System.out.print("Enter price: ");  // mileage
        double price = scanner.nextDouble();

        boolean isSold = false;

        // Create new Vehicle
        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);

        // Add vehicle to dealership inventory
        dealership.addVehicle(newVehicle);

        System.out.println("Vehicle has been added.");
    }


    // removes vehicles from car dealership
    private void processRemoveVehicleRequest() {
        System.out.print("Enter VIN to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle removedVehicle = findVehicleByVin(vin);
        if (removedVehicle != null) {
            dealership.removeVehicle(removedVehicle);
            System.out.println("Vehicle has been removed.");
        } else {
            System.out.println("Vehicle could not be found! Please enter correct VIN.");
        }

    }

    private Vehicle findVehicleByVin(int vin) {
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                return v;
            }
        }
        return null;
    }


    // lists all vehicles
    private void vehicleList(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicle found");
            return;
        }
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }


    // gets vehicle type by user input
    private void processGetByVehicleTypeRequest() {
        System.out.println("Vehicle type:");
        String type = scanner.nextLine();
        dealership.getVehiclesByType(type);

    }


    // gets mileage by user input
    private void processGetByMileageRequest() {
        System.out.println("Enter the minimum: ");
        double minMileage = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter maximum: ");
        double maxMileage = Double.parseDouble(scanner.nextLine());
        dealership.getVehiclesByMileage(minMileage, maxMileage);

    }


    // gets color by user input
    private void processGetByColorRequest() {
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        dealership.getVehiclesByColor(color);

    }


    // gets year by user input
    private void processGetByYearRequest() {
        System.out.println("Enter the minimum: ");
        int minYear = scanner.nextInt();
        System.out.println("Enter maximum: ");
        int maxYear = scanner.nextInt();
        dealership.getVehiclesByYear(minYear, maxYear);

    }


    // gets make and model by user input
    private void processGetByMakeModelRequest() {
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        dealership.getVehiclesByMakeModel(make, model);

    }


    // gets price by user input
    private void processGetByPriceRequest() {
        System.out.println("Enter the minimum: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter maximum: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());
        dealership.getVehicleByPrice(minPrice, maxPrice);

    }
}
