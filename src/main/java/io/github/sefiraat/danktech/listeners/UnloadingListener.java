package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static io.github.sefiraat.danktech.lib.misc.Utils.getDankId;
import static io.github.sefiraat.danktech.lib.misc.Utils.isDank;

public class UnloadingListener implements Listener {

    final DankTech Parent;

    public UnloadingListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        Parent = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onHop(InventoryMoveItemEvent e) {
        if (e.getSource().getType() == InventoryType.HOPPER) {
            if (isDank(e.getItem(), Parent)) {
                ItemStack Dank = e.getItem();
                Long dankID = getDankId(Dank, Parent.getInstance());
                ConfigurationSection section = Parent.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + dankID);
                ConfigurationSection slotSection = null;
                e.setCancelled(true);
                for (String s : section.getKeys(false)) {
                    if (s.matches(".*SLOT.*")) {
                        if (section.getConfigurationSection(s).getItemStack("STACK") != null && section.getConfigurationSection(s).getInt("VOLUME") > 1) {
                            slotSection = section.getConfigurationSection(s);
                            break;
                        }
                    }
                }

                if (slotSection != null) {
                    if (e.getDestination().firstEmpty() != -1) {
                        Integer amount = slotSection.getInt("VOLUME");
                        ItemStack i = slotSection.getItemStack("STACK").clone();
                        if (amount > 1) {
                            if (amount <= i.getMaxStackSize()) {
                                i.setAmount(amount - 1);
                                slotSection.set("VOLUME", 1);
                            } else {
                                i.setAmount(i.getMaxStackSize());
                                amount = (amount - i.getMaxStackSize());
                                slotSection.set("VOLUME", amount);
                            }
                            e.getDestination().addItem(i);
                        }
                    }
                }
            }
        }
    }
}
