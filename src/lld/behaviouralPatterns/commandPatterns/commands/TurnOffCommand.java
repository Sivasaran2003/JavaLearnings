package lld.behaviouralPatterns.commandPatterns.commands;

import lld.behaviouralPatterns.commandPatterns.receivers.Tv;

public class TurnOffCommand implements Command{
    Tv tv;

    public TurnOffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}
