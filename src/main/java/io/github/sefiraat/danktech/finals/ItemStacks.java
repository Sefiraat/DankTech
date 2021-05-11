package io.github.sefiraat.danktech.finals;

import dev.dbassett.skullcreator.SkullCreator;
import io.github.sefiraat.danktech.DankTech;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static io.github.sefiraat.danktech.finals.ItemDetails.*;
import static io.github.sefiraat.danktech.finals.Materials.*;
import static io.github.sefiraat.danktech.misc.ContainerStorage.*;

public final class ItemStacks {

    private ItemStacks() {
        throw new IllegalStateException("Utility class");
    }

    public static ItemStack getCell(int level, DankTech plugin) {
        ItemStack cell = SkullCreator.itemFromBase64(getDankCellTexture(level));
        ItemMeta m = cell.getItemMeta();
        m.setDisplayName(getDankCellName(level));
        PersistentDataContainer c = m.getPersistentDataContainer();
        NamespacedKey keyDank = new NamespacedKey(plugin,"dank");
        c.set(keyDank, PersistentDataType.INTEGER, 1);
        cell.setItemMeta(m);
        setCellLevel(cell, plugin, level);
        return cell;
    }

    public static ItemStack getShallowDank(int level, DankTech plugin) {
        ItemStack dank = createSkull(getDankTexture(level));
        makeDank(dank, plugin);
        setDankLevel(dank, plugin, level);
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        dank.setItemMeta(m);
        return dank;
    }

    public static ItemStack getShallowTrash(int level, DankTech plugin) {
        ItemStack trash = createSkull(getTrashTexture(level));
        makeTrash(trash, plugin);
        setTrashLevel(trash, plugin, level);
        ItemMeta m = trash.getItemMeta();
        m.setDisplayName(getTrashNameBold(level));
        trash.setItemMeta(m);
        return trash;
    }

    public static ItemStack createSkull(String base64val) {
        return SkullCreator.itemFromBase64(base64val);
    }

}
