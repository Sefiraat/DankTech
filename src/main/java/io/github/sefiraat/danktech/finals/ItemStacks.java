package io.github.sefiraat.danktech.finals;

import dev.dbassett.skullcreator.SkullCreator;
import io.github.sefiraat.danktech.DankTech;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static io.github.sefiraat.danktech.finals.ItemDetails.getDankCellName;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.ItemDetails.getTrashNameBold;
import static io.github.sefiraat.danktech.finals.Materials.UPGRADE_RANGE_TEXTURE;
import static io.github.sefiraat.danktech.finals.Materials.getDankCellTexture;
import static io.github.sefiraat.danktech.finals.Materials.getDankTexture;
import static io.github.sefiraat.danktech.finals.Materials.getTrashTexture;
import static io.github.sefiraat.danktech.misc.ContainerStorage.makeDank;
import static io.github.sefiraat.danktech.misc.ContainerStorage.makeShallow;
import static io.github.sefiraat.danktech.misc.ContainerStorage.makeTrash;
import static io.github.sefiraat.danktech.misc.ContainerStorage.setCellLevel;
import static io.github.sefiraat.danktech.misc.ContainerStorage.setDankLevel;
import static io.github.sefiraat.danktech.misc.ContainerStorage.setTrashLevel;

public final class ItemStacks {

    private ItemStacks() {
        throw new IllegalStateException("Utility class");
    }

    public static ItemStack getCell(int level) {
        ItemStack cell = SkullCreator.itemFromBase64(getDankCellTexture(level));
        ItemMeta m = cell.getItemMeta();
        m.setDisplayName(getDankCellName(level));
        PersistentDataContainer c = m.getPersistentDataContainer();
        NamespacedKey keyDank = new NamespacedKey(DankTech.getInstance(),"dank");
        c.set(keyDank, PersistentDataType.INTEGER, 1);
        cell.setItemMeta(m);
        setCellLevel(cell, level);
        return cell;
    }

    public static ItemStack getRangeUpgrade(int level) {
        ItemStack cell = SkullCreator.itemFromBase64(UPGRADE_RANGE_TEXTURE);
        ItemMeta m = cell.getItemMeta();
        m.setDisplayName(getDankCellName(level));
        PersistentDataContainer c = m.getPersistentDataContainer();
        NamespacedKey keyDank = new NamespacedKey(DankTech.getInstance(),"dank-upgrade");
        c.set(keyDank, PersistentDataType.INTEGER, 1);
        cell.setItemMeta(m);
        return cell;
    }

    public static ItemStack getShallowDank(int level) {
        ItemStack dank = createSkull(getDankTexture(level));
        makeDank(dank);
        makeShallow(dank);
        setDankLevel(dank, level);
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        dank.setItemMeta(m);
        return dank;
    }

    public static ItemStack getShallowTrash(int level) {
        ItemStack trash = createSkull(getTrashTexture(level));
        makeTrash(trash);
        makeShallow(trash);
        setTrashLevel(trash, level);
        ItemMeta m = trash.getItemMeta();
        m.setDisplayName(getTrashNameBold(level));
        trash.setItemMeta(m);
        return trash;
    }

    public static ItemStack createSkull(String base64val) {
        return SkullCreator.itemFromBase64(base64val);
    }

}
