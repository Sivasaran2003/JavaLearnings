package lld.creationalPatterns.factory.abstractFactory;

import lld.creationalPatterns.factory.factoryPattern.Notification;

public class Main {

    public static void main(String[] args) {
        // we need SMS notification so instead of passing arg,
        // we are directly using the 'type' factory method for that object
        NotificationFactory notificationFactory = new SmsNotificationFactory();
        Notification notification = notificationFactory.createNotification();
        notification.send("SMS notification - Abstract factory pattern");
    }
}

/**
 * Object creation is Centralized, Extendable, Decoupled
 *
 * factory pattern - if elif
 * factory method pattern - each subclass what object to create
 *
 * ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
 * Spring internally uses Factory pattern to create beans.
 */