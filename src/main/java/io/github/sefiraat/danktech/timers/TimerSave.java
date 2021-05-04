package io.github.sefiraat.danktech.timers;

import io.github.sefiraat.danktech.DankTech;

import java.io.IOException;
import java.util.TimerTask;

public class TimerSave extends TimerTask {

    public final DankTech parent;

    public TimerSave(DankTech parent) {
        this.parent = parent;
    }

    public void run() {
        try {
            parent.getInstance().getDankStorageConfig().save(parent.getDankStorageConfigFile());
        } catch (IOException e) {
            parent.getLogger().warning("Unable to save " + parent.getInstance().getDankStorageConfig().getName());
        }
    }
}