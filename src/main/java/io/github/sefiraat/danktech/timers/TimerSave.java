package io.github.sefiraat.danktech.timers;

import io.github.sefiraat.danktech.DankTech;

import java.util.TimerTask;

public class TimerSave extends TimerTask {

    public final DankTech parent;

    public TimerSave(DankTech parent) {
        this.parent = parent;
    }

    public void run() {
        parent.saveDankStorageConfig();
        parent.saveItemBlacklistConfig();
    }
}