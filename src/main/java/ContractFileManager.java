import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private final String contractFilePath = "src/main/resources/contracts.csv";


    public void saveContract(Contract contract) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contractFilePath, true))) {
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;

                String data = String.format("SALE|Date: %s|Customer name: %s|Customer email: %s|VIN: %d|Year: %d|Make: %s|Model: %s|Type: %s|Color: %s|Price: %.2f|Monthly payment: %.2f|Taxes: %.2f|Recording fee: %.2f|Processing fee: %.2f|Financed: %s",
                        salesContract.getDateOfContract(),
                        salesContract.getCustomerName(),
                        salesContract.getCustomerEmail(),
                        salesContract.getVehicle().getVin(),
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
                        salesContract.isFinanced() ? "yes" : "no");



                writer.write(data);
                writer.newLine();
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;


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


                writer.write(data);
                writer.newLine();
            }
        }
    }
}
