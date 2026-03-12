package lld.structuralPatterns.adapterPattern;

public class StripePaymentAdapter implements PaymentProcessor{
    private final StripePayments stripeProcessor;

    // object / composition based adapter (having third party sdk object inside adapter)
    public StripePaymentAdapter(StripePayments stripeProcessor) {
        this.stripeProcessor = stripeProcessor;
    }

    @Override
    public void makePayment(int amount) {
        stripeProcessor.processPayment(amount);
    }
}
