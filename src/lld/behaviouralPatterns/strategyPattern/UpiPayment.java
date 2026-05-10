package lld.behaviouralPatterns.strategyPattern;

public class UpiPayment implements PaymentStrategy {
    @Override
    public void makePayment() {
        System.out.println("Making payment using UPI");
    }
}
