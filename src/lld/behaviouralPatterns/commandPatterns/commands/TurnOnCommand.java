package lld.behaviouralPatterns.commandPatterns.commands;

import lld.behaviouralPatterns.commandPatterns.receivers.Tv;

public class TurnOnCommand implements Command{
    Tv tv;

    public TurnOnCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}
