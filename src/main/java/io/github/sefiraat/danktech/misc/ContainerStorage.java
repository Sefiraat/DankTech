package io.github.sefiraat.danktech.misc;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static io.github.sefiraat.danktech.finals.Constants.KEY_SELECTED_SLOT;

public class ContainerStorage {

    private ContainerStorage() {
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

    public static void setData(ItemStack i, NamespacedKey key, String value) {
        ItemMeta im = i.getItemMeta();
        PersistentDataContainer c = im.getPersistentDataContainer();
        c.set(key, PersistentDataType.STRING, value);
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

    public static boolean isTrash(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"is-trash");
        return containerHasData(i, key, PersistentDataType.INTEGER);
    }

    public static void makeTrash(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"is-trash");
        setData(i, key, 1);
    }

    public static boolean isDankMaterial(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin, "dank");
        return containerHasData(i, key, PersistentDataType.INTEGER);
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

    public static int getTrashLevel(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"trash-level");
        if (containerHasData(i, key, PersistentDataType.INTEGER)) {
            return (int) getData(i, key, PersistentDataType.INTEGER);
        }
        return 0;
    }

    public static void setTrashLevel(ItemStack i, DankTech plugin, int value) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"trash-level");
        setData(i, key, value);
    }

    public static int getCellLevel(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"cell-level");
        if (containerHasData(i, key, PersistentDataType.INTEGER)) {
            return (int) getData(i, key, PersistentDataType.INTEGER);
        }
        return 0;
    }

    public static void setCellLevel(ItemStack i, DankTech plugin, int value) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"cell-level");
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

    public static long getTrashId(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"trash-id");
        if (containerHasData(i, key, PersistentDataType.LONG)) {
            return (long) getData(i, key, PersistentDataType.LONG);
        }
        return 0;
    }

    public static void setTrashId(ItemStack i, DankTech plugin, long value) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"trash-id");
        setData(i, key, value);
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
}