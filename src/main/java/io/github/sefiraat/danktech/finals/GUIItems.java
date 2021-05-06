package io.github.sefiraat.danktech.finals;

import io.github.sefiraat.danktech.DankTech;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

import static io.github.sefiraat.danktech.finals.Constants.*;

public class GUIItems {

    private GUIItems() {
        throw new IllegalStateException("Utility class");
    }

    public static GuiItem guiPackFiller() {
        GuiItem g = new GuiItem(Material.GRAY_STAINED_GLASS_PANE);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUI_DISPLAY_NAME_FILLER);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiPackInfo(long packID, int packLevel) {
        GuiItem g = new GuiItem(Material.BLUE_STAINED_GLASS_PANE);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUI_DISPLAY_NAME_INFO);
        im.setLore(ItemDetails.guiDisplayLoreInfo(packID, packLevel));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiPackLockedSlot() {
        GuiItem g = new GuiItem(Material.RED_STAINED_GLASS_PANE);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUI_DISPLAY_NAME_LOCKED);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiUnassignedSlot() {
        GuiItem g = new GuiItem(Material.BARRIER);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUI_DISPLAY_NAME_UNASSIGNED);
        im.setLore(ItemDetails.guiDisplayLoreUnassigned());
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiPackAssignedSlot(@Nonnull Long dankID, @Nonnull Integer slot, @Nonnull DankTech plugin) {
        ItemStack i = plugin.getDankStorageConfig().getItemStack(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + "." + CONFIG_GETTER_VAL_SLOT + slot + "." + CONFIG_GETTER_VAL_STACK);
        GuiItem g = new GuiItem(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }

    public static GuiItem guiTrashAssignedSlot(@Nonnull Long trashId, @Nonnull Integer slot, @Nonnull DankTech plugin) {
        ItemStack i = plugin.getDankStorageConfig().getItemStack(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashId + "." + CONFIG_GETTER_VAL_SLOT + slot + "." + CONFIG_GETTER_VAL_STACK);
        GuiItem g = new GuiItem(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }

    public static GuiItem guiPackWithdrawItem(int amount) {
        ItemStack i = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUI_DISPLAY_NAME_WITHDRAW);
        im.setLore(ItemDetails.guiDisplayLoreWithdraw(amount));
        i.setItemMeta(im);
        return new GuiItem(i);
    }

    public static GuiItem guiTrashWithdrawItem(int amount) {
        ItemStack i = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUI_DISPLAY_TRASH_NAME_WITHDRAW);
        im.setLore(ItemDetails.guiDisplayLoreTrash());
        i.setItemMeta(im);
        return new GuiItem(i);
    }
}
