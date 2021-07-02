package io.github.sefiraat.danktech.misc;

import io.github.sefiraat.danktech.DankTech;

public class SupportedPlugins {

    private final DankTech plugin;

    private final boolean mcMMO;
    public boolean isMcMMO() {
        return mcMMO;
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

    private final boolean slimefun;
    public boolean isSlimefun() {
        return slimefun;
    }

    private final boolean wildStacker;
    public boolean isWildStacker() {
        return wildStacker;
    }

    public SupportedPlugins(DankTech plugin) {
        this.plugin = plugin;
        Utils.dbgMsg("Setting up post-load supported plugins");
        mcMMO = plugin.getServer().getPluginManager().getPlugin("mcMMO") != null;
        Utils.dbgMsg("-- mcMMO : " + mcMMO);
        griefPrevention =  plugin.getServer().getPluginManager().isPluginEnabled("GriefPrevention");
        Utils.dbgMsg("-- griefPrevention : " + griefPrevention);
        worldGuard = plugin.getServer().getPluginManager().getPlugin("WorldGuard") != null;
        Utils.dbgMsg("-- worldGuard : " + worldGuard);
        towny = plugin.getServer().getPluginManager().getPlugin("Towny") != null;
        Utils.dbgMsg("-- towny : " + towny);
        factions = plugin.getServer().getPluginManager().getPlugin("Factions") != null;
        Utils.dbgMsg("-- factions : " + factions);
        wildStacker = plugin.getServer().getPluginManager().getPlugin("WildStacker") != null;
        Utils.dbgMsg("-- wildStacker : " + wildStacker);
        slimefun = plugin.getServer().getPluginManager().getPlugin("Slimefun") != null;
        Utils.dbgMsg("-- slimefun : " + slimefun);

        if (isSlimefun()) {
            Utils.dbgMsg("Starting Slimefun Integration");
            DankTech.getInstance().setSlimefunAddon(new SlimefunDankAddon());
        } else {
            Utils.dbgMsg("Skipping Slimefun Integration");
        }

        plugin.setProtection(new Protection(this));
    }


}
