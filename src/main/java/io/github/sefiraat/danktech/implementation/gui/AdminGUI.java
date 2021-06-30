package io.github.sefiraat.danktech.implementation.gui;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.PaginatedGui;
import dev.triumphteam.gui.guis.StorageGui;
import io.github.sefiraat.danktech.finals.GUIItems;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.dankpacks.DankPack;
import io.github.sefiraat.danktech.misc.Config;
import io.github.sefiraat.danktech.misc.ContainerStorage;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.implementation.gui.DankGUI.getDankGUI;

public class AdminGUI {

    private AdminGUI() {
        throw new IllegalStateException("Utility class");
    }

    public static PaginatedGui getDankAdminGUI() {

        Integer[] arrayFillerSlots = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 45, 47, 48, 49, 50, 51, 53};
        int backSlot = 46;
        int forwardSlot = 52;
        List<Integer> listFillerSlots = Arrays.asList(arrayFillerSlots);

        PaginatedGui g = new PaginatedGui(6, "Admin Dank GUI");

        g.setItem(listFillerSlots, GUIItems.guiPackFiller());
        g.setItem(backSlot, ItemBuilder.from(Material.PAPER).setName("Previous").asGuiItem(event -> g.previous()));
        g.setItem(forwardSlot, ItemBuilder.from(Material.PAPER).setName("Next").asGuiItem(event -> g.next()));

        for (ItemStack i : Config.getAllDanks()) {
            ItemMeta im = i.getItemMeta();
            assert im != null;
            List<String> lore = im.getLore();
            assert lore != null;
            Long dankId = ContainerStorage.getDankId(i);
            Integer dankLevel = ContainerStorage.getDankLevel(i);
            lore.add("");
            lore.add(ChatColor.LIGHT_PURPLE + Config.getLastOpenedBy(dankId));
            lore.add(ChatColor.LIGHT_PURPLE + Config.getLastOpenedByUUID(dankId));
            lore.add(ChatColor.LIGHT_PURPLE + Config.getLastOpenedOn(dankId));
            lore.add("");
            lore.add(ChatColor.GREEN + "Left click to open");
            lore.add(ChatColor.GREEN + "Right click recover");
            im.setLore(lore);
            i.setItemMeta(im);
            GuiItem dankGuiItem = new GuiItem(i, event -> adminClickDank(event, dankId, dankLevel));
            g.addItem(dankGuiItem);
        }

        g.setDefaultClickAction(event -> event.setCancelled(true));
        g.setDragAction(event -> event.setCancelled(true));

        return g;
    }

    public static void adminClickDank(InventoryClickEvent event, Long dankId, Integer dankLevel) {
        Player p = (Player) event.getWhoClicked();
        if (event.isLeftClick()) {
            p.sendMessage(Messages.messageEventOpenPack(dankId));
            Gui dankGUI = getDankGUI(dankId, dankLevel);
            dankGUI.open(p);
        } else {
            ItemStack dank = DankPack.getDankPack(dankLevel, dankId, p.getPlayer());
            ItemMeta im = dank.getItemMeta();
            assert im != null;
            im.setDisplayName(getDankNameBold(dankLevel));
            im.setLore(ItemDetails.getDankLore(dankLevel, dankId, null));
            dank.setItemMeta(im);
            p.getInventory().addItem(dank);
            p.sendMessage(Messages.messageCommandPackGiven(dankId));
        }
    }

}
