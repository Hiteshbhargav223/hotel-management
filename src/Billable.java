public interface Billable {
    double TAX_RATE = 0.12;

    double calculateSubtotal();
    double calculateTax();
    double calculateFinalBill();
    String generateReceipt();
}
