package io.github.sefiraat.danktech.finals;

import dev.dbassett.skullcreator.SkullCreator;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.GuiItem;
import io.github.sefiraat.danktech.DankTech;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_DANK_ID;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_TRASH_ID;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_SLOT;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_STACK;
import static io.github.sefiraat.danktech.finals.ItemDetails.guiDisplayNameFiller;

public final class GUIItems {

    private GUIItems() {
        throw new IllegalStateException("Utility class");
    }

    public static GuiItem guiPackFiller() {
        GuiItem g = ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE).asGuiItem();
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        assert im != null;
        im.setDisplayName(guiDisplayNameFiller());
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiPackInfo(long packID, int packLevel) {
        ItemStack guiSkull = SkullCreator.itemFromBase64(Materials.DANK_GUI_INFO);
        GuiItem g = ItemBuilder.skull(guiSkull).asGuiItem();
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        assert im != null;
        im.setDisplayName(ItemDetails.guiDisplayNameInfo());
        im.setLore(ItemDetails.guiDisplayLoreInfo(packID, packLevel));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiPackLockedSlot() {
        GuiItem g = ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).asGuiItem();
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        assert im != null;
        im.setDisplayName(ItemDetails.guiDisplayNameLocked());
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiUnassignedSlot() {
        ItemStack guiSkull = SkullCreator.itemFromBase64(Materials.DANK_GUI_EMPTY);
        GuiItem g = ItemBuilder.skull(guiSkull).asGuiItem();
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        assert im != null;
        im.setDisplayName(ItemDetails.guiDisplayNameUnassigned());
        im.setLore(ItemDetails.guiDisplayLoreUnassigned());
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(im);
        g.setItemStack(i);
        g.setAction(event -> event.setCancelled(true));
        return g;
    }
    public static GuiItem guiPackAssignedSlot(@Nonnull Long dankID, @Nonnull Integer slot) {
        ItemStack i = DankTech.getInstance().getDankStorageConfig().getItemStack(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + "." + CONFIG_GETTER_VAL_SLOT + slot + "." + CONFIG_GETTER_VAL_STACK);
        assert i != null;
        GuiItem g = ItemBuilder.from(i).asGuiItem();
        g.setAction(event -> event.setCancelled(true));
        return g;
    }

    public static GuiItem guiTrashAssignedSlot(@Nonnull Long trashId, @Nonnull Integer slot) {
        ItemStack i = DankTech.getInstance().getDankStorageConfig().getItemStack(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashId + "." + CONFIG_GETTER_VAL_SLOT + slot + "." + CONFIG_GETTER_VAL_STACK);
        assert i != null;
        GuiItem g = ItemBuilder.from(i).asGuiItem();
        g.setAction(event -> event.setCancelled(true));
        return g;
    }

    public static GuiItem guiPackWithdrawItem(int amount) {
        ItemStack guiSkull = SkullCreator.itemFromBase64(Materials.DANK_GUI_INTERACTION);
        GuiItem g = ItemBuilder.skull(guiSkull).asGuiItem();
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        assert im != null;
        im.setDisplayName(ItemDetails.guiDisplayNameWithdraw());
        im.setLore(ItemDetails.guiDisplayLoreWithdraw(amount));
        i.setItemMeta(im);
        g.setItemStack(i);
        return g;
    }

    public static GuiItem guiTrashWithdrawItem() {
        ItemStack guiSkull = SkullCreator.itemFromBase64(Materials.DANK_GUI_INTERACTION);
        GuiItem g = ItemBuilder.skull(guiSkull).asGuiItem();
        ItemStack i = g.getItemStack();
        ItemMeta im = i.getItemMeta();
        assert im != null;
        im.setDisplayName(ItemDetails.GUI_DISPLAY_TRASH_NAME_WITHDRAW);
        im.setLore(ItemDetails.guiDisplayLoreTrash());
        i.setItemMeta(im);
        g.setItemStack(i);
        return g;
    }
}
