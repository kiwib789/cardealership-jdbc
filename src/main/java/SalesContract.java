public class SalesContract extends Contract {
    private static final double SalesTaxRate = 0.05;
    private static final double RecordingFee = 100;
    private static final double ProcessingFeeUnder50000 = 295;
    private static final double ProcessingFeeAbove50000 = 495;

    private String financingOption;
    private double salesTaxAmount;
    private double processingFee;
    private double totalPrice;
    private double monthlyPayment;

    // Constructor
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, String financingOption) {
        super(date, customerName, customerEmail, vehicleSold);
        this.financingOption = financingOption;
        this.salesTaxAmount = calculateSalesTax();
        this.processingFee = calculateProcessingFee();
        this.totalPrice = calculateTotalPrice();
        this.monthlyPayment = calculateMonthlyPayment();
    }



    private double calculateSalesTax() {
        return getVehicleSold().getPrice() * SalesTaxRate;
    }



    private double calculateProcessingFee() {
        if (getVehicleSold().getPrice() < 50000) {
            return ProcessingFeeUnder50000;
        } else {
            return ProcessingFeeAbove50000;
        }
    }



    private double calculateTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + RecordingFee + processingFee;
    }



    private double calculateMonthlyPayment() {
        if ("YES".equalsIgnoreCase(financingOption)) {
            double interestRate = getVehicleSold().getPrice() >= 10000 ? 0.0425 : 0.0525;
            int months = getVehicleSold().getPrice() >= 10000 ? 48 : 24;
            return (totalPrice * interestRate / months);
        }

        return 0.0;
    }



    // Getters
    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getRecordingFee() {
        return RecordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }
    public boolean isFinanced() {
        return "YES".equalsIgnoreCase(financingOption);
    }


    @Override
    public double getTotalPrice() {
        return totalPrice;
    }


    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
}
