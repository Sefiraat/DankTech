package io.github.sefiraat.danktech;

import co.aikar.commands.PaperCommandManager;
import io.github.sefiraat.danktech.commands.Commands;
import io.github.sefiraat.danktech.finals.Recipes;
import io.github.sefiraat.danktech.lib.misc.Protection;
import io.github.sefiraat.danktech.listeners.CraftListener;
import io.github.sefiraat.danktech.listeners.ItemPickupListener;
import io.github.sefiraat.danktech.listeners.ItemRightClickListener;
import io.github.sefiraat.danktech.listeners.UnloadingListener;
import io.github.sefiraat.danktech.timers.TimerSave;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bstats.bukkit.Metrics;

import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class DankTech extends JavaPlugin {

    private DankTech instance;
    private File dankStorageConfigFile;
    private FileConfiguration dankStorageConfig;
    private PaperCommandManager commandManager;
    private final Timer repeater = new Timer();
    private Protection protection;
    private boolean isUnitTest = false;

    public File getDankStorageConfigFile() {
        return dankStorageConfigFile;
    }
    public FileConfiguration getDankStorageConfig() {
        return dankStorageConfig;
    }
    public PaperCommandManager getCommandManager() {
        return commandManager;
    }
    public DankTech getInstance() {
        return instance;
    }
    public Protection getProtection() {
        return protection;
    }

    public DankTech() {
        super();
    }

    protected DankTech(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
        isUnitTest = true;
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

        protection = new Protection(this);

        new ItemPickupListener(this.getInstance());
        new ItemRightClickListener(this.getInstance());
        new CraftListener(this.getInstance());
        new UnloadingListener(this.getInstance());

        addRecipes();

        repeater.schedule(new TimerSave(this.getInstance()),0, 30000);

        if (!isUnitTest) {
            int pluginId = 11208;
            Metrics metrics = new Metrics(this, pluginId);
        }

    }

    @Override
    public void onDisable() {
        saveDankStorageConfig();
    }

    private void registerCommands() {
        commandManager = new PaperCommandManager(this.getInstance());
        commandManager.registerCommand(new Commands(this.getInstance()));
    }

    private void createDankStorageConfig() {
        dankStorageConfigFile = new File(getDataFolder(), "DankStorages.yml");
        if (!dankStorageConfigFile.exists()) {
            dankStorageConfigFile.getParentFile().mkdirs();
            saveResource("DankStorages.yml", false);
        }
        dankStorageConfig = new YamlConfiguration();
        try {
            dankStorageConfig.load(dankStorageConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveDankStorageConfig() {
        try {
            dankStorageConfig.save(dankStorageConfigFile);
        } catch (IOException e) {
            this.getLogger().warning("Unable to save " + dankStorageConfigFile.getName());
        }
    }

    public void addRecipes() {
        this.getServer().addRecipe(Recipes.recipeCell1(this));
        this.getServer().addRecipe(Recipes.recipeCell2(this));
        this.getServer().addRecipe(Recipes.recipeCell3(this));
        this.getServer().addRecipe(Recipes.recipeCell4(this));
        this.getServer().addRecipe(Recipes.recipeCell5(this));
        this.getServer().addRecipe(Recipes.recipeCell6(this));
        this.getServer().addRecipe(Recipes.recipeCell7(this));
        this.getServer().addRecipe(Recipes.recipeCell8(this));
        this.getServer().addRecipe(Recipes.recipeCell9(this));
        this.getServer().addRecipe(Recipes.recipeDank1(this));
        this.getServer().addRecipe(Recipes.recipeDank2(this));
        this.getServer().addRecipe(Recipes.recipeDank3(this));
        this.getServer().addRecipe(Recipes.recipeDank4(this));
        this.getServer().addRecipe(Recipes.recipeDank5(this));
        this.getServer().addRecipe(Recipes.recipeDank6(this));
        this.getServer().addRecipe(Recipes.recipeDank7(this));
        this.getServer().addRecipe(Recipes.recipeDank8(this));
        this.getServer().addRecipe(Recipes.recipeDank9(this));
    }

}
