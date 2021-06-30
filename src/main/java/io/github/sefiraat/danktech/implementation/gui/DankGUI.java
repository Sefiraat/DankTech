package io.github.sefiraat.danktech.implementation.gui;

import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.StorageGui;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.GUIItems;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.misc.Utils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_DANK_ID;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_SLOT;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_STACK;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_VOLUME;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankName;
import static io.github.sefiraat.danktech.misc.Config.isBlacklisted;
import static io.github.sefiraat.danktech.misc.ContainerStorage.getDankId;

public class DankGUI {

    private DankGUI() {
        throw new IllegalStateException("Utility class");
    }

    public static Gui getDankGUI(long dankID, int dankLevel) {

        Integer[] arrayFillerSlots = new Integer[]{0, 1, 2, 3, 5, 6, 7, 8, 36, 37, 38, 39, 40, 41, 42, 43, 44};
        List<Integer> listFillerSlots = Arrays.asList(arrayFillerSlots);

        Gui g = new Gui(5, getDankName(dankLevel));

        g.setItem(listFillerSlots, GUIItems.guiPackFiller());
        g.setItem(4, GUIItems.guiPackInfo(dankID, dankLevel));

        if (dankLevel < 9) {
            setBlankColumns(g, dankLevel);
        }

        setItemDisplays(g, dankLevel, dankID);
        setInputRow(g, dankLevel, dankID);
        setItemWithdraw(g, dankLevel, dankID);

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

    public static void setInputRow(Gui gui, int dankLevel, long dankID) {
        for (int i = 1; i <= dankLevel; i++) {
            int finalI = i;
            gui.addSlotAction(3, i, event -> {
                inputItemAction(event, gui, finalI, dankID);
                event.setCancelled(true);
            });
        }
    }

    public static void setItemWithdraw(Gui gui, int dankLevel, long dankID) {
        for (int i = 1; i <= dankLevel; i++) {
            ConfigurationSection section = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
            ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + i);
            int amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
            GuiItem g = GUIItems.guiPackWithdrawItem(amount);
            int finalI = i;
            g.setAction(event -> {
                withdrawItems(gui, dankID, finalI, event);
                event.setCancelled(true);
            });
            gui.setItem(4, i, g);
        }
    }

