package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.ItemStacks;
import io.github.sefiraat.danktech.finals.Materials;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.dankpacks.DankPack;
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
import static io.github.sefiraat.danktech.lib.misc.Utils.getNextPackID;

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

            Player p = (Player) e.getView().getPlayer();
            ItemStack[] contents = e.getInventory().getMatrix();
            boolean isNew = false;
            boolean hasDankItems = false;
            int[] slots = {0, 1, 2, 3, 5, 6, 7, 8};
            boolean itemsCorrect = true;
            int dankLevel = 1;
            long dankID = -1;

            if (!allSlotsFilled(contents)) {
                return;
            }

            ItemStack c = contents[4];

            NamespacedKey levelKey = new NamespacedKey(parent.getInstance(), KEY_LEVEL);
            NamespacedKey idKey = new NamespacedKey(parent.getInstance(), KEY_ID);

            if (c.getType() == Materials.DANK_CORE_MATERIAL || c.getItemMeta().getPersistentDataContainer().has(levelKey, PersistentDataType.INTEGER)) {
                // Core denotes a DANK PACK craft
                if (c.getType() == Materials.DANK_CORE_MATERIAL) {
                    dankID = getNextPackID(parent);
                } else {
                    dankLevel = c.getItemMeta().getPersistentDataContainer().get(levelKey, PersistentDataType.INTEGER) + 1;
                    dankID = c.getItemMeta().getPersistentDataContainer().get(idKey, PersistentDataType.LONG);
                }

                if (cellMatchLevel(dankLevel, contents, parent)) {
                    ItemStack r = ItemStacks.getShallowDank(dankLevel);
                    ItemMeta im = r.getItemMeta();
                    im.getPersistentDataContainer().set(levelKey, PersistentDataType.INTEGER, dankLevel);
                    im.getPersistentDataContainer().set(idKey, PersistentDataType.LONG, dankID);
                    r.setItemMeta(im);
                    e.getInventory().setResult(r);
                }
            }

//            if (res.getType() == Materials.DANK_1) {
//                isNew = true;
//                if(contents[4].getType() == Materials.DANK_CORE_MATERIAL) {
//                    hasDankItems = true;
//                }
//            }
//
//            for (int i : slots) {
//                ItemStack item = contents[i];
//                if (!isDankMaterial(item, parent)) {
//                    itemsCorrect = false;
//                    p.sendMessage("Failed isDankMaterials");
//                } else {
//                    hasDankItems = true;
//                }
//            }
//
//            if (!isNew) {
//
//                if (contents[4].getItemMeta().getPersistentDataContainer().has(levelKey, PersistentDataType.INTEGER)) {
//                    dankLevel = contents[4].getItemMeta().getPersistentDataContainer().get(levelKey, PersistentDataType.INTEGER) + 1;
//                    dankID = contents[4].getItemMeta().getPersistentDataContainer().get(idKey, PersistentDataType.LONG);
//                } else {
//                    itemsCorrect = false;
//                    p.sendMessage("Failed hasLevelKey");
//
//                }
//            }
//
//            if (itemsCorrect) {
//                NamespacedKey key = new NamespacedKey(parent.getInstance(), KEY_LEVEL);
//                NamespacedKey idKey = new NamespacedKey(parent.getInstance(),KEY_ID);
//                ItemStack r = ItemStacks.getShallowDank(dankLevel);
//                ItemMeta im = r.getItemMeta();
//                im.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, dankLevel);
//                im.getPersistentDataContainer().set(idKey, PersistentDataType.LONG, dankID);
//                r.setItemMeta(im);
//                e.getInventory().setResult(r);
//            } else {
//                p.sendMessage("Items Incorrect");
//                if (hasDankItems) {
//                    p.sendMessage("Does have dank items");
//                    e.getInventory().setResult(new ItemStack(Material.AIR));
//                }
//            }


        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            if (e.getInventory().getResult() != null) {
                NamespacedKey key = new NamespacedKey(parent.getInstance(), KEY_LEVEL);
                ItemStack res = e.getInventory().getResult();
                // boolean isDank = isResultDank(res.getType());
                boolean hasKey = res.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.INTEGER);
                if (hasKey) {
                    int level = res.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
                    if (level == 1) {
                        long packID = getNextPackID(parent);
                        ItemStack dank = DankPack.DankPack(level, packID, parent, p);
                        ItemMeta m = dank.getItemMeta();
                        m.setDisplayName(getDankNameBold(level));
                        m.setLore(ItemDetails.getDankLore(level, packID, null));
                        dank.setItemMeta(m);
                        e.setCurrentItem(dank);
                        p.sendMessage(Messages.MESSAGE_CRAFT_NEW_PACK);
                    } else {
                        NamespacedKey idKey = new NamespacedKey(parent.getInstance(), KEY_ID);
                        long packID = res.getItemMeta().getPersistentDataContainer().get(idKey, PersistentDataType.LONG);
                        ConfigurationSection c = parent.getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + packID);
                        c.set(CONFIG_GETTER_VAL_LEVEL,level);
                        c.set(CONFIG_GETTER_VAL_SLOT + level + "." + CONFIG_GETTER_VAL_STACK, null);
                        c.set(CONFIG_GETTER_VAL_SLOT + level + "." + CONFIG_GETTER_VAL_VOLUME , 0);
                        ItemStack dank = DankPack.DankPack(level, packID, parent, p);
                        ItemMeta m = dank.getItemMeta();
                        m.setDisplayName(getDankNameBold(level));
                        m.setLore(ItemDetails.getDankLore(level, packID, null));
                        dank.setItemMeta(m);
                        e.setCurrentItem(dank);
                        p.sendMessage(Messages.MESSAGE_CRAFT_UPGRADE_PACK);
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
            if (i.hasItemMeta()) {
                if (i.getItemMeta().getPersistentDataContainer().has(keyLevel,PersistentDataType.INTEGER)) {
                    Integer stackLevel = i.getItemMeta().getPersistentDataContainer().get(keyLevel,PersistentDataType.INTEGER);
                    if (!stackLevel.equals(level)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean allSlotsFilled(ItemStack[] itemStacks) {
        for (int i = 0; i < 9; i++) {
            if (itemStacks[i] == null) {
                return false;
            }
        }
        return true;
    }

}
