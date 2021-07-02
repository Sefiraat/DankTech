package io.github.sefiraat.danktech;

import co.aikar.commands.PaperCommandManager;
import io.github.sefiraat.danktech.commands.Commands;
import io.github.sefiraat.danktech.configuration.Config;
import io.github.sefiraat.danktech.finals.Recipes;
import io.github.sefiraat.danktech.listeners.CraftListener;
import io.github.sefiraat.danktech.listeners.ItemPickupListener;
import io.github.sefiraat.danktech.listeners.ItemRightClickListener;
import io.github.sefiraat.danktech.listeners.UnloadingListener;
import io.github.sefiraat.danktech.misc.Protection;
import io.github.sefiraat.danktech.misc.SlimefunDankAddon;
import io.github.sefiraat.danktech.misc.SupportedPlugins;
import io.github.sefiraat.danktech.misc.Utils;
import io.github.sefiraat.danktech.timers.TimerHooks;
import io.github.sefiraat.danktech.timers.TimerSave;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;
import java.io.IOException;

public class DankTech extends JavaPlugin {

    private static DankTech instance;
    public static DankTech getInstance() {
        return instance;
    }

    private File dankStorageConfigFile;
    private FileConfiguration dankStorageConfig;
    private File itemBlacklistConfigFile;
    private FileConfiguration itemBlacklistConfig;
    private PaperCommandManager commandManager;
    private Protection protection;
    private Config configClass;
    private SupportedPlugins supportedPlugins;
    private SlimefunDankAddon slimefunAddon;

    private boolean isUnitTest = false;

    public File getItemBlacklistConfigFile() {
        return itemBlacklistConfigFile;
    }
    public FileConfiguration getItemBlacklistConfig() {
        return itemBlacklistConfig;
    }
    public File getDankStorageConfigFile() {
        return dankStorageConfigFile;
    }
    public FileConfiguration getDankStorageConfig() {
        return dankStorageConfig;
    }
    public PaperCommandManager getCommandManager() {
        return commandManager;
    }
    public Protection getProtection() {
        return protection;
    }
    public void setProtection(Protection protection) {
        this.protection = protection;
    }
    public Config getConfigClass() {
        return configClass;
    }
    public SupportedPlugins getSupportedPlugins() {
        return supportedPlugins;
    }
    public SlimefunDankAddon getSlimefunAddon() {
        return slimefunAddon;
    }
    public void setSlimefunAddon(SlimefunDankAddon slimefunAddon) {
        this.slimefunAddon = slimefunAddon;
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
        getLogger().info("                Dank Tech               ");
        getLogger().info("           Created by Sefiraat          ");
        getLogger().info("########################################");

        instance = this;

        sortConfigs();

        configClass = new Config();

        registerCommands();

        new ItemPickupListener(this);
        new ItemRightClickListener(this);
        new CraftListener(this);
        new UnloadingListener(this);

        addRecipes();

        TimerSave timerSave = new TimerSave(this);
        timerSave.runTaskTimerAsynchronously (this, 0, 1200L);

        this.getServer().getScheduler().runTask(this, this::afterStart);

        if (!isUnitTest) {
            int pluginId = 11208;
            Metrics metrics = new Metrics(this, pluginId);
            metrics.addCustomChart(new SimplePie("slimefun", () -> String.valueOf(getSupportedPlugins().isSlimefun())));
            metrics.addCustomChart(new SimplePie("worldguard", () -> String.valueOf(getSupportedPlugins().isWorldGuard())));
            metrics.addCustomChart(new SimplePie("factions", () -> String.valueOf(getSupportedPlugins().isFactions())));
            metrics.addCustomChart(new SimplePie("griefprotection", () -> String.valueOf(getSupportedPlugins().isGriefPrevention())));
            metrics.addCustomChart(new SimplePie("towny", () -> String.valueOf(getSupportedPlugins().isTowny())));
            metrics.addCustomChart(new SimplePie("mcmmo", () -> String.valueOf(getSupportedPlugins().isMcMMO())));
        }
    }

    @Override
    public void onDisable() {
        saveDankStorageConfig();
    }

    private void registerCommands() {
        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new Commands(this));
        Utils.dbgMsg("Commands registered");
    }

    private void sortConfigs() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        createDankStorageConfig();
        createItemBlacklistConfig();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
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

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void createItemBlacklistConfig() {
        itemBlacklistConfigFile = new File(getDataFolder(), "BlacklistedItems.yml");
        if (!itemBlacklistConfigFile.exists()) {
            itemBlacklistConfigFile.getParentFile().mkdirs();
            saveResource("BlacklistedItems.yml", false);
        }
        itemBlacklistConfig = new YamlConfiguration();
        try {
            itemBlacklistConfig.load(itemBlacklistConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveItemBlacklistConfig() {
        try {
            itemBlacklistConfig.save(itemBlacklistConfigFile);
        } catch (IOException e) {
            this.getLogger().warning("Unable to save " + itemBlacklistConfigFile.getName());
        }
    }

    private void addRecipes() {
        this.getServer().addRecipe(Recipes.recipeCell1());
        this.getServer().addRecipe(Recipes.recipeCell2());
        this.getServer().addRecipe(Recipes.recipeCell3());
        this.getServer().addRecipe(Recipes.recipeCell4());
        this.getServer().addRecipe(Recipes.recipeCell5());
        this.getServer().addRecipe(Recipes.recipeCell6());
        this.getServer().addRecipe(Recipes.recipeCell7());
        this.getServer().addRecipe(Recipes.recipeCell8());
        this.getServer().addRecipe(Recipes.recipeCell9());
        this.getServer().addRecipe(Recipes.recipeDank1());
        this.getServer().addRecipe(Recipes.recipeDank());
        this.getServer().addRecipe(Recipes.recipeTrash1());
        this.getServer().addRecipe(Recipes.recipeTrash());
    }

    public void afterStart() {
        this.supportedPlugins = new SupportedPlugins(this);
    }

}
