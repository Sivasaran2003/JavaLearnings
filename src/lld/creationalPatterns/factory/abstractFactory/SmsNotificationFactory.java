package lld.creationalPatterns.factory.abstractFactory;

import lld.creationalPatterns.factory.factoryPattern.Notification;
import lld.creationalPatterns.factory.factoryPattern.SmsNotification;

public class SmsNotificationFactory extends NotificationFactory{

    @Override
    Notification createNotification() {
        return new SmsNotification();
    }
}