    public static void setItemDisplays(Gui gui, int dankLevel, long dankID) {
        ConfigurationSection section = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
        assert section != null;
        for (int i = 1; i <= dankLevel; i++) {
            ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + i);
            assert slotSection != null;
            if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
                gui.setItem(2, i, GUIItems.guiPackAssignedSlot(dankID, i));
            } else {
                gui.setItem(2, i, GUIItems.guiUnassignedSlot());
            }
        }
    }

    public static void inputItemAction(InventoryClickEvent e, Gui gui, int slot, long dankID) {

        ConfigurationSection section = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
        assert section != null;
        ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + slot);
        assert slotSection != null;
        HumanEntity h = e.getWhoClicked();
        ItemStack i = h.getItemOnCursor();
        if (i.getType() != Material.AIR) {

            if (isBlacklisted(i)) {
                h.sendMessage(Messages.messageEventInputBlacklisted());
                return;
            }

            if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
                h.sendMessage(Messages.messageEventInputExisting());
                return;
            }

            if (getDankId(i) != dankID) {
                ItemStack i2 = i.clone();
                i.setAmount(i.getAmount() - 1);
                i2.setAmount(1);
                clearGuiPDC(i2);
                slotSection.set(CONFIG_GETTER_VAL_STACK, i2);
                slotSection.set(CONFIG_GETTER_VAL_VOLUME, 1);
                gui.updateItem(2, slot, GUIItems.guiPackAssignedSlot(dankID, slot));
            } else {
                e.getWhoClicked().sendMessage(Messages.messageEventInputThisDank());
            }
        }
    }

    private static void clearGuiPDC(ItemStack i) {
        ItemMeta im = i.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        c.remove(new NamespacedKey("danktech", "mf-gui"));
        i.setItemMeta(im);
    }




    public static void withdrawItems(Gui gui, long dankID, int slot, InventoryClickEvent e) {
        ConfigurationSection section = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
        ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + slot);
        if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
            GUIWithdrawBase base = new GUIWithdrawBase((Player) e.getWhoClicked(), slotSection, gui, dankID);
            int firstEmpty = e.getWhoClicked().getInventory().firstEmpty();
            switch (e.getClick()) {
                case LEFT:
                    withdrawOne(base, slot, firstEmpty);
                    break;
                case RIGHT:
                    withdrawStack(base, slot, firstEmpty, false);
                    break;
                case SHIFT_LEFT:
                    depositAll(base, slot);
                    break;
                case SHIFT_RIGHT:
                    if (firstEmpty != -1) {
                        withdrawMax(base, slot, firstEmpty);
                    } else {
                        e.getWhoClicked().sendMessage(Messages.messageEventWithdrawNoSpace());
                    }
                    break;
                case DROP:
                    withdrawStack(base, slot, 0, true);
                    break;
                default:
                    break;
            }
        } else {
            e.getWhoClicked().sendMessage(Messages.messageEventSlotNotAssigned());
        }
    }

    private static void withdrawOne(GUIWithdrawBase base, Integer slot, int firstEmpty) {
        if (firstEmpty != -1) {
            ConfigurationSection slotSection = base.getSlotSection();
            Gui gui = base.getGui();
            long dankID = base.getDankID();
            Player p = base.getPlayer();
            Integer amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
            ItemStack i = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK).clone();
            if (amount.equals(1)) {
                i.setAmount(amount);
                slotSection.set(CONFIG_GETTER_VAL_VOLUME, 0);
                slotSection.set(CONFIG_GETTER_VAL_STACK, null);
                gui.updateItem(2, slot, GUIItems.guiUnassignedSlot());
                GuiItem g = GUIItems.guiPackWithdrawItem(0);
                g.setAction(event -> {
                    withdrawItems(gui, dankID, slot, event);
                    event.setCancelled(true);
                });
                gui.updateItem(4, slot, g);
            } else {
                i.setAmount(1);
                amount = (amount - 1);
                slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
                GuiItem g = GUIItems.guiPackWithdrawItem(amount);
                g.setAction(event -> {
                    withdrawItems(gui, dankID, slot, event);
                    event.setCancelled(true);
                });
                gui.updateItem(4, slot, g);
            }
            p.getInventory().addItem(i);
        }
    }

    private static void withdrawStack(GUIWithdrawBase base, Integer slot, int firstEmpty, boolean isDrop) {
        if (firstEmpty != -1) {
            ConfigurationSection slotSection = base.getSlotSection();
            Gui gui = base.getGui();
            long dankID = base.getDankID();
            Player p = base.getPlayer();
            int amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
            ItemStack i = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK).clone();
            if (amount > 1) {
                if (amount <= i.getMaxStackSize()) {
                    i.setAmount(amount - 1);
                    slotSection.set(CONFIG_GETTER_VAL_VOLUME, 1);
                    GuiItem g = GUIItems.guiPackWithdrawItem(1);
                    g.setAction(event -> {
                        withdrawItems(gui, dankID, slot, event);
                        event.setCancelled(true);
                    });
                    gui.updateItem(4, slot, g);
                } else {
                    i.setAmount(i.getMaxStackSize());
                    amount = (amount - i.getMaxStackSize());
                    slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
                    GuiItem g = GUIItems.guiPackWithdrawItem(amount);
                    g.setAction(event -> {
                        withdrawItems(gui, dankID, slot, event);
                        event.setCancelled(true);
                    });
                    gui.updateItem(4, slot, g);
                }
                if (!isDrop) {
                    p.getInventory().addItem(i);
                } else {
                    Item thrownItem = p.getWorld().dropItem(p.getLocation().clone().add(0, 1, 0), i);
                    thrownItem.setVelocity(p.getLocation().getDirection().multiply(0.45));
                    thrownItem.setPickupDelay(4 * 20);
                }
            }
        }
    }

    private static void depositAll(GUIWithdrawBase base, Integer slot) {
        ConfigurationSection slotSection = base.getSlotSection();
        Gui gui = base.getGui();
        long dankID = base.getDankID();
        Player p = base.getPlayer();
        int amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
        int additionalAmount = 0;
        ItemStack stack = Objects.requireNonNull(slotSection.getItemStack(CONFIG_GETTER_VAL_STACK)).clone();
        for (ItemStack i : p.getInventory().getStorageContents()) {
            if (i != null && i.isSimilar(stack)) {
                int inAmount = i.getAmount();
                additionalAmount = additionalAmount + inAmount;
                i.setAmount(0);
            }
        }
        if (additionalAmount > 0) {
            amount = amount + additionalAmount;
            slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
            GuiItem g = GUIItems.guiPackWithdrawItem(amount);
            g.setAction(event -> {
                withdrawItems(gui, dankID, slot, event);
                event.setCancelled(true);
            });
            gui.updateItem(4, slot, g);
        }
    }

    private static void withdrawMax(GUIWithdrawBase base, Integer slot, int firstEmpty) {
        if (firstEmpty != -1) {
            ConfigurationSection slotSection = base.getSlotSection();
            Gui gui = base.getGui();
            long dankID = base.getDankID();
            Player p = base.getPlayer();
            int freeSlots = Utils.getEmptySlots(p);
            int amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
            ItemStack i = Objects.requireNonNull(slotSection.getItemStack(CONFIG_GETTER_VAL_STACK)).clone();

            if (amount > 1) {

                int withdrawAmount = (i.getMaxStackSize() * freeSlots);

                if (amount <= withdrawAmount) {
                    withdrawAmount = amount - 1;
                }

                i.setAmount(withdrawAmount);
                amount = (amount - withdrawAmount);
                slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
                GuiItem g = GUIItems.guiPackWithdrawItem(amount);
                g.setAction(event -> {
                    withdrawItems(gui, dankID, slot, event);
                    event.setCancelled(true);
                });
                gui.updateItem(4, slot, g);

                do {
                    ItemStack giveItem = i.clone();
                    giveItem.setAmount(Math.min(i.getAmount(), i.getMaxStackSize()));
                    i.setAmount(i.getAmount() - giveItem.getAmount());
                    p.getInventory().addItem(giveItem);
                } while (i.getAmount() > 0);

            }
        }
    }
}
