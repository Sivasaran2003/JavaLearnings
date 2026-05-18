package lld.behaviouralPatterns.commandPatterns.receivers;

public class Tv implements Device{
    @Override
    public void turnOff() {
        System.out.println("Turning off TV");
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on TV");
    }
}
