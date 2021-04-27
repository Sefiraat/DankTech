package io.github.sefiraat.danktech.timers;

import io.github.sefiraat.danktech.DankTech;

import java.io.IOException;
import java.util.TimerTask;

public class TimerSave extends TimerTask {

    public final DankTech Parent;

    public TimerSave(DankTech Parent) {
        this.Parent = Parent;
    }

    public void run() {
        try {
            Parent.getInstance().getDankStorageConfig().save(Parent.getDankStorageConfigFile());
        } catch (IOException e) {
            Parent.getLogger().warning("Unable to save " + Parent.getInstance().getDankStorageConfig().getName());
        }
    }
}