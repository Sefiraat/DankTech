package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.ItemStacks;
import io.github.sefiraat.danktech.finals.Materials;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.abstracts.DankPack;
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
import static io.github.sefiraat.danktech.finals.Materials.getDankMaterial;
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
        if (e.getView().getPlayer() instanceof Player && e.getRecipe() != null) {

            ItemStack res = e.getRecipe().getResult();
            if (isResultDank(res.getType())) {

                ItemStack[] contents = e.getInventory().getMatrix();
                boolean isNew = false;
                boolean hasDankItems = false;
                int[] slots = {0, 1, 2, 3, 5, 6, 7, 8};
                boolean itemsCorrect = true;
                int dankLevel = 1;
                long dankID = -1;

                if (res.getType() == Materials.DANK_1) {
                    isNew = true;
                    if(contents[4].getType() == Material.DRAGON_EGG) {
                        hasDankItems = true;
                    }
                }

                for (int i : slots) {
                    NamespacedKey key = new NamespacedKey(parent, "dank");
                    if (!contents[i].getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.INTEGER)) {
                        itemsCorrect = false;
                    } else {
                        hasDankItems = true;
                    }
                }

                if (!isNew) {
                    NamespacedKey levelKey = new NamespacedKey(parent.getInstance(), KEY_LEVEL);
                    NamespacedKey idKey = new NamespacedKey(parent.getInstance(), KEY_ID);
                    if (contents[4].getItemMeta().getPersistentDataContainer().has(levelKey, PersistentDataType.INTEGER)) {
                        dankLevel = contents[4].getItemMeta().getPersistentDataContainer().get(levelKey, PersistentDataType.INTEGER) + 1;
                        dankID = contents[4].getItemMeta().getPersistentDataContainer().get(idKey, PersistentDataType.LONG);
                    } else {
                        itemsCorrect = false;
                    }
                }

                if (itemsCorrect) {
                    NamespacedKey key = new NamespacedKey(parent.getInstance(), KEY_LEVEL);
                    NamespacedKey idKey = new NamespacedKey(parent.getInstance(),KEY_ID);
                    ItemStack r = ItemStacks.getShallowDank(dankLevel);
                    ItemMeta im = r.getItemMeta();
                    im.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, dankLevel);
                    im.getPersistentDataContainer().set(idKey, PersistentDataType.LONG, dankID);
                    r.setItemMeta(im);
                    e.getInventory().setResult(r);
                } else {
                    if (hasDankItems) {
                        e.getInventory().setResult(new ItemStack(Material.AIR));
                    }
                }

            }
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (e.getView().getPlayer() instanceof Player) {
            Player p = (Player) e.getView().getPlayer();
            if (e.getInventory().getResult() != null) {
                NamespacedKey key = new NamespacedKey(parent.getInstance(), KEY_LEVEL);
                ItemStack res = e.getInventory().getResult();
                boolean isDank = isResultDank(res.getType());
                boolean hasKey = res.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.INTEGER);
                if (isDank && hasKey) {
                    int level = res.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
                    if (level == 1) {
                        long packID = getNextPackID(parent);
                        DankPack dank = new DankPack(getDankMaterial(level), level, packID, parent, p);
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
                        DankPack dank = new DankPack(getDankMaterial(level), level, packID, parent, p);
                        ItemMeta m = dank.getItemMeta();
                        m.setDisplayName(getDankNameBold(level));
                        m.setLore(ItemDetails.getDankLore(level, packID, null));
                        dank.setItemMeta(m);
                        e.setCurrentItem(dank);
                        p.sendMessage(Messages.MESSAGE_CRAFT_UPGRADE_PACK);
                    }
                }
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

}
