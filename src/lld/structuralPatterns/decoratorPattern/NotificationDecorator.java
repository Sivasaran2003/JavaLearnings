package lld.structuralPatterns.decoratorPattern;

public class NotificationDecorator implements Notifier{

    Notifier notifier;
    public NotificationDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}
