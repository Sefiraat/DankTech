package io.github.sefiraat.danktech.lib.misc;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.implementation.abstracts.DankPack;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.github.sefiraat.danktech.finals.Constants.*;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.Materials.getDankMaterial;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean containerHasData(ItemStack i, NamespacedKey key, PersistentDataType type) {
        return i.getItemMeta().getPersistentDataContainer().has(key, type);
    }

    public static Object getData(ItemStack i, NamespacedKey key, PersistentDataType type) {
        if(i.getItemMeta().getPersistentDataContainer().has(key , type)) {
            return i.getItemMeta().getPersistentDataContainer().get(key, type);
        } else {
            return null;
        }
    }

    public static void setData(ItemStack i, NamespacedKey key, int value) {
        ItemMeta im = i.getItemMeta();
        PersistentDataContainer c = im.getPersistentDataContainer();
        c.set(key, PersistentDataType.INTEGER, value);
        i.setItemMeta(im);
    }

    public static void setData(ItemStack i, NamespacedKey key, long value) {
        ItemMeta im = i.getItemMeta();
        PersistentDataContainer c = im.getPersistentDataContainer();
        c.set(key, PersistentDataType.LONG, value);
        i.setItemMeta(im);
    }

    public static void removeData(ItemStack i, NamespacedKey key) {
        ItemMeta im = i.getItemMeta();
        PersistentDataContainer c = im.getPersistentDataContainer();
        c.remove(key);
        i.setItemMeta(im);
    }

    public static boolean isDank(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"is-dank");
        return containerHasData(i, key, PersistentDataType.INTEGER);
    }

    public static void makeDank(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"is-dank");
        setData(i, key, 1);
    }

    public static int getDankLevel(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"dank-level");
        if (containerHasData(i, key, PersistentDataType.INTEGER)) {
            return (int) getData(i, key, PersistentDataType.INTEGER);
        }
        return 0;
    }

    public static void setDankLevel(ItemStack i, DankTech plugin, int value) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"dank-level");
        setData(i, key, value);
    }

    public static long getDankId(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"dank-id");
        if (containerHasData(i, key, PersistentDataType.LONG)) {
            return (long) getData(i, key, PersistentDataType.LONG);
        }
        return 0;
    }

    public static void setDankId(ItemStack i, DankTech plugin, long value) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"dank-id");
        setData(i, key, value);
    }

    public static void setLastOpenedBy(Long dankID, DankTech plugin, Player p) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
        section.set("LAST_OPENED_BY_UUID", p.getUniqueId().toString());
        section.set("LAST_OPENED_BY", p.getDisplayName());
        section.set("LAST_OPENED_ON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        plugin.saveDankStorageConfig();
    }

    public static String getLastOpenedBy(Long dankID, DankTech plugin) {
        return plugin.getInstance().getDankStorageConfig().getString(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + ".LAST_OPENED_BY");
    }

    public static String getLastOpenedByUUID(Long dankID, DankTech plugin) {
        return plugin.getInstance().getDankStorageConfig().getString(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + ".LAST_OPENED_BY_UUID");
    }

    public static String getLastOpenedOn(Long dankID, DankTech plugin) {
        return plugin.getInstance().getDankStorageConfig().getString(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + ".LAST_OPENED_ON");
    }

    public static Integer getDankNextSlot(ItemStack i, DankTech plugin) {
        NamespacedKey ssKey = new NamespacedKey(plugin.getInstance(),KEY_SELECTED_SLOT);
        Integer dankLevel = getDankLevel(i, plugin);
        if (!containerHasData(i, ssKey, PersistentDataType.INTEGER)) {
            setData(i, ssKey, 0);
        }
        Integer nextSlot = ((Integer) getData(i, ssKey, PersistentDataType.INTEGER)) + 1;
        if (nextSlot > dankLevel) {
            nextSlot = 1;
        }
        setData(i, ssKey, nextSlot);
        return nextSlot;
    }

    public static Integer getDankPreviousSlot(ItemStack i, DankTech plugin) {
        NamespacedKey ssKey = new NamespacedKey(plugin.getInstance(),KEY_SELECTED_SLOT);
        Integer dankLevel = getDankLevel(i, plugin);
        if (!containerHasData(i, ssKey, PersistentDataType.INTEGER)) {
            setData(i, ssKey, 0);
        }
        Integer nextSlot = ((Integer) getData(i, ssKey, PersistentDataType.INTEGER)) - 1;
        if (nextSlot == 0) {
            nextSlot = dankLevel;
        }
        setData(i, ssKey, nextSlot);
        return nextSlot;
    }

    public static Integer getDankCurrentSlot(ItemStack i, DankTech plugin) {
        NamespacedKey ssKey = new NamespacedKey(plugin.getInstance(),KEY_SELECTED_SLOT);
        if (!containerHasData(i, ssKey, PersistentDataType.INTEGER)) {
            setData(i, ssKey, 1);
        }
        return ((Integer) getData(i, ssKey, PersistentDataType.INTEGER));
    }

    public static ItemStack getSlotItemStack(Long dankID, Integer slot, DankTech plugin) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "."  + dankID);
        ConfigurationSection slotSection = section.getConfigurationSection("SLOT" + slot);
        ItemStack stack = null;
        if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
            stack = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK).clone();
        }
        return stack;
    }

    public static long getNextPackID(DankTech plugin) {
        ConfigurationSection sec = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID);
        int nextValue = 1;
        if (sec != null) {
            for (String key : sec.getKeys(false)) {
                int value = Integer.parseInt(key);
                if (value > nextValue) {
                    nextValue = value;
                }
            }
            nextValue++;
        }
        return nextValue;
    }

    public static List<ItemStack> getAllDanks(DankTech plugin) {
        List<ItemStack> l = new ArrayList<>();
        ConfigurationSection sec = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID);
        if (sec != null) {
            for (String s : sec.getKeys(false)) {
                Long dankID = Long.valueOf(s);
                int level = plugin.getInstance().getDankStorageConfig().getInt(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + "." + CONFIG_GETTER_VAL_LEVEL);
                DankPack dank = new DankPack(getDankMaterial(level), level, dankID, plugin, null);
                ItemMeta m = dank.getItemMeta();
                m.setDisplayName(getDankNameBold(level));
                m.setLore(ItemDetails.getDankLore(level, dankID, null));
                dank.setItemMeta(m);
                l.add(dank);
            }
        }
        return l;
    }

    public static ConfigurationSection getDankSection(DankTech plugin, long dankID) {
        return plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "."  + dankID);
    }

    public static int getEmptySlots(Player p) {
        PlayerInventory inventory = p.getInventory();
        ItemStack[] cont = inventory.getStorageContents();
        int i = 0;
        for (ItemStack item : cont)
            if (item != null) {
                i++;
            }
        return 36 - i;
    }

}
