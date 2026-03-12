package lld.structuralPatterns.adapterPattern;

public class PayPalPayment {
    public void pay(int amount) {
        // payment logic
        System.out.println("your paypal payment is successful");
    }
}

// third party sdk 1 -> which is different from our system