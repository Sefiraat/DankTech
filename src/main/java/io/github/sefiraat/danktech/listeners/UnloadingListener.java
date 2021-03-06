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

import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_DANK_ID;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_STACK;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_VOLUME;
import static io.github.sefiraat.danktech.misc.ContainerStorage.getDankId;
import static io.github.sefiraat.danktech.misc.ContainerStorage.isDank;

public class UnloadingListener implements Listener {

    public UnloadingListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onHop(InventoryMoveItemEvent e) {
        if (e.getSource().getType().equals(InventoryType.HOPPER) && isDank(e.getItem())) {
            ItemStack dank = e.getItem();
            Long dankID = getDankId(dank);
            ConfigurationSection section = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
            ConfigurationSection slotSection = null;
            e.setCancelled(true);
            for (String s : section.getKeys(false)) {
                if (s.matches(".*SLOT.*")) {
                    if (section.getConfigurationSection(s).getItemStack(CONFIG_GETTER_VAL_STACK) != null && section.getConfigurationSection(s).getInt(CONFIG_GETTER_VAL_VOLUME) > 1) {
                        slotSection = section.getConfigurationSection(s);
                        break;
                    }
                }
            }

            if (slotSection != null && e.getDestination().firstEmpty() != -1) {
                hopItemsFromDank(slotSection, e);
            }
        }
    }

    private void hopItemsFromDank(ConfigurationSection slotSection, InventoryMoveItemEvent e) {
        int amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
        ItemStack i = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK).clone();
        if (amount > 1) {
            if (amount <= i.getMaxStackSize()) {
                i.setAmount(amount - 1);
                slotSection.set(CONFIG_GETTER_VAL_VOLUME, 1);
            } else {
                i.setAmount(i.getMaxStackSize());
                amount = (amount - i.getMaxStackSize());
                slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
            }
            e.getDestination().addItem(i);
        }
    }
}
