public class Contract {
    private String dateOfContract;
    private String customerName;
    private String customerEmail;
    private int contractId;
    private int customerId;
    private Vehicle vehicle;
    private double totalPrice;
    public double monthlyPayment;
    private Vehicle vehicleSold;

    public Contract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.contractId = contractId;
        this.customerId = customerId;
        this.vehicle = vehicle;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
        this.vehicleSold = vehicleSold;
    }



    public String getDateOfContract() {
        return dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getContractId() {
        return contractId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }
    public Vehicle getVehicleSold(){
        return vehicleSold;
    }
}
