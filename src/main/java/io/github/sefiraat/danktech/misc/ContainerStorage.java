package io.github.sefiraat.danktech.misc;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

import static io.github.sefiraat.danktech.finals.Constants.KEY_SELECTED_SLOT;

public class ContainerStorage {

    private ContainerStorage() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean containerHasData(ItemStack i, NamespacedKey key, PersistentDataType<?, ?> type) {
        if (i.hasItemMeta()) {
            ItemMeta im = i.getItemMeta();
            assert im != null;
            return im.getPersistentDataContainer().has(key, type);
        }
        return false;
    }

    public static Integer getDataInteger(ItemStack i, NamespacedKey key) {
        if (i.hasItemMeta()) {
            ItemMeta im = i.getItemMeta();
            assert im != null;
            if(im.getPersistentDataContainer().has(key , PersistentDataType.INTEGER)) {
                return Objects.requireNonNull(i.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER));
            }
        }
        return 0;
    }

    public static Long getDataLong(ItemStack i, NamespacedKey key) {
        if (i.hasItemMeta()) {
            ItemMeta im = i.getItemMeta();
            assert im != null;
            if(im.getPersistentDataContainer().has(key , PersistentDataType.LONG)) {
                return Objects.requireNonNull(i.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.LONG));
            }
        }
        return 0L;
    }

    public static void setData(ItemStack i, NamespacedKey key, int value) {
        if (i.hasItemMeta()) {
            ItemMeta im = i.getItemMeta();
            assert im != null;
            PersistentDataContainer c = im.getPersistentDataContainer();
            c.set(key, PersistentDataType.INTEGER, value);
            i.setItemMeta(im);
        }
    }

    public static void setData(ItemStack i, NamespacedKey key, String value) {
        if (i.hasItemMeta()) {
            ItemMeta im = i.getItemMeta();
            assert im != null;
            PersistentDataContainer c = im.getPersistentDataContainer();
            c.set(key, PersistentDataType.STRING, value);
            i.setItemMeta(im);
        }
    }

    public static void setData(ItemStack i, NamespacedKey key, long value) {
        if (i.hasItemMeta()) {
            ItemMeta im = i.getItemMeta();
            assert im != null;
            PersistentDataContainer c = im.getPersistentDataContainer();
            c.set(key, PersistentDataType.LONG, value);
            i.setItemMeta(im);
        }
    }

    public static void removeData(ItemStack i, NamespacedKey key) {
        if (i.hasItemMeta()) {
            ItemMeta im = i.getItemMeta();
            assert im != null;
            PersistentDataContainer c = im.getPersistentDataContainer();
            c.remove(key);
            i.setItemMeta(im);
        }
    }

    public static boolean isShallow(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"is-shallow");
        return containerHasData(i, key, PersistentDataType.INTEGER);
    }

    public static void makeShallow(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"is-shallow");
        setData(i, key, 1);
    }

    public static boolean isDank(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"is-dank");
        return containerHasData(i, key, PersistentDataType.INTEGER);
    }

    public static void makeDank(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"is-dank");
        setData(i, key, 1);
    }

    public static boolean isTrash(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"is-trash");
        return containerHasData(i, key, PersistentDataType.INTEGER);
    }

    public static void makeTrash(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"is-trash");
        setData(i, key, 1);
    }

    public static boolean isDankMaterial(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "dank");
        return containerHasData(i, key, PersistentDataType.INTEGER);
    }

    public static Integer getDankLevel(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"dank-level");
        if (containerHasData(i, key, PersistentDataType.INTEGER)) {
            return getDataInteger(i, key);
        }
        return 0;
    }

    public static void setDankLevel(ItemStack i, int value) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"dank-level");
        setData(i, key, value);
    }

    public static Integer getTrashLevel(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"trash-level");
        if (containerHasData(i, key, PersistentDataType.INTEGER)) {
            return getDataInteger(i, key);
        }
        return 0;
    }

    public static void setTrashLevel(ItemStack i, int value) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"trash-level");
        setData(i, key, value);
    }

    public static Integer getCellLevel(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"cell-level");
        if (containerHasData(i, key, PersistentDataType.INTEGER)) {
            return getDataInteger(i, key);
        }
        return 0;
    }

    public static void setCellLevel(ItemStack i, int value) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"cell-level");
        setData(i, key, value);
    }


    public static Long getDankId(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"dank-id");
        if (containerHasData(i, key, PersistentDataType.LONG)) {
            return getDataLong(i, key);
        }
        return 0L;
    }

    public static void setDankId(ItemStack i, long value) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"dank-id");
        setData(i, key, value);
    }

    public static Long getTrashId(ItemStack i) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"trash-id");
        if (containerHasData(i, key, PersistentDataType.LONG)) {
            return getDataLong(i, key);
        }
        return 0L;
    }

    public static void setTrashId(ItemStack i, long value) {
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(),"trash-id");
        setData(i, key, value);
    }

    public static Integer getDankNextSlot(ItemStack i) {
        NamespacedKey ssKey = new NamespacedKey(DankTech.getInstance(),KEY_SELECTED_SLOT);
        Integer dankLevel = getDankLevel(i);
        if (!containerHasData(i, ssKey, PersistentDataType.INTEGER)) {
            setData(i, ssKey, 0);
        }
        int nextSlot = getDataInteger(i, ssKey) + 1;
        if (nextSlot > dankLevel) {
            nextSlot = 1;
        }
        setData(i, ssKey, nextSlot);
        return nextSlot;
    }

    public static Integer getDankPreviousSlot(ItemStack i) {
        NamespacedKey ssKey = new NamespacedKey(DankTech.getInstance(),KEY_SELECTED_SLOT);
        Integer dankLevel = getDankLevel(i);
        if (!containerHasData(i, ssKey, PersistentDataType.INTEGER)) {
            setData(i, ssKey, 0);
        }
        Integer nextSlot = getDataInteger(i, ssKey) - 1;
        if (nextSlot.equals(0)) {
            nextSlot = dankLevel;
        }
        setData(i, ssKey, nextSlot);
        return nextSlot;
    }

    public static Integer getDankCurrentSlot(ItemStack i) {
        NamespacedKey ssKey = new NamespacedKey(DankTech.getInstance(),KEY_SELECTED_SLOT);
        if (!containerHasData(i, ssKey, PersistentDataType.INTEGER)) {
            setData(i, ssKey, 1);
        }
        return getDataInteger(i, ssKey);
    }
}
