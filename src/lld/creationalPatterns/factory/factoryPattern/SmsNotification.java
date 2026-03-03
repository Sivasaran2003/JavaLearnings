package lld.creationalPatterns.factory.factoryPattern;

public class SmsNotification implements Notification{

    @Override
    public void send(String message) {
        System.out.println("Sending SMS : " + message);
    }
}
