package io.github.sefiraat.danktech.lib.misc;

import io.github.sefiraat.danktech.DankTech;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.DataStore;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Protection {

    private boolean griefPreventionExists;
    private GriefPrevention griefPrevention;
    private DankTech parent;

    public DankTech getParent() {
        return parent;
    }

    public boolean isGriefPreventionExists() {
        return griefPreventionExists;
    }

    public GriefPrevention getGriefPrevention() {
        return griefPrevention;
    }

    public Protection(DankTech parent) {
        this.parent = parent;
        griefPreventionExists = parent.getServer().getPluginManager().isPluginEnabled("GriefPrevention");
        if (griefPreventionExists) {
            griefPrevention = (GriefPrevention) parent.getServer().getPluginManager().getPlugin("GriefPrevention");
        }
    }

    public boolean canBuild(Block block, Player p) {

        boolean canBuild = true;

        if (griefPreventionExists) {
            DataStore d = griefPrevention.dataStore;
            Claim c = d.getClaimAt(block.getLocation(), true, null);
            if (c != null) {
                canBuild = c.allowBuild((Player) p, block.getType()) == null;
            }
        }

        return canBuild;
    }

}
