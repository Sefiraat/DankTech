package io.github.sefiraat.danktech.misc;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.internal.platform.WorldGuardPlatform;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import io.github.sefiraat.danktech.DankTech;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.DataStore;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Protection {

    private DankTech parent;

    private boolean griefPreventionExists;
    private GriefPrevention griefPrevention;
    private boolean worldGuardExists;
    private WorldGuardPlugin worldGuard;


    public DankTech getParent() {
        return parent;
    }

    public boolean isGriefPreventionExists() {
        return griefPreventionExists;
    }
    public GriefPrevention getGriefPrevention() {
        return griefPrevention;
    }
    public boolean isWorldGuardExists() {
        return worldGuardExists;
    }
    public WorldGuardPlugin getWorldGuard() {
        return worldGuard;
    }

    public Protection(DankTech parent) {
        this.parent = parent;
        griefPreventionExists = parent.getServer().getPluginManager().isPluginEnabled("GriefPrevention");
        if (griefPreventionExists) {
            griefPrevention = (GriefPrevention) parent.getServer().getPluginManager().getPlugin("GriefPrevention");
        }
        worldGuardExists = parent.getServer().getPluginManager().isPluginEnabled("WorldGuard");
        if (worldGuardExists) {
            worldGuard = (WorldGuardPlugin) parent.getServer().getPluginManager().getPlugin("WorldGuard");
        }
    }

    public boolean canBuild(Block block, Player p) {

        ArrayList<Boolean> canBuildChecks = new ArrayList<>();
        Location blockLocation = block.getLocation();

        if (griefPreventionExists) {
            DataStore d = griefPrevention.dataStore;
            Claim c = d.getClaimAt(blockLocation, true, null);
            if (c != null) {
                canBuildChecks.add(c.allowBuild(p, block.getType()) == null);
            }
        }

        if (worldGuardExists) {
            WorldGuardPlatform platform = WorldGuard.getInstance().getPlatform();
            com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(blockLocation);
            LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(p);
            RegionContainer container = platform.getRegionContainer();
            RegionQuery query = container.createQuery();

            if (!query.testState(loc, localPlayer, Flags.BUILD)) {
                canBuildChecks.add(false);
            }
        }
        return !canBuildChecks.contains(false);
    }

}