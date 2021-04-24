package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import io.github.sefiraat.danktech.lib.misc.Utils;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

import static io.github.sefiraat.danktech.lib.misc.Utils.containerHasData;
import static io.github.sefiraat.danktech.lib.misc.Utils.isDank;

public class ItemPickupListener implements Listener {

    DankTech Parent;

    public ItemPickupListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        Parent = plugin;
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {
        ItemStack PickedStack = e.getItem().getItemStack();
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(hasDank(p)) {
                List<ItemStack> Danks = getDanks(p);
                for (ItemStack i : Danks) {
                    p.sendMessage("The item");
                }
            }
        }
    }

    private boolean hasDank(Player p) {
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null) {
                if (isDank(i, Parent)) {
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
                if (isDank(i, Parent)) {
                    l.add(i);
                }
            }
        }
        return l;
    }





}
