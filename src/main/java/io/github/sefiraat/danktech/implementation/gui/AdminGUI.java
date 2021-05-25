package io.github.sefiraat.danktech.implementation.gui;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.GUIItems;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.dankpacks.DankPack;
import io.github.sefiraat.danktech.misc.Config;
import io.github.sefiraat.danktech.misc.ContainerStorage;
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
import static io.github.sefiraat.danktech.implementation.gui.DankGUI.getDankGUI;

public class AdminGUI {

    private AdminGUI() {
        throw new IllegalStateException("Utility class");
    }

    public static PaginatedGui getDankAdminGUI(DankTech parent) {

        Integer[] arrayFillerSlots = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 45, 47, 48, 49, 50, 51, 53};
        Integer backSlot = 46;
        Integer forwardSlot = 52;
        List<Integer> listFillerSlots = Arrays.asList(arrayFillerSlots);

        PaginatedGui g = new PaginatedGui(6, "Admin Dank GUI");

        g.setItem(listFillerSlots, GUIItems.guiPackFiller(parent));
        g.setItem(backSlot, ItemBuilder.from(Material.PAPER).setName("Previous").asGuiItem(event -> g.previous()));
        g.setItem(forwardSlot, ItemBuilder.from(Material.PAPER).setName("Next").asGuiItem(event -> g.next()));

        for (ItemStack i : Config.getAllDanks(parent)) {
            ItemMeta im = i.getItemMeta();
            List<String> lore = im.getLore();
            Long dankId = ContainerStorage.getDankId(i, parent);
            Integer dankLevel = ContainerStorage.getDankLevel(i, parent);
            lore.add("");
            lore.add(ChatColor.LIGHT_PURPLE + Config.getLastOpenedBy(dankId, parent));
            lore.add(ChatColor.LIGHT_PURPLE + Config.getLastOpenedByUUID(dankId, parent));
            lore.add(ChatColor.LIGHT_PURPLE + Config.getLastOpenedOn(dankId, parent));
            lore.add("");
            lore.add(ChatColor.GREEN + "Left click to open");
            lore.add(ChatColor.GREEN + "Right click recover");
            im.setLore(lore);
            i.setItemMeta(im);
            GuiItem dankGuiItem = new GuiItem(i, event -> adminClickDank(event, dankId, dankLevel, parent));
            g.addItem(dankGuiItem);
        }

        g.setDefaultClickAction(event -> event.setCancelled(true));
        g.setDragAction(event -> event.setCancelled(true));

        return g;
    }

    public static void adminClickDank(InventoryClickEvent event, Long dankId, Integer dankLevel, DankTech plugin) {
        Player p = (Player) event.getWhoClicked();
        if (event.isLeftClick()) {
            p.sendMessage(Messages.messageEventOpenPack(plugin, dankId));
            Gui dankGUI = getDankGUI(dankId, dankLevel, plugin.getInstance());
            dankGUI.open(p);
        } else {
            ItemStack dank = DankPack.getDankPack(dankLevel, dankId, plugin, p.getPlayer());
            ItemMeta m = dank.getItemMeta();
            m.setDisplayName(getDankNameBold(plugin, dankLevel));
            m.setLore(ItemDetails.getDankLore(plugin, dankLevel, dankId, null));
            dank.setItemMeta(m);
            p.getInventory().addItem(dank);
            p.sendMessage(Messages.messageCommandPackGiven(plugin, dankId));
        }
    }

}
