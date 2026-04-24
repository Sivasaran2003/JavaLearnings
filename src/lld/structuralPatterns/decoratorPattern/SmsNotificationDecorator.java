package lld.structuralPatterns.decoratorPattern;

class SmsNotificationDecorator extends NotificationDecorator {

    public SmsNotificationDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("SMS sent: " + message);
    }
}
