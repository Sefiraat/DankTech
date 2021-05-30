package io.github.sefiraat.danktech.timers;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerHooks extends BukkitRunnable {

    public final DankTech parent;

    public TimerHooks(DankTech parent) {
        this.parent = parent;
    }

    public void run() {
        parent.getSupportedPlugins().setupPostLoadPlugins();
        this.cancel();
    }
}