package lld.structuralPatterns.decoratorPattern;

public class EmailNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("Sending Email : " + message);
    }
}

/**
 * now requirements grow
 * email + sms
 * sms + whatsapp
 * email + whatsapp
 * email + whatsapp + sms
 * ..
 * ...
 *
 * to avoid this decorator pattern is used - wrapping / attaching behavior to an object
 */