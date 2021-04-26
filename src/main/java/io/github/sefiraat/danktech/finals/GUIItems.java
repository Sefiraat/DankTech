package io.github.sefiraat.danktech.finals;

import io.github.sefiraat.danktech.DankTech;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.entity.Item;
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
        g.setAction(event -> {event.setCancelled(true);});
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
        g.setAction(event -> {event.setCancelled(true);});
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
        g.setAction(event -> {event.setCancelled(true);});
        return g;
    }
    public static GuiItem GUIPackUnassignedSlot() {
        GuiItem g = new GuiItem(Material.BARRIER);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUIDisplayNameUnassigned);
        im.setLore(ItemDetails.GUIDisplayLoreUnassigned());
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> {event.setCancelled(true);});
        return g;
    }
    public static GuiItem GUIPackAssignedSlot(long dankID, int slot, DankTech plugin) {
        ItemStack i = plugin.getDankStorageConfig().getItemStack("PACKS.PACKS_BY_ID." + dankID + ".SLOT" + slot + ".STACK");
        GuiItem g = new GuiItem(i);
        g.setAction(event -> {event.setCancelled(true);});
        return g;
    }

    public static GuiItem GUIPackWithdrawItem(int amount) {
        ItemStack i = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUIDisplayNameWithdraw);
        im.setLore(ItemDetails.GUIDisplayLoreWithdraw(amount));
        i.setItemMeta(im);
        GuiItem g = new GuiItem(i);
        return g;
    }
}
