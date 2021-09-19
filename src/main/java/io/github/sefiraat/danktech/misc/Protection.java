package io.github.sefiraat.danktech.misc;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.palmergames.bukkit.towny.object.TownyPermission;
import com.palmergames.bukkit.towny.utils.PlayerCacheUtil;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.internal.platform.WorldGuardPlatform;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.DataStore;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Protection {

    private final SupportedPlugins supportedPlugins;

    private GriefPrevention griefPrevention;
    private WorldGuardPlugin worldGuard;
    private FPlayers factions;

    public Protection(SupportedPlugins supportedPlugins) {
        this.supportedPlugins = supportedPlugins;
        Utils.dbgMsg("Protection plugins sorted");
    }

    public boolean canBuild(Block block, Player p) {
        ArrayList<Boolean> canBuildChecks = new ArrayList<>();

        canBuildChecks.add(canBuildGriefPrevention(block, p));
        canBuildChecks.add(canBuildWorldGuard(block, p));
        canBuildChecks.add(canBuildTowny(block, p));
        canBuildChecks.add(canBuildFactions(block, p));

        return !canBuildChecks.contains(false);
    }

    public boolean canBuildGriefPrevention(Block block, Player p) {
        if (supportedPlugins.isGriefPrevention()) {
            DataStore d = GriefPrevention.instance.dataStore;
            Claim c = d.getClaimAt(block.getLocation(), true, null);
            if (c != null) {
                return c.allowBuild(p, block.getType()) == null;
            }
        }
        return true;
    }

    public boolean canBuildWorldGuard(Block block, Player p) {
        if (supportedPlugins.isWorldGuard()) {
            WorldGuardPlatform platform = WorldGuard.getInstance().getPlatform();
            com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(block.getLocation());
            LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(p);
            RegionContainer container = platform.getRegionContainer();
            RegionQuery query = container.createQuery();
            return query.testState(loc, localPlayer, Flags.BUILD);
        }
        return true;
    }

    public boolean canBuildTowny(Block block, Player p) {
        if (supportedPlugins.isTowny()) {
            return PlayerCacheUtil.getCachePermission(p, block.getLocation(), block.getType(), TownyPermission.ActionType.BUILD);
        }
        return true;
    }

    public boolean canBuildFactions(Block block, Player p) {
        if (supportedPlugins.isFactions()) {
            Faction faction = Board.getInstance().getFactionAt(new FLocation(block.getLocation()));

            if (faction != null && !faction.getId().equals("0")) {
                return faction.getId().equals(factions.getByOfflinePlayer(p).getFaction().getId());
            }
        }
        return true;
    }

}
