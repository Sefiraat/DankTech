package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.configuration.ConfigurationSection;
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
                for (ItemStack iStack : Danks) {
                    long dankID = getDankId(iStack, Parent);
                    int dankLevel = getDankLevel(iStack, Parent);
                    ConfigurationSection section = Parent.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + dankID);

                    for (int i = 1; i <= dankLevel; i++) {
                        ItemStack PickedStack = e.getItem().getItemStack();
                        ConfigurationSection slotSection = section.getConfigurationSection("SLOT" + i);
                        if (slotSection.get("STACK") != null) {
                            ItemStack ExpectantStack = slotSection.getItemStack("STACK");
                            if (ExpectantStack.isSimilar(e.getItem().getItemStack())) {
                                e.setCancelled(true);
                                int CurrentVolume = slotSection.getInt("VOLUME");
                                if ((CurrentVolume + PickedStack.getAmount()) >= getLimit(dankLevel)) {
                                    int Difference = getLimit(dankLevel) - CurrentVolume;
                                    slotSection.set("VOLUME", getLimit(dankLevel));
                                } else {
                                    slotSection.set("VOLUME", CurrentVolume + PickedStack.getAmount());
                                }
                                e.getItem().remove();
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





}
