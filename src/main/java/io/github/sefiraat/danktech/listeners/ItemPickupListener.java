package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.misc.ContainerStorage;
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

import static io.github.sefiraat.danktech.finals.Constants.*;
import static io.github.sefiraat.danktech.finals.ItemDetails.getLimit;
import static io.github.sefiraat.danktech.misc.Config.getWorldBlacklistPickup;

public class ItemPickupListener implements Listener {

    DankTech parent;

    public ItemPickupListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        parent = plugin;
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (!canPickupBlacklist(p)) {
                return;
            }
            if(hasTrash(p)) {
                handlePickupTrash(e, p);
            }
            if(hasDank(p)) {
                handlePickupDank(e, p);
            }
        }
    }

    private  void handlePickupTrash(EntityPickupItemEvent e, Player p) {
        List<ItemStack> trashes = getTrash(p);
        for (ItemStack trash : trashes) {
            long trashId = ContainerStorage.getTrashId(trash, parent);
            int trashLevel = ContainerStorage.getTrashLevel(trash, parent);
            ConfigurationSection section = parent.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashId);
            for (int i = 1; i <= (trashLevel*2); i++) {
                ItemStack pickedStack = e.getItem().getItemStack();
                ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + i);
                if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
                    ItemStack expectantStack = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK);
                    if (expectantStack.isSimilar(pickedStack)) {
                        pickupItemTrash(e);
                        return;
                    }
                }
            }
        }
    }

    private void handlePickupDank(EntityPickupItemEvent e, Player p) {
        List<ItemStack> danks = getDanks(p);
        for (ItemStack dank : danks) {
            long dankID = ContainerStorage.getDankId(dank, parent);
            int dankLevel = ContainerStorage.getDankLevel(dank, parent);
            ConfigurationSection section = parent.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
            for (int i = 1; i <= dankLevel; i++) {
                ItemStack pickedStack = e.getItem().getItemStack();
                ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + i);
                if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
                    ItemStack expectantStack = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK);
                    if (expectantStack.isSimilar(pickedStack)) {
                        pickupItemDank(slotSection, pickedStack, dankLevel, e);
                        return;
                    }
                }
            }
        }
    }

    private void pickupItemDank(ConfigurationSection slotSection, ItemStack pickedStack, Integer dankLevel, EntityPickupItemEvent e) {
        int currentVolume = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
        if ((currentVolume + pickedStack.getAmount()) >= getLimit(dankLevel)) {
            slotSection.set(CONFIG_GETTER_VAL_VOLUME, getLimit(dankLevel));
        } else {
            slotSection.set(CONFIG_GETTER_VAL_VOLUME, currentVolume + pickedStack.getAmount());
        }
        spawnPickupParticle(e.getItem());
        e.getItem().remove();
        e.setCancelled(true);
    }

    private void pickupItemTrash(EntityPickupItemEvent e) {
        spawnTrashParticle(e.getItem());
        e.getItem().remove();
        e.setCancelled(true);
    }

    private boolean hasDank(Player p) {
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null && ContainerStorage.isDank(i, parent.getInstance())) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTrash(Player p) {
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null && ContainerStorage.isTrash(i, parent.getInstance())) {
                return true;
            }
        }
        return false;
    }

    private List<ItemStack> getDanks(Player p) {
        List<ItemStack> l = new ArrayList<>();
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null && ContainerStorage.isDank(i, parent.getInstance())) {
                l.add(i);
            }
        }
        return l;
    }

    private List<ItemStack> getTrash(Player p) {
        List<ItemStack> l = new ArrayList<>();
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null && ContainerStorage.isTrash(i, parent.getInstance())) {
                l.add(i);
            }
        }
        return l;
    }

    private void spawnPickupParticle(Item i) {
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

    private void spawnTrashParticle(Item i) {
        World w = i.getLocation().getWorld();
        Location l = i.getLocation();
        w.spawnParticle(Particle.SMOKE_LARGE, l, 32, 0.5, 0.5, 0.5, 0.0D, null,true);
    }

    private boolean canPickupBlacklist(Player p) {
        return p.isOp() || p.hasPermission("danktech.admin") || !getWorldBlacklistPickup(parent).contains(p.getWorld().getName());
    }

}
