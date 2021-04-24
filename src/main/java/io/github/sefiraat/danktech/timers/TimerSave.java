package io.github.sefiraat.danktech.timers;

import io.github.sefiraat.danktech.DankTech;

import java.io.IOException;
import java.util.TimerTask;

public class TimerSave extends TimerTask {

    public DankTech Parent;

    public TimerSave(DankTech Parent) {
        this.Parent = Parent;
    }

    public void run() {
        try {
            Parent.getDankStorageConfig().save(Parent.getDankStorageConfigFile());
        } catch (IOException e) {
            Parent.getLogger().warning("Unable to save " + Parent.getDankStorageConfig().getName());
        }
        // Parent.getLogger().info("Void Stores Saving Data");
    }
}