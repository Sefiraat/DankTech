package io.github.sefiraat.danktech;

import co.aikar.commands.PaperCommandManager;
import io.github.sefiraat.danktech.commands.Commands;
import io.github.sefiraat.danktech.listeners.ItemPickupListener;
import io.github.sefiraat.danktech.listeners.ItemRightClickListener;
import io.github.sefiraat.danktech.timers.TimerSave;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class DankTech extends JavaPlugin {

    private DankTech instance;
    private File DankStorageConfigFile;
    private FileConfiguration DankStorageConfig;
    private PaperCommandManager CommandManager;
    private Timer Repeater = new Timer();

    public File getDankStorageConfigFile() {
        return DankStorageConfigFile;
    }

    public FileConfiguration getDankStorageConfig() {
        return DankStorageConfig;
    }

    public PaperCommandManager getCommandManager() {
        return CommandManager;
    }

    public DankTech getInstance() {
        return instance;
    }

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

        instance = this;

        saveDefaultConfig();
        createDankStorageConfig();
        registerCommands();

        new ItemPickupListener(this.getInstance());
        new ItemRightClickListener(this.getInstance());

        Repeater.schedule(new TimerSave(this.getInstance()),0, 30000);

    }

    @Override
    public void onDisable() {
        saveDankStorageConfig();
    }

    private void registerCommands() {
        CommandManager = new PaperCommandManager(this.getInstance());
        CommandManager.registerCommand(new Commands(this.getInstance()));
    }

    private void createDankStorageConfig() {
        DankStorageConfigFile = new File(getDataFolder(), "DankStorages.yml");
        if (!DankStorageConfigFile.exists()) {
            DankStorageConfigFile.getParentFile().mkdirs();
            saveResource("DankStorages.yml", false);
        }

        DankStorageConfig = new YamlConfiguration();
        try {
            DankStorageConfig.load(DankStorageConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveDankStorageConfig() {
        try {
            DankStorageConfig.save(DankStorageConfigFile);
        } catch (IOException e) {
            this.getLogger().warning("Unable to save " + DankStorageConfigFile.getName());
        }
    }

}
