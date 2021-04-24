package io.github.sefiraat.danktech;

import io.github.sefiraat.danktech.implimentation.items.ItemDank;
import io.github.sefiraat.danktech.listeners.ItemPickupListener;
import org.bukkit.plugin.java.JavaPlugin;

public class DankTech extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().info("########################################");
        getLogger().info("");
        getLogger().info("                Dank Tech               ");
        getLogger().info("            Version 1.0.0.R1            ");
        getLogger().info("");
        getLogger().info("          Created by Sefiraat           ");
        getLogger().info("");
        getLogger().info("########################################");



        new ItemPickupListener(this);

    }

    @Override
    public void onDisable() {

    }

}
