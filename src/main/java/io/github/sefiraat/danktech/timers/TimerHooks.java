package io.github.sefiraat.danktech.timers;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerHooks extends BukkitRunnable {

    public final DankTech parent;

    public TimerHooks(DankTech parent) {
        this.parent = parent;
    }


    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }
}