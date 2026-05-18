package lld.behaviouralPatterns.commandPatterns;

import lld.behaviouralPatterns.commandPatterns.commands.Command;

public class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if(command != null) {
            this.command.execute();
        }
    }
}
