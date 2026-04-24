package lld.structuralPatterns.facadePattern;

class NotificationService {
    public void sendConfirmation(String user) {
        System.out.println("Notification sent to: " + user);
    }
}
