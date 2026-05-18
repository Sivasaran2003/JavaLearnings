package lld.behaviouralPatterns.commandPatterns.commands;

import lld.behaviouralPatterns.commandPatterns.receivers.Stereo;

public class VolumeDownCommand implements Command{
    Stereo stereo;

    public VolumeDownCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.volumeDown();
    }
}
