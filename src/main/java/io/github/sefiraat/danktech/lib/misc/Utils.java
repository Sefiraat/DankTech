package io.github.sefiraat.danktech.lib.misc;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Utils {

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

    public static long getNextPackID(DankTech plugin) {
        ConfigurationSection sec = plugin.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID");
        int maxValue = 1;
        for (String key : sec.getKeys(false)) {
            int value = Integer.parseInt(key);
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue + 1;
    }

    public static ConfigurationSection getDankSection(DankTech plugin, long DankID) {
        return plugin.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACK_BY_ID." + DankID);
    }

}
