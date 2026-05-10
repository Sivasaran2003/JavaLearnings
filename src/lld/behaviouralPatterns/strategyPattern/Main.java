package lld.behaviouralPatterns.strategyPattern;

public class Main {
    static void main() {
        PaymentStrategy paymentStrategy = new UpiPayment();
        new PaymentContext(paymentStrategy).makePayment();
    }
}

/**
 * Encapsulates different algorithms into separate strategy classes, allowing dynamic selection or switching at runtime.
 * Promotes flexibility by reducing complex conditional logic and making code easier to maintain
 *
 * Advantages
 * This pattern improves flexibility and maintainability by separating behavior from the main logic.
 *
 * Promotes open/closed principle by allowing new strategies to be added easily
 * Makes code cleaner and easier to maintain
 * Enables runtime behavior changes without code modification
 * Disadvantages
 * While flexible, the pattern can introduce extra complexity.
 *
 * Increases the number of classes in the system
 * Clients must be aware of different strategies
 * May add slight overhead due to additional object creation
 */