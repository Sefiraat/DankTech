package io.github.sefiraat.danktech.finals;

import dev.dbassett.skullcreator.SkullCreator;
import io.github.sefiraat.danktech.DankTech;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

import static io.github.sefiraat.danktech.finals.Constants.*;
import static io.github.sefiraat.danktech.finals.ItemDetails.guiDisplayNameFiller;
import static io.github.sefiraat.danktech.finals.Materials.*;

public final class GUIItems {

    private GUIItems() {
        throw new IllegalStateException("Utility class");
    }

    public static GuiItem guiPackFiller(DankTech plugin) {
        GuiItem g = new GuiItem(Material.GRAY_STAINED_GLASS_PANE);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(guiDisplayNameFiller(plugin));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiPackInfo(DankTech plugin, long packID, int packLevel) {
        ItemStack guiSkull = SkullCreator.itemFromBase64(DANK_GUI_INFO);
        GuiItem g = new GuiItem(guiSkull);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.guiDisplayNameInfo(plugin));
        im.setLore(ItemDetails.guiDisplayLoreInfo(plugin, packID, packLevel));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiPackLockedSlot(DankTech plugin) {
        GuiItem g = new GuiItem(Material.RED_STAINED_GLASS_PANE);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.guiDisplayNameLocked(plugin));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiUnassignedSlot(DankTech plugin) {
        ItemStack guiSkull = SkullCreator.itemFromBase64(DANK_GUI_EMPTY);
        GuiItem g = new GuiItem(guiSkull);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.guiDisplayNameUnassigned(plugin));
        im.setLore(ItemDetails.guiDisplayLoreUnassigned(plugin));
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

    public static GuiItem guiPackWithdrawItem(DankTech plugin, int amount) {
        ItemStack guiSkull = SkullCreator.itemFromBase64(DANK_GUI_INTERACTION);
        GuiItem g = new GuiItem(guiSkull);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.guiDisplayNameWithdraw(plugin));
        im.setLore(ItemDetails.guiDisplayLoreWithdraw(plugin, amount));
        i.setItemMeta(im);
        g.setItemStack(i);
        return g;
    }

    public static GuiItem guiTrashWithdrawItem() {
        ItemStack guiSkull = SkullCreator.itemFromBase64(DANK_GUI_INTERACTION);
        GuiItem g = new GuiItem(guiSkull);
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ItemDetails.GUI_DISPLAY_TRASH_NAME_WITHDRAW);
        im.setLore(ItemDetails.guiDisplayLoreTrash());
        i.setItemMeta(im);
        g.setItemStack(i);
        return g;
    }
}
