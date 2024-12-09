import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    private final String contractsFilePath = "src/main/resources/contracts.csv"; // File path to store contracts

    public void saveContract(Contract contract) throws IOException {
        // BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contractsFilePath, true))) {
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract; // Cast to SalesContract
                // Format
                String data = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                        salesContract.getDateOfContract(),
                        salesContract.getCustomerName(),
                        salesContract.getCustomerEmail(),
                        salesContract.getVehicleSold().getVin(),
                        salesContract.getVehicleSold().getYear(),
                        salesContract.getVehicleSold().getMake(),
                        salesContract.getVehicleSold().getModel(),
                        salesContract.getVehicleSold().getVehicleType(),
                        salesContract.getVehicleSold().getColor(),
                        salesContract.getTotalPrice(),
                        salesContract.getMonthlyPayment(),
                        salesContract.getSalesTaxAmount(),
                        salesContract.getRecordingFee(),
                        salesContract.getProcessingFee(),
                        salesContract.isFinanced() ? "YES" : "NO");


                // Writes data to the file
                writer.write(data);
                writer.newLine();
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract; // Cast to LeaseContract


                // Format
                String data = String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%.2f|%.2f",
                        leaseContract.getDateOfContract(),
                        leaseContract.getCustomerName(),
                        leaseContract.getCustomerEmail(),
                        leaseContract.getVehicleSold().getVin(),
                        leaseContract.getVehicleSold().getYear(),
                        leaseContract.getVehicleSold().getMake(),
                        leaseContract.getVehicleSold().getModel(),
                        leaseContract.getVehicleSold().getVehicleType(),
                        leaseContract.getVehicleSold().getColor(),
                        leaseContract.getTotalPrice(),
                        leaseContract.getMonthlyPayment());

                // Writes data to the file
                writer.write(data);
                writer.newLine();
            }
        }
    }
}
