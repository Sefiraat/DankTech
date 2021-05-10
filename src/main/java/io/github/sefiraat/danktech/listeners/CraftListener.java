package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.ItemStacks;
import io.github.sefiraat.danktech.finals.Materials;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.dankpacks.DankPack;
import io.github.sefiraat.danktech.implementation.dankpacks.TrashPack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;

import static io.github.sefiraat.danktech.finals.Constants.*;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.ItemDetails.getTrashNameBold;
import static io.github.sefiraat.danktech.misc.Config.getNextPackID;
import static io.github.sefiraat.danktech.misc.Config.getNextTrashID;

public class CraftListener implements Listener {

    final DankTech parent;

    public CraftListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        parent = plugin;
    }

    @EventHandler
    public void onPreCraft(PrepareItemCraftEvent e) {
        // TODO Really messy now and CC too high
        if (e.getView().getPlayer() instanceof Player) {

            ItemStack[] contents = e.getInventory().getMatrix();

            if (!allSlotsFilled(contents)) {
                return;
            }

            ItemStack c = contents[4];

            NamespacedKey levelDankKey = new NamespacedKey(parent.getInstance(), KEY_LEVEL_DANK);
            NamespacedKey idDankKey = new NamespacedKey(parent.getInstance(), KEY_ID_DANK);

            NamespacedKey levelTrashKey = new NamespacedKey(parent.getInstance(), KEY_LEVEL_TRASH);
            NamespacedKey idTrashKey = new NamespacedKey(parent.getInstance(), KEY_ID_TRASH);

            if (c.getType() == Materials.DANK_CORE_MATERIAL || c.getItemMeta().getPersistentDataContainer().has(levelDankKey, PersistentDataType.INTEGER)) {
                // Core denotes a DANK PACK craft

                int dankLevel = 1;
                long dankID = -1;

                if (c.getType() == Materials.DANK_CORE_MATERIAL) {
                    dankID = getNextPackID(parent);
                } else {
                    dankLevel = c.getItemMeta().getPersistentDataContainer().get(levelDankKey, PersistentDataType.INTEGER) + 1;
                    dankID = c.getItemMeta().getPersistentDataContainer().get(idDankKey, PersistentDataType.LONG);
                }

                if (cellMatchLevel(dankLevel, contents, parent)) {
                    ItemStack r = ItemStacks.getShallowDank(dankLevel);
                    ItemMeta im = r.getItemMeta();
                    im.getPersistentDataContainer().set(levelDankKey, PersistentDataType.INTEGER, dankLevel);
                    im.getPersistentDataContainer().set(idDankKey, PersistentDataType.LONG, dankID);
                    r.setItemMeta(im);
                    e.getInventory().setResult(r);
                }
            } else  if (c.getType() == Materials.TRASH_CORE_MATERIAL || c.getItemMeta().getPersistentDataContainer().has(levelTrashKey, PersistentDataType.INTEGER)) {
                // Core denotes a DANK TRASH craft

                int trashLevel = 1;
                long trashID = -1;

                if (c.getType() == Materials.TRASH_CORE_MATERIAL) {
                    trashID = getNextTrashID(parent);
                } else {
                    trashLevel = c.getItemMeta().getPersistentDataContainer().get(levelTrashKey, PersistentDataType.INTEGER) + 1;
                    trashID = c.getItemMeta().getPersistentDataContainer().get(idTrashKey, PersistentDataType.LONG);
                }

                if (cellMatchLevel(trashLevel, contents, parent)) {
                    ItemStack r = ItemStacks.getShallowTrash(trashLevel);
                    ItemMeta im = r.getItemMeta();
                    im.getPersistentDataContainer().set(levelTrashKey, PersistentDataType.INTEGER, trashLevel);
                    im.getPersistentDataContainer().set(idTrashKey, PersistentDataType.LONG, trashID);
                    r.setItemMeta(im);
                    e.getInventory().setResult(r);
                }
            }
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            if (e.getInventory().getResult() != null) {
                ItemStack res = e.getInventory().getResult();
                NamespacedKey dankKey = new NamespacedKey(parent.getInstance(), KEY_LEVEL_DANK);
                boolean hasDankKey = res.getItemMeta().getPersistentDataContainer().has(dankKey, PersistentDataType.INTEGER);
                NamespacedKey trashKey = new NamespacedKey(parent.getInstance(), KEY_LEVEL_TRASH);
                boolean hasTrashKey = res.getItemMeta().getPersistentDataContainer().has(trashKey, PersistentDataType.INTEGER);

                if (hasDankKey) {
                    int level = res.getItemMeta().getPersistentDataContainer().get(dankKey, PersistentDataType.INTEGER);
                    if (level == 1) {
                        long packID = getNextPackID(parent);
                        ItemStack dank = DankPack.getDankPack(level, packID, parent, p);
                        ItemMeta m = dank.getItemMeta();
                        m.setDisplayName(getDankNameBold(level));
                        m.setLore(ItemDetails.getDankLore(level, packID, null));
                        dank.setItemMeta(m);
                        e.setCurrentItem(dank);
                        p.sendMessage(Messages.MESSAGE_CRAFT_NEW_PACK);
                    } else {
                        NamespacedKey idKey = new NamespacedKey(parent.getInstance(), KEY_ID_DANK);
                        long packID = res.getItemMeta().getPersistentDataContainer().get(idKey, PersistentDataType.LONG);
                        ConfigurationSection c = parent.getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + packID);
                        c.set(CONFIG_GETTER_VAL_LEVEL, level);
                        c.set(CONFIG_GETTER_VAL_SLOT + level + "." + CONFIG_GETTER_VAL_STACK, null);
                        c.set(CONFIG_GETTER_VAL_SLOT + level + "." + CONFIG_GETTER_VAL_VOLUME , 0);
                        ItemStack dank = DankPack.getDankPack(level, packID, parent, p);
                        ItemMeta m = dank.getItemMeta();
                        m.setDisplayName(getDankNameBold(level));
                        m.setLore(ItemDetails.getDankLore(level, packID, null));
                        dank.setItemMeta(m);
                        e.setCurrentItem(dank);
                        p.sendMessage(Messages.MESSAGE_CRAFT_UPGRADE_PACK);
                    }
                }
                if (hasTrashKey) {
                    int level = res.getItemMeta().getPersistentDataContainer().get(trashKey, PersistentDataType.INTEGER);
                    if (level == 1) {
                        long trashID = getNextTrashID(parent);
                        ItemStack trash = TrashPack.getTrashPack(level, trashID, parent, p);
                        ItemMeta m = trash.getItemMeta();
                        m.setDisplayName(getTrashNameBold(level));
                        m.setLore(ItemDetails.getTrashLore(level, trashID));
                        trash.setItemMeta(m);
                        e.setCurrentItem(trash);
                        p.sendMessage(Messages.MESSAGE_CRAFT_NEW_TRASH);
                    } else {
                        NamespacedKey idKey = new NamespacedKey(parent.getInstance(), KEY_ID_TRASH);
                        long trashID = res.getItemMeta().getPersistentDataContainer().get(idKey, PersistentDataType.LONG);
                        ConfigurationSection c = parent.getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID);
                        c.set(CONFIG_GETTER_VAL_LEVEL, ((level*2)-1));
                        c.set(CONFIG_GETTER_VAL_SLOT + ((level*2)-1) + "." + CONFIG_GETTER_VAL_STACK, null);
                        c.set(CONFIG_GETTER_VAL_SLOT + ((level*2)-1) + "." + CONFIG_GETTER_VAL_VOLUME , 0);
                        c.set(CONFIG_GETTER_VAL_LEVEL, (level*2));
                        c.set(CONFIG_GETTER_VAL_SLOT + (level*2) + "." + CONFIG_GETTER_VAL_STACK, null);
                        c.set(CONFIG_GETTER_VAL_SLOT + (level*2) + "." + CONFIG_GETTER_VAL_VOLUME , 0);
                        ItemStack trash = TrashPack.getTrashPack(level, trashID, parent, p);
                        ItemMeta m = trash.getItemMeta();
                        m.setDisplayName(getTrashNameBold(level));
                        m.setLore(ItemDetails.getTrashLore(level, trashID));
                        trash.setItemMeta(m);
                        e.setCurrentItem(trash);
                        p.sendMessage(Messages.MESSAGE_CRAFT_UPGRADE_TRASH);
                    }
                }
            } else {
                p.sendMessage("Result is false?");
            }
        }
    }

    public boolean isResultDank(Material m) {
        return m == Materials.DANK_1 ||
                m == Materials.DANK_2 ||
                m == Materials.DANK_3 ||
                m == Materials.DANK_4 ||
                m == Materials.DANK_5 ||
                m == Materials.DANK_6 ||
                m == Materials.DANK_7 ||
                m == Materials.DANK_8 ||
                m == Materials.DANK_9;
    }

    public boolean cellMatchLevel(Integer level, ItemStack[] itemStacks, DankTech plugin) {
        NamespacedKey keyLevel = new NamespacedKey(plugin,"cell-level");
        for (ItemStack i : itemStacks) {
            if (i.hasItemMeta() && i.getItemMeta().getPersistentDataContainer().has(keyLevel,PersistentDataType.INTEGER)) {
                Integer stackLevel = i.getItemMeta().getPersistentDataContainer().get(keyLevel,PersistentDataType.INTEGER);
                if (!stackLevel.equals(level)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean allSlotsFilled(ItemStack[] itemStacks) {
        if (itemStacks.length > 8) {
            for (int i = 0; i < 9; i++) {
                if (itemStacks[i] == null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
