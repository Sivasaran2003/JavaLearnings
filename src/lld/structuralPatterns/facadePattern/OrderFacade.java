package lld.structuralPatterns.facadePattern;

class OrderFacade {

    private final AuthService authService = new AuthService();
    private final InventoryService inventoryService = new InventoryService();
    private final PaymentService paymentService = new PaymentService();
    private final NotificationService notificationService = new NotificationService();

    public void placeOrder(String user, String item, double amount) {

        authService.authenticate(user);
        inventoryService.checkStock(item);
        paymentService.processPayment(user, amount);
        notificationService.sendConfirmation(user);

        System.out.println("Order placed successfully!");
    }
}

// used to make an API simple and hide the workflow
/**
 * ✔ Simplifies complex systems
 * ✔ Reduces coupling
 * ✔ Hides internal details
 * ✔ Improves readability
 */