package io.github.sefiraat.danktech.finals;

import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIItems {
    public static GuiItem GUIPackFiller() {
        GuiItem g = new GuiItem(Material.GRAY_STAINED_GLASS_PANE);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUIDisplayNameFiller);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        return g;
    }
    public static GuiItem GUIPackInfo(long PackID, int PackLevel) {
        GuiItem g = new GuiItem(Material.BLUE_STAINED_GLASS_PANE);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUIDisplayNameInfo);
        im.setLore(ItemDetails.GUIDisplayLoreInfo(PackID, PackLevel));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        return g;
    }
    public static GuiItem GUIPackLockedSlot() {
        GuiItem g = new GuiItem(Material.RED_STAINED_GLASS_PANE);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUIDisplayNameLocked);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        return g;
    }
}
