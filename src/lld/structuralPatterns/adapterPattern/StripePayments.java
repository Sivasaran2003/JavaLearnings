package lld.structuralPatterns.adapterPattern;

public class StripePayments {
    public void processPayment(int amount) {
        // payment logic
        System.out.println("your stripe payment is successful");
    }
}

// third party sdk 2 -> which is different from our system