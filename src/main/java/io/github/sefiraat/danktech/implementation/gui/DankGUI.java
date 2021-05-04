package io.github.sefiraat.danktech.implementation.gui;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.GUIItems;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.lib.misc.Utils;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static io.github.sefiraat.danktech.finals.Constants.*;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankName;
import static io.github.sefiraat.danktech.lib.misc.Utils.getDankId;

public class DankGUI {

    private DankGUI() {
        throw new IllegalStateException("Utility class");
    }

    public static Gui getDankGUI(long dankID, int dankLevel, DankTech parent) {

        Integer[] arrayFillerSlots = new Integer[]{0, 1, 2, 3, 5, 6, 7, 8, 36, 37, 38, 39, 40, 41, 42, 43, 44};
        List<Integer> listFillerSlots = Arrays.asList(arrayFillerSlots);

        Gui g = new Gui(5, getDankName(dankLevel));

        g.setItem(listFillerSlots, GUIItems.guiPackFiller());
        g.setItem(4, GUIItems.guiPackInfo(dankID, dankLevel));

        if (dankLevel < 9) {
            setBlankColumns(g, dankLevel);
        }

        setItemDisplays(g, dankLevel, dankID, parent);
        setInputRow(g, dankLevel, dankID, parent);
        setItemWithdraw(g, dankLevel, dankID, parent);

        g.setDefaultClickAction(event -> {
            if (event.isShiftClick()) {
                event.setCancelled(true);
            }
        });

        g.setDragAction(event -> event.setCancelled(true));

        return g;
    }

