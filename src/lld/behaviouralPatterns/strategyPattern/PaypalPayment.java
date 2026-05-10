package lld.behaviouralPatterns.strategyPattern;

public class PaypalPayment implements PaymentStrategy {

    @Override
    public void makePayment() {
        System.out.println("Making payment using Paypal");
    }
}
