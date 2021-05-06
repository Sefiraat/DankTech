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
import static io.github.sefiraat.danktech.finals.Materials.getDankCellTexture;
import static io.github.sefiraat.danktech.finals.Materials.getDankTexture;

public class ItemStacks {

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
        NamespacedKey keyLevel = new NamespacedKey(plugin,"cell-level");
        c.set(keyLevel, PersistentDataType.INTEGER, level);
        cell.setItemMeta(m);
        return cell;
    }

    public static ItemStack getShallowDank(int level) {
        ItemStack dank = createSkull(getDankTexture(level));
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        dank.setItemMeta(m);
        return dank;
    }

    public static ItemStack createSkull(String base64val) {
        return SkullCreator.itemFromBase64(base64val);
    }

}
