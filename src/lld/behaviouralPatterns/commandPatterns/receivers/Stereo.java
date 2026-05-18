package lld.behaviouralPatterns.commandPatterns.receivers;

public class Stereo implements Device {
    @Override
    public void turnOff() {
        System.out.println("Turning off Stereo");
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on Stereo");
    }

    public void volumeUp() {
        System.out.println("Turning volume up");
    }

    public void volumeDown() {
        System.out.println("Turning volume down");
    }
}
