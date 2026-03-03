package lld.creationalPatterns.factory.abstractFactory;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email : " + message);
    }
}
