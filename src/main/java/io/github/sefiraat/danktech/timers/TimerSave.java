package io.github.sefiraat.danktech.timers;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerSave extends BukkitRunnable {

    public final DankTech parent;

    public TimerSave(DankTech parent) {
        this.parent = parent;
    }

    public void run() {
        parent.saveDankStorageConfig();
        parent.saveItemBlacklistConfig();
    }
}