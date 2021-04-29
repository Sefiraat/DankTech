package io.github.sefiraat.danktech.lib.misc;

import com.sun.org.apache.bcel.internal.util.BCELifier;
import io.github.sefiraat.danktech.DankTech;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.DataStore;
import me.ryanhamshire.GriefPrevention.GriefPrevention;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.internal.platform.WorldGuardPlatform;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Set;

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

        boolean canBuild = true;
        Location blockLocation = block.getLocation();

        if (griefPreventionExists) {
            DataStore d = griefPrevention.dataStore;
            Claim c = d.getClaimAt(blockLocation, true, null);
            if (c != null) {
                canBuild = c.allowBuild((Player) p, block.getType()) == null;
            }
        }

        if (worldGuardExists) {

            WorldGuardPlatform platform = WorldGuard.getInstance().getPlatform();
            RegionContainer container = platform.getRegionContainer();

            com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(blockLocation);
            com.sk89q.worldedit.world.World world = BukkitAdapter.adapt(blockLocation.getWorld());
            LocalPlayer player = worldGuard.wrapOfflinePlayer(p);

            Set<ProtectedRegion> regions = container.get(world).getApplicableRegions(BlockVector3.at(blockLocation.getX(), blockLocation.getY(), blockLocation.getZ())).getRegions();

            if (!regions.isEmpty()) {
                canBuild = container.createQuery().testState(loc, player, Flags.BLOCK_PLACE);
            }
        }

        return canBuild;
    }

}