    public static void setBlankColumns(Gui gui, int dankLevel) {
        for (int i = (dankLevel + 1); i <= 9; i++) {
            gui.setItem(2, i, GUIItems.guiPackLockedSlot());
            gui.setItem(3, i, GUIItems.guiPackLockedSlot());
            gui.setItem(4, i, GUIItems.guiPackLockedSlot());
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
            ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
            ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + i);
            int amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
            GuiItem g = GUIItems.guiPackWithdrawItem(amount);
            int finalI = i;
            g.setAction(event -> {
                withdrawItems(gui, dankID, plugin, finalI, event);
                event.setCancelled(true);
            });
            gui.setItem(4, i, g);
        }
    }

    public static void setItemDisplays(Gui gui, int dankLevel, long dankID, DankTech plugin) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
        for (int i = 1; i <= dankLevel; i++) {
            ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + i);
            if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
                gui.setItem(2, i, GUIItems.guiPackAssignedSlot(dankID, i, plugin));
            } else {
                gui.setItem(2, i, GUIItems.guiPackUnassignedSlot());
            }
        }
    }

    public static void inputItemAction(InventoryClickEvent e, Gui gui, int slot, long dankID, DankTech plugin) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
        ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + slot);
        if (e.getWhoClicked().getItemOnCursor().getType() != Material.AIR) {
            if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) == null) {
                ItemStack i = e.getWhoClicked().getItemOnCursor();
                if (getDankId(i, plugin) != dankID) {
                    ItemStack i2 = i.clone();
                    i.setAmount(i.getAmount() - 1);
                    e.getWhoClicked().setItemOnCursor(i);
                    i2.setAmount(1);
                    slotSection.set(CONFIG_GETTER_VAL_STACK, i2);
                    slotSection.set(CONFIG_GETTER_VAL_VOLUME, 1);
                    gui.updateItem(2, slot, GUIItems.guiPackAssignedSlot(dankID, slot, plugin));
                } else {
                    e.getWhoClicked().sendMessage(Messages.MESSAGE_EVENT_INPUT_THIS_DANK);
                }
            } else {
                e.getWhoClicked().sendMessage(Messages.MESSAGE_EVENT_INPUT_EXISTING);
            }
        }
    }

    public static void withdrawItems(Gui gui, long dankID, DankTech plugin, int slot, InventoryClickEvent e) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
        ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + slot);
        if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
            Integer firstEmpty = e.getWhoClicked().getInventory().firstEmpty();
            switch (e.getClick()) {
                case LEFT:
                    if (firstEmpty != -1) {
                        withdrawLeftClick(plugin, (Player) e.getWhoClicked(), slotSection, gui, dankID, slot);
                    } else {
                        e.getWhoClicked().sendMessage(Messages.MESSAGE_EVENT_WITHDRAW_NO_SPACE);
                    }
                    break;
                case RIGHT:
                    if (firstEmpty != -1) {
                        withdrawStack(plugin, (Player) e.getWhoClicked(), slotSection, gui, dankID, slot, false);
                    } else {
                        e.getWhoClicked().sendMessage(Messages.MESSAGE_EVENT_WITHDRAW_NO_SPACE);
                    }
                    break;
                case SHIFT_LEFT:
                    withdrawShiftLeftClick(plugin, (Player) e.getWhoClicked(), slotSection, gui, dankID, slot);
                    break;
                case SHIFT_RIGHT:
                    if (firstEmpty != -1) {
                        withdrawShiftRightClick(plugin, (Player) e.getWhoClicked(), slotSection, gui, dankID, slot);
                    } else {
                        e.getWhoClicked().sendMessage(Messages.MESSAGE_EVENT_WITHDRAW_NO_SPACE);
                    }
                    break;
                case DROP:
                    withdrawStack(plugin, (Player) e.getWhoClicked(), slotSection, gui, dankID, slot, true);
                    break;
                default:
                    break;
            }
        } else {
            e.getWhoClicked().sendMessage(Messages.MESSAGE_EVENT_SLOT_NOT_ASSIGNED);
        }
    }

    private static void withdrawLeftClick(DankTech plugin, Player p, ConfigurationSection slotSection, Gui gui, Long dankID, Integer slot) {
        Integer amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
        ItemStack i = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK).clone();
        if (amount == 1) {
            i.setAmount(amount);
            slotSection.set(CONFIG_GETTER_VAL_VOLUME, 0);
            slotSection.set(CONFIG_GETTER_VAL_STACK, null);
            gui.updateItem(2, slot, GUIItems.guiPackUnassignedSlot());
            GuiItem g = GUIItems.guiPackWithdrawItem(0);
            g.setAction(event -> {
                withdrawItems(gui, dankID, plugin, slot, event);
                event.setCancelled(true);
            });
            gui.updateItem(4, slot, g);
        } else {
            i.setAmount(1);
            amount = (amount - 1);
            slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
            GuiItem g = GUIItems.guiPackWithdrawItem(amount);
            g.setAction(event -> {
                withdrawItems(gui, dankID, plugin, slot, event);
                event.setCancelled(true);
            });
            gui.updateItem(4, slot, g);
        }
        p.getInventory().addItem(i);
    }

    private static void withdrawStack(DankTech plugin, Player p, ConfigurationSection slotSection, Gui gui, Long dankID, Integer slot, boolean isDrop) {
        Integer amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
        ItemStack i = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK).clone();
        if (amount > 1) {
            if (amount <= i.getMaxStackSize()) {
                i.setAmount(amount - 1);
                slotSection.set(CONFIG_GETTER_VAL_VOLUME, 1);
                GuiItem g = GUIItems.guiPackWithdrawItem(1);
                g.setAction(event -> {
                    withdrawItems(gui, dankID, plugin, slot, event);
                    event.setCancelled(true);
                });
                gui.updateItem(4, slot, g);
            } else {
                i.setAmount(i.getMaxStackSize());
                amount = (amount - i.getMaxStackSize());
                slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
                GuiItem g = GUIItems.guiPackWithdrawItem(amount);
                g.setAction(event -> {
                    withdrawItems(gui, dankID, plugin, slot, event);
                    event.setCancelled(true);
                });
                gui.updateItem(4, slot, g);
            }
            if (!isDrop) {
                p.getInventory().addItem(i);
            } else {
                Item thrownItem = p.getWorld().dropItem(p.getLocation().clone().add(0,1,0), i);
                thrownItem.setVelocity(p.getLocation().getDirection().multiply(0.45));
                thrownItem.setPickupDelay(4 * 20);
            }
        }
    }

    private static void withdrawShiftLeftClick(DankTech plugin, Player p, ConfigurationSection slotSection, Gui gui, Long dankID, Integer slot) {
        Integer amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
        Integer additionalAmount = 0;
        ItemStack stack = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK).clone();
        for (ItemStack i : p.getInventory().getStorageContents()) {
            if (i != null && i.isSimilar(stack)) {
                Integer inAmount = i.getAmount();
                additionalAmount = additionalAmount + inAmount;
                i.setAmount(0);
            }
        }
        if (additionalAmount > 0) {
            amount = amount + additionalAmount;
            slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
            GuiItem g = GUIItems.guiPackWithdrawItem(amount);
            g.setAction(event -> {
                withdrawItems(gui, dankID, plugin, slot, event);
                event.setCancelled(true);
            });
            gui.updateItem(4, slot, g);
        }
    }

    private static void withdrawShiftRightClick(DankTech plugin, Player p, ConfigurationSection slotSection, Gui gui, Long dankID, Integer slot) {
        Integer freeSlots = Utils.getEmptySlots(p);
        Integer amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
        ItemStack i = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK).clone();
        Integer withdrawAmount = (i.getMaxStackSize() * freeSlots);
        if (amount > 1) {
            if (amount <= withdrawAmount) {
                i.setAmount(amount - 1);
                slotSection.set(CONFIG_GETTER_VAL_VOLUME, 1);
                GuiItem g = GUIItems.guiPackWithdrawItem(1);
                g.setAction(event -> {
                    withdrawItems(gui, dankID, plugin, slot, event);
                    event.setCancelled(true);
                });
                gui.updateItem(4, slot, g);
            } else {
                i.setAmount(withdrawAmount);
                amount = (amount - withdrawAmount);
                slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
                GuiItem g = GUIItems.guiPackWithdrawItem(amount);
                g.setAction(event -> {
                    withdrawItems(gui, dankID, plugin, slot, event);
                    event.setCancelled(true);
                });
                gui.updateItem(4, slot, g);
            }
            p.getInventory().addItem(i);
        }
    }
}
