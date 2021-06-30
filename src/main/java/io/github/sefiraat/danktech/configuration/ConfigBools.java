package io.github.sefiraat.danktech.configuration;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigBools {

    private final boolean debug;

    public boolean isDebug() {
        return debug;
    }

    public ConfigBools() {

        FileConfiguration c = DankTech.getInstance().getConfig();

        debug = c.getBoolean("GENERAL.DEBUG");

    }

}
