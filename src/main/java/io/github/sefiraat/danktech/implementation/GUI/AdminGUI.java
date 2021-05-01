package io.github.sefiraat.danktech.implementation.GUI;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.GUIItems;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.abstracts.DankPack;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PaginatedGui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.Materials.getDankMaterial;
import static io.github.sefiraat.danktech.implementation.GUI.DankGUI.getDankGUI;
import static io.github.sefiraat.danktech.lib.misc.Utils.*;

public class AdminGUI {


    public static PaginatedGui getDankAdminGUI(DankTech parent) {

        Integer[] arrayFillerSlots = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 45, 47, 48, 49, 50, 51, 53};
        Integer backSlot = 46;
        Integer forwardSlot = 52;
        List<Integer> listFillerSlots = Arrays.asList(arrayFillerSlots);

        PaginatedGui g = new PaginatedGui(6, "Admin Dank GUI");

        g.setItem(listFillerSlots, GUIItems.GUIPackFiller());
        g.setItem(backSlot, ItemBuilder.from(Material.PAPER).setName("Previous").asGuiItem(event -> g.previous()));
        g.setItem(forwardSlot, ItemBuilder.from(Material.PAPER).setName("Next").asGuiItem(event -> g.next()));

        for (ItemStack i : getAllDanks(parent)) {
            ItemMeta im = i.getItemMeta();
            List<String> lore = im.getLore();
            Long dankId = getDankId(i, parent);
            Integer dankLevel = getDankLevel(i, parent);
            lore.add("");
            lore.add(ChatColor.LIGHT_PURPLE + getLastOpenedBy(dankId, parent));
            lore.add(ChatColor.LIGHT_PURPLE + getLastOpenedByUUID(dankId, parent));
            lore.add(ChatColor.LIGHT_PURPLE + getLastOpenedOn(dankId, parent));
            lore.add("");
            lore.add(ChatColor.GREEN + "Left click to open");
            lore.add(ChatColor.GREEN + "Right click recover");
            im.setLore(lore);
            i.setItemMeta(im);
            GuiItem dankGuiItem = new GuiItem(i, event -> {
                adminClickDank(event, dankId, dankLevel, parent);
            });
            g.addItem(dankGuiItem);
        }

        g.setDefaultClickAction(event -> { event.setCancelled(true); });
        g.setDragAction(event -> { event.setCancelled(true); });

        return g;
    }

    public static void adminClickDank(InventoryClickEvent event, Long dankId, Integer dankLevel, DankTech plugin) {
        Player p = (Player) event.getWhoClicked();
        if (event.isLeftClick()) {
            p.sendMessage(Messages.MessageEventOpenPack(dankId));
            Gui dankGUI = getDankGUI(dankId, dankLevel, plugin.getInstance());
            //dankGUI.setCloseGuiAction(event2 -> {
            //    PaginatedGui gInner = getDankAdminGUI(plugin);
            //    gInner.open(event2.getPlayer());
            //});
            dankGUI.open(p);
        } else {
            DankPack Dank = new DankPack(getDankMaterial(dankLevel), dankLevel, dankId, plugin, null);
            ItemMeta m = Dank.getItemMeta();
            m.setDisplayName(getDankNameBold(dankLevel));
            m.setLore(ItemDetails.getDankLore(dankLevel, dankId, null));
            Dank.setItemMeta(m);
            p.getInventory().addItem(Dank);
            p.sendMessage(Messages.MessageCommandPackGiven(dankId));
        }
    }

}
