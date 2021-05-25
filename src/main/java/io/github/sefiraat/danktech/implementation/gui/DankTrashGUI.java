package io.github.sefiraat.danktech.implementation.gui;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.GUIItems;
import io.github.sefiraat.danktech.finals.Messages;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static io.github.sefiraat.danktech.finals.Constants.*;
import static io.github.sefiraat.danktech.finals.ItemDetails.getTrashName;
import static io.github.sefiraat.danktech.misc.ContainerStorage.getDankId;

public class DankTrashGUI {

    private DankTrashGUI() {
        throw new IllegalStateException("Utility class");
    }

    protected static final Integer[] displaySlots = {0, 1, 2, 3, 4, 5, 6, 7, 8, 27, 28, 29, 30, 31, 32, 33, 34, 35};
    protected static final Integer[] inputSlots = {9, 10, 11, 12, 13, 14, 15, 16, 17, 36, 37, 38, 39, 40, 41, 42, 43, 44};
    protected static final Integer[] interactSlots = {18, 19, 20, 21, 22, 23, 24, 25, 26, 45, 46, 47, 48, 49, 50, 51, 52, 53};

    public static Gui getTrashGUI(long trashID, int trashLevel, DankTech parent) {

        Gui g = new Gui(6, getTrashName(parent, trashLevel));

        if (trashLevel < 9) {
            setBlankColumns(parent, g, trashLevel);
        }

        setItemDisplays(g, trashLevel, trashID, parent);
        setInputRows(g, trashLevel, trashID, parent);
        setItemWithdraws(g, trashLevel, trashID, parent);

        g.setDefaultClickAction(event -> {
            if (event.isShiftClick()) {
                event.setCancelled(true);
            }
        });

        g.setDragAction(event -> event.setCancelled(true));

        return g;
    }

    public static void setBlankColumns(DankTech plugin, Gui gui, int trashLevel) {
        for (int i = (trashLevel + 1); i <= 9; i++) {
            gui.setItem(1, i, GUIItems.guiPackLockedSlot(plugin));
            gui.setItem(2, i, GUIItems.guiPackLockedSlot(plugin));
            gui.setItem(3, i, GUIItems.guiPackLockedSlot(plugin));
            gui.setItem(4, i, GUIItems.guiPackLockedSlot(plugin));
            gui.setItem(5, i, GUIItems.guiPackLockedSlot(plugin));
            gui.setItem(6, i, GUIItems.guiPackLockedSlot(plugin));
        }
    }

    public static void setInputRows(Gui gui, int trashLevel, long trashID, DankTech parent) {
        Integer[] rows = { 2, 5 };
        Integer count = 1;
        for (int slot = 1; slot <= trashLevel; slot++) {
            for (Integer row : rows) {
                int finalSlot = slot;
                Integer finalCount = count;
                gui.addSlotAction(row, slot, event -> {
                    inputItemAction(event, gui, finalSlot, row, finalCount, trashID, parent);
                    event.setCancelled(true);
                });
                count++;
            }
        }
    }

    public static void inputItemAction(InventoryClickEvent e, Gui gui, int slotC, int slotR, int dankSlot, long trashID, DankTech plugin) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID);
        ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + dankSlot);
        if (e.getWhoClicked().getItemOnCursor().getType() != Material.AIR) {
            if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) == null) {
                ItemStack i = e.getWhoClicked().getItemOnCursor();
                if (getDankId(i, plugin) != trashID) {
                    ItemStack i2 = i.clone();
                    i.setAmount(i.getAmount() - 1);
                    e.getWhoClicked().setItemOnCursor(i);
                    i2.setAmount(1);
                    slotSection.set(CONFIG_GETTER_VAL_STACK, i2);
                    slotSection.set(CONFIG_GETTER_VAL_VOLUME, 1);
                    gui.updateItem(slotR - 1, slotC, GUIItems.guiTrashAssignedSlot(trashID, dankSlot, plugin));
                } else {
                    e.getWhoClicked().sendMessage(Messages.messageEventInputThisDank(plugin));
                }
            } else {
                e.getWhoClicked().sendMessage(Messages.messageEventInputExisting(plugin));
            }
        }
    }

    public static void setItemDisplays(Gui gui, int trashLevel, long trashID, DankTech plugin) {
        Integer[] rows = { 1, 4 };
        Integer count = 1;
        for (int i = 1; i <= trashLevel; i++) {
            for (Integer r : rows ) {
                ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID);
                ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + count);
                if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
                    gui.setItem(r, i, GUIItems.guiTrashAssignedSlot(trashID, count, plugin));
                } else {
                    gui.setItem(r, i, GUIItems.guiUnassignedSlot(plugin));
                }
                count++;
            }
        }
    }

    public static void setItemWithdraws(Gui gui, int trashLevel, long trashID, DankTech plugin) {
        Integer[] rows = { 3, 6 };
        Integer count = 1;
        for (int i = 1; i <= trashLevel; i++) {
            for (Integer r : rows ) {
                GuiItem g = GUIItems.guiTrashWithdrawItem();
                Integer finalI = i;
                Integer finalCount = count;
                g.setAction(event -> {
                    withdrawItems(gui, trashID, plugin, finalI, r, finalCount, event);
                    event.setCancelled(true);
                });
                gui.setItem(r, i, g);
                count++;
            }
        }
    }

    public static void withdrawItems(Gui gui, long trashID, DankTech plugin, int slot, int row, int dankSlot, InventoryClickEvent e) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID);
        ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + dankSlot);
        if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
            int firstEmpty = e.getWhoClicked().getInventory().firstEmpty();
            if (e.getClick() == ClickType.LEFT) {
                if (firstEmpty != -1) {
                    withdrawOne(plugin, (Player) e.getWhoClicked(), slotSection, gui, trashID, slot, dankSlot, row);
                } else {
                    e.getWhoClicked().sendMessage(Messages.messageEventWithdrawNoSpace(plugin));
                }
            }
        } else {
            e.getWhoClicked().sendMessage(Messages.messageEventSlotNotAssigned(plugin));
        }
    }

    private static void withdrawOne(DankTech plugin, Player p, ConfigurationSection slotSection, Gui gui, Long trashID, Integer slot, int dankSlot, int row) {

        ItemStack i = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK).clone();

        i.setAmount(1);

        slot = slot%9;

        slotSection.set(CONFIG_GETTER_VAL_VOLUME, 0);
        slotSection.set(CONFIG_GETTER_VAL_STACK, null);
        gui.updateItem(row - 2, slot, GUIItems.guiUnassignedSlot(plugin));
        GuiItem g = GUIItems.guiTrashWithdrawItem();
        Integer finalSlot = slot;
        g.setAction(event -> {
            withdrawItems(gui, trashID, plugin, finalSlot, row, dankSlot, event);
            event.setCancelled(true);
        });
        gui.updateItem(row, slot, g);

        p.getInventory().addItem(i);
    }


}
