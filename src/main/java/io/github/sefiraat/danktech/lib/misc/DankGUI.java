package io.github.sefiraat.danktech.lib.misc;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.GUIItems;
import io.github.sefiraat.danktech.finals.Messages;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static io.github.sefiraat.danktech.finals.ItemDetails.getDankName;

public class DankGUI {

    public static Gui getDankGUI(long DankID, int dankLevel, DankTech parent) {

        Integer[] arrayFillerSlots = new Integer[]{0, 1, 2, 3, 5, 6, 7, 8, 36, 37, 38, 39, 40, 41, 42, 43, 44};
        List<Integer> listFillerSlots = (List<Integer>) Arrays.asList(arrayFillerSlots);

        Gui g = new Gui(5, getDankName(dankLevel));

        g.setItem(listFillerSlots, GUIItems.GUIPackFiller());
        g.setItem(4, GUIItems.GUIPackInfo(DankID, dankLevel));

        if (dankLevel < 9) {
            setBlankColumns(g, dankLevel);
        }

        setItemDisplays(g, dankLevel, DankID, parent);
        setInputRow(g, dankLevel, DankID, parent);
        setItemWithdraw(g, dankLevel, DankID, parent);

        g.setDragAction(event -> {event.setCancelled(true);});

        return g;
    }

    public static void setBlankColumns(Gui gui, int dankLevel) {
        for (int i = (dankLevel + 1); i <= 9; i++) {
            gui.setItem(2, i, GUIItems.GUIPackLockedSlot());
            gui.setItem(3, i, GUIItems.GUIPackLockedSlot());
            gui.setItem(4, i, GUIItems.GUIPackLockedSlot());
        }
    }

    public static void setInputRow(Gui gui, int dankLevel, long dankID, DankTech parent) {
        for (int i = 1; i <= dankLevel; i++) {
            int finalI = i;
            gui.addSlotAction(3, i, event -> {
                inputItemAction(event, gui, finalI, dankID, parent);
                event.setCancelled(true);
            });
        }
    }

    public static void setItemWithdraw(Gui gui, int dankLevel, long dankID, DankTech plugin) {
        for (int i = 1; i <= dankLevel; i++) {
            ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + dankID);
            ConfigurationSection slotSection = section.getConfigurationSection("SLOT" + i);
            int Amount = slotSection.getInt("VOLUME");
            GuiItem g = GUIItems.GUIPackWithdrawItem(Amount);
            int finalI = i;
            g.setAction(event -> {
                withdrawStack(gui, dankID, plugin, finalI, event);
                event.setCancelled(true);
            });
            gui.setItem(4, i, g);
        }
    }

    public static void setItemDisplays(Gui gui, int dankLevel, long dankID, DankTech plugin) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + dankID);
        for (int i = 1; i <= dankLevel; i++) {
            ConfigurationSection slotSection = section.getConfigurationSection("SLOT" + i);
            if (slotSection.get("STACK") != null) {
                ItemStack stack = slotSection.getItemStack("STACK");
                gui.setItem(2, i, GUIItems.GUIPackAssignedSlot(dankID, i, plugin));
            } else {
                gui.setItem(2, i, GUIItems.GUIPackUnassignedSlot());
            }
        }
    }

    public static void inputItemAction(InventoryClickEvent e, Gui gui, int slot, long dankID, DankTech plugin) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + dankID);
        ConfigurationSection slotSection = section.getConfigurationSection("SLOT" + slot);
        if (e.getWhoClicked().getItemOnCursor().getType() != Material.AIR) {
            if (slotSection.get("STACK") == null) {
                ItemStack i = e.getWhoClicked().getItemOnCursor();
                ItemStack i2 = i.clone();
                i.setAmount(i.getAmount() - 1);
                e.getWhoClicked().setItemOnCursor(i);
                i2.setAmount(1);
                slotSection.set("STACK", i2);
                slotSection.set("VOLUME", 1);
                gui.updateItem(2, slot, GUIItems.GUIPackAssignedSlot(dankID, slot, plugin));
            } else {
                e.getWhoClicked().sendMessage(Messages.MessageEventInputExisting);
            }
        }
    }

    public static void withdrawStack(Gui gui, long dankID, DankTech plugin, int slot, InventoryClickEvent e) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + dankID);
        ConfigurationSection slotSection = section.getConfigurationSection("SLOT" + slot);
        if (slotSection.get("STACK") != null) {
            if(e.getWhoClicked().getInventory().firstEmpty() != -1) {
                int Amount = slotSection.getInt("VOLUME");
                ItemStack i = slotSection.getItemStack("STACK");
                if (Amount <= i.getMaxStackSize()) {
                    i.setAmount(Amount);
                    slotSection.set("VOLUME", 0);
                    slotSection.set("STACK", null);
                    gui.updateItem(2, slot, GUIItems.GUIPackUnassignedSlot());
                    GuiItem g = GUIItems.GUIPackWithdrawItem(0);
                    g.setAction(event -> {
                        withdrawStack(gui, dankID, plugin, slot, event);
                        event.setCancelled(true);
                    });
                    gui.updateItem(4, slot, g);
                } else {
                    i.setAmount(i.getMaxStackSize());
                    Amount = (Amount - i.getMaxStackSize());
                    slotSection.set("VOLUME", Amount);
                    gui.updateItem(2, slot, GUIItems.GUIPackAssignedSlot(dankID, slot, plugin));
                    GuiItem g = GUIItems.GUIPackWithdrawItem(Amount);
                    g.setAction(event -> {
                        withdrawStack(gui, dankID, plugin, slot, event);
                        event.setCancelled(true);
                    });
                    gui.updateItem(4, slot, g);
                }
                e.getWhoClicked().getInventory().addItem(i);
            } else {
                e.getWhoClicked().sendMessage(Messages.MessageEventWithdrawNoSpace);
            }
        } else {
            e.getWhoClicked().sendMessage(Messages.MessageEventWithdrawNoVolume);
        }
    }



}
