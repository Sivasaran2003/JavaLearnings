package lld.structuralPatterns.adapterPattern;

public class PaypalPaymentAdapter implements PaymentProcessor {
    private final PayPalPayment paypalProcessor;
    // object / composition based adapter (having third party sdk object inside adapter)
    // another method is to inherit third party class and implement our system's interface
    public PaypalPaymentAdapter(PayPalPayment paypalProcessor) {
        this.paypalProcessor = paypalProcessor;
    }

    @Override
    public void makePayment(int amount) {
        paypalProcessor.pay(amount);
    }
}
