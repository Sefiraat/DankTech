package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.implementation.abstracts.DankPack;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static io.github.sefiraat.danktech.lib.misc.Utils.*;

public class ItemRightClickListener implements Listener {

    DankTech Parent;

    public ItemRightClickListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        Parent = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onRightClick(PlayerInteractEvent e) {
        ItemStack i = e.getItem();
        if (isDank(i, Parent)) {
            e.setCancelled(true);
            int dankLevel = getDankLevel(i,Parent);
            long dankId = getDankId(i, Parent);
            ConfigurationSection dankConfig = Parent.getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + dankId);
            DankPack d = new DankPack(dankLevel, dankConfig);
        }
    }

}
