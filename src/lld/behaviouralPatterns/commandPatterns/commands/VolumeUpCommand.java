package lld.behaviouralPatterns.commandPatterns.commands;

import lld.behaviouralPatterns.commandPatterns.receivers.Stereo;

public class VolumeUpCommand implements Command{
    Stereo stereo;

    public VolumeUpCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.volumeUp();
    }
}
