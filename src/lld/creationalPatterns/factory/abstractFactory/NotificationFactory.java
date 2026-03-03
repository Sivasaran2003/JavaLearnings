package lld.creationalPatterns.factory.abstractFactory;

import lld.creationalPatterns.factory.factoryPattern.Notification;

public abstract class NotificationFactory {
    abstract Notification createNotification();

//    public void sendNotification(String message) {
//        Notification notification = createNotification();
//        notification.send(message);
//    }
//  --factory method pattern--
// useful when processing pipeline is needed
//    ex:
//    public void processPayment() {
//        validate();
//        Payment payment = createPayment();
//        payment.pay();
//        log();
//    }

}
