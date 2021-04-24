package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.implimentation.items.ItemDank;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ItemPickupListener implements Listener {

    public ItemPickupListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(hasDank(p)) {
                List<ItemStack> Danks = getDanks(p);
            }
        }
    }

    private boolean hasDank(Player p) {
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null) {
                if (isDank(i)) {
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
                if (isDank(i)) {
                    l.add(i);
                }
            }
        }
        return l;
    }

    private boolean isDank(ItemStack i) {
        // TODO
        return false;
    }



}
