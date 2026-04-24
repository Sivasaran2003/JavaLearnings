package lld.structuralPatterns.facadePattern;

class PaymentService {
    public void processPayment(String user, double amount) {
        System.out.println("Payment processed: " + amount);
    }
}
