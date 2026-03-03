package lld.creationalPatterns.factory.abstractFactory;

import lld.creationalPatterns.factory.factoryPattern.EmailNotification;
import lld.creationalPatterns.factory.factoryPattern.Notification;

public class EmailNotificationFactory extends NotificationFactory{
    @Override
    Notification createNotification() {
        return new EmailNotification();
    }
}
