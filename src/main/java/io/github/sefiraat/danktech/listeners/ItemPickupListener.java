package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

import static io.github.sefiraat.danktech.finals.ItemDetails.getLimit;
import static io.github.sefiraat.danktech.lib.misc.Utils.*;

public class ItemPickupListener implements Listener {

    DankTech Parent;

    public ItemPickupListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        Parent = plugin;
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(hasDank(p)) {
                List<ItemStack> Danks = getDanks(p);
                for (ItemStack Dank : Danks) {
                    long dankID = getDankId(Dank, Parent);
                    int dankLevel = getDankLevel(Dank, Parent);
                    ConfigurationSection section = Parent.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + dankID);
                    for (int i = 1; i <= dankLevel; i++) {
                        ItemStack PickedStack = e.getItem().getItemStack();
                        ConfigurationSection slotSection = section.getConfigurationSection("SLOT" + i);
                        if (slotSection.getItemStack("STACK") != null) {
                            ItemStack ExpectantStack = slotSection.getItemStack("STACK");
                            if (ExpectantStack.isSimilar(PickedStack)) {
                                int CurrentVolume = slotSection.getInt("VOLUME");
                                if ((CurrentVolume + PickedStack.getAmount()) >= getLimit(dankLevel)) {
                                    slotSection.set("VOLUME", getLimit(dankLevel));
                                } else {
                                    slotSection.set("VOLUME", CurrentVolume + PickedStack.getAmount());
                                }
                                spawnParticle(e.getItem());
                                e.getItem().remove();
                                e.setCancelled(true);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean hasDank(Player p) {
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null) {
                if (isDank(i, Parent.getInstance())) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<ItemStack> getDanks(Player p) {
        List<ItemStack> l = new ArrayList<>();
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null) {
                if (isDank(i, Parent.getInstance())) {
                    l.add(i);
                }
            }
        }
        return l;
    }

    private void spawnParticle(Item i) {
        World w = i.getLocation().getWorld();
        Location l = i.getLocation();
        Material m = i.getItemStack().getType();
        if (m.isBlock()) {
            BlockData fallingDustData = m.createBlockData();
            w.spawnParticle(Particle.BLOCK_CRACK, l, 32, 0.5, 0.5, 0.5, 0.0D, fallingDustData, true);
        } else {
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 2);
            w.spawnParticle(Particle.REDSTONE, l, 32, 0.5, 0.5, 0.5, 0.0D, dustOptions, true);
        }
    }

}
