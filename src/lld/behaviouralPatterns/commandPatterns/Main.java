package lld.behaviouralPatterns.commandPatterns;

import lld.behaviouralPatterns.commandPatterns.commands.*;
import lld.behaviouralPatterns.commandPatterns.receivers.Stereo;
import lld.behaviouralPatterns.commandPatterns.receivers.Tv;

public class Main {
    static void main() {
        // Create receivers
        Tv tv = new Tv();
        Stereo stereo = new Stereo();

        // Create commands
        Command turnOnTV = new TurnOnCommand(tv);
        Command turnOffTV = new TurnOffCommand(tv);
        Command volumeUp = new VolumeUpCommand(stereo);
        Command volumeDown = new VolumeDownCommand(stereo);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Execute commands
        remote.setCommand(turnOnTV);
        remote.pressButton();

        remote.setCommand(volumeUp);
        remote.pressButton();

        remote.setCommand(volumeDown);
        remote.pressButton();

        remote.setCommand(turnOffTV);
        remote.pressButton();
    }
}
/**
 * The Command Design Pattern is a behavioral design pattern that encapsulates a request as an object,
 * thereby decoupling the sender of the request from the receiver and allowing flexible execution of operations.
 */