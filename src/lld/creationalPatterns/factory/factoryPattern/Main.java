package lld.creationalPatterns.factory.factoryPattern;

public class Main {

    public static void main(String[] args) {

        Notification notification =
                NotificationFactory.getNotification("EMAIL");

        notification.send("Factory Pattern");
    }
}

/**
 * Object creation is Centralized, Extendable, Decoupled
 *
 * factory pattern - if elif
 * factory method pattern - each subclass what object to create
 *
 */