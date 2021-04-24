package io.github.sefiraat.danktech.lib.misc;
import io.github.sefiraat.danktech.DankTech;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class Utils {

    public static boolean containerHasData(ItemStack i, NamespacedKey key, PersistentDataType type) {
        if(i.getItemMeta().getPersistentDataContainer().has(key , type)) {
            return true;
        } else {
            return false;
        }
    }

    public static Object getData(ItemStack i, NamespacedKey key, PersistentDataType type) {
        if(i.getItemMeta().getPersistentDataContainer().has(key , type)) {
            return i.getItemMeta().getPersistentDataContainer().get(key, type);
        } else {
            return null;
        }
    }

    public static void setData(ItemStack i) {

    }

    public static boolean isDank(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"is-dank");
        if (containerHasData(i, key, PersistentDataType.INTEGER)) {
            return true;
        }
        return false;
    }

    public static int getDankLevel(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"dank-level");
        if (containerHasData(i, key, PersistentDataType.INTEGER)) {
            return (int) getData(i, key, PersistentDataType.INTEGER);
        }
        return 0;
    }

    public static long getDankId(ItemStack i, DankTech plugin) {
        NamespacedKey key = new NamespacedKey(plugin.getInstance(),"dank-id");
        if (containerHasData(i, key, PersistentDataType.LONG)) {
            return (long) getData(i, key, PersistentDataType.LONG);
        }
        return 0;
    }

}
