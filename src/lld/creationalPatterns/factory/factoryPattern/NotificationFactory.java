package lld.creationalPatterns.factory.factoryPattern;

public class NotificationFactory {
    public static Notification getNotification(String type) {
        return switch (type) {
            case "EMAIL" -> new EmailNotification();
            case "SMS" -> new SmsNotification();
            default -> throw new IllegalArgumentException("invalid notification type");
        };
    }
}
