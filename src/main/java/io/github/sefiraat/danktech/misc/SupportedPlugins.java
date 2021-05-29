package io.github.sefiraat.danktech.misc;

import io.github.sefiraat.danktech.DankTech;

public class SupportedPlugins {

    private final DankTech plugin;

    private final boolean mcMMO;
    public boolean isMcMMO() {
        return mcMMO;
    }

    private final boolean slimefun;
    public boolean isSlimefun() {
        return slimefun;
    }

    private final boolean griefPrevention;
    public boolean isGriefPrevention() {
        return griefPrevention;
    }

    private final boolean worldGuard;
    public boolean isWorldGuard() {
        return worldGuard;
    }

    private final boolean towny;
    public boolean isTowny() {
        return towny;
    }

    private final boolean factions;
    public boolean isFactions() {
        return factions;
    }

    private final boolean wildStacker;
    public boolean isWildStacker() {
        return wildStacker;
    }

    public SupportedPlugins(DankTech plugin) {

        this.plugin = plugin;

        mcMMO = plugin.getServer().getPluginManager().isPluginEnabled("mcMMO");
        slimefun = plugin.getServer().getPluginManager().isPluginEnabled("Slimefun");
        griefPrevention = plugin.getServer().getPluginManager().isPluginEnabled("GriefPrevention");
        worldGuard = plugin.getServer().getPluginManager().isPluginEnabled("WorldGuard");
        towny = plugin.getServer().getPluginManager().isPluginEnabled("Towny");
        factions = plugin.getServer().getPluginManager().isPluginEnabled("Factions");
        wildStacker = plugin.getServer().getPluginManager().isPluginEnabled("WildStacker");

    }

}
