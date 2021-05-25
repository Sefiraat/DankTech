package io.github.sefiraat.danktech.finals;

import io.github.sefiraat.danktech.DankTech;
import net.md_5.bungee.api.ChatColor;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static io.github.sefiraat.danktech.finals.Debug.BUGS_WARN_USERS;

public final class ItemDetails {

    private ItemDetails() {
        throw new IllegalStateException("Utility class");
    }

    // Dank Stuff

    public static String nameDank1(DankTech plugin) {
        return "" + ChatColor.GRAY + plugin.getConfigClass().getStrings().getItemDankPack() + " [T1]";
    }

    public static String nameDank2(DankTech plugin) {
        return "" + ChatColor.DARK_GRAY + plugin.getConfigClass().getStrings().getItemDankPack() + " [T2]";
    }

    public static String nameDank3(DankTech plugin) {
        return "" + ChatColor.GREEN + plugin.getConfigClass().getStrings().getItemDankPack() + " [T3]";
    }

    public static String nameDank4(DankTech plugin) {
        return "" + ChatColor.DARK_GREEN + plugin.getConfigClass().getStrings().getItemDankPack() + " [T4]";
    }

    public static String nameDank5(DankTech plugin) {
        return "" + ChatColor.BLUE + plugin.getConfigClass().getStrings().getItemDankPack() + " [T5]";
    }

    public static String nameDank6(DankTech plugin) {
        return "" + ChatColor.DARK_BLUE + plugin.getConfigClass().getStrings().getItemDankPack() + " [T6]";
    }

    public static String nameDank7(DankTech plugin) {
        return "" + ChatColor.LIGHT_PURPLE + plugin.getConfigClass().getStrings().getItemDankPack() + " [T7]";
    }

    public static String nameDank8(DankTech plugin) {
        return "" + ChatColor.DARK_PURPLE + plugin.getConfigClass().getStrings().getItemDankPack() + " [T8]";
    }

    public static String nameDank9(DankTech plugin) {
        return "" + ChatColor.RED + plugin.getConfigClass().getStrings().getItemDankPack() + " [★]";
    }

    public static String nameTrash1(DankTech plugin) {
        return "" + ChatColor.GRAY + plugin.getConfigClass().getStrings().getItemTrashPack() + " [T1]";
    }

    public static String nameTrash2(DankTech plugin) {
        return "" + ChatColor.DARK_GRAY + plugin.getConfigClass().getStrings().getItemTrashPack() + " [T2]";
    }

    public static String nameTrash3(DankTech plugin) {
        return "" + ChatColor.GREEN + plugin.getConfigClass().getStrings().getItemTrashPack() + " [T3]";
    }

    public static String nameTrash4(DankTech plugin) {
        return "" + ChatColor.DARK_GREEN + plugin.getConfigClass().getStrings().getItemTrashPack() + " [T4]";
    }

    public static String nameTrash5(DankTech plugin) {
        return "" + ChatColor.BLUE + plugin.getConfigClass().getStrings().getItemTrashPack() + " [T5]";
    }

    public static String nameTrash6(DankTech plugin) {
        return "" + ChatColor.DARK_BLUE + plugin.getConfigClass().getStrings().getItemTrashPack() + " [T6]";
    }

    public static String nameTrash7(DankTech plugin) {
        return "" + ChatColor.LIGHT_PURPLE + plugin.getConfigClass().getStrings().getItemTrashPack() + " [T7]";
    }

    public static String nameTrash8(DankTech plugin) {
        return "" + ChatColor.DARK_PURPLE + plugin.getConfigClass().getStrings().getItemTrashPack() + " [T8]";
    }

    public static String nameTrash9(DankTech plugin) {
        return "" + ChatColor.RED + plugin.getConfigClass().getStrings().getItemTrashPack() + " [★]";
    }

    public static String nameCell1(DankTech plugin) {
        return "" + ChatColor.GRAY + plugin.getConfigClass().getStrings().getItemStorageCell() + " [T1]";
    }

    public static String nameCell2(DankTech plugin) {
        return "" + ChatColor.DARK_GRAY + plugin.getConfigClass().getStrings().getItemStorageCell() + " [T2]";
    }

    public static String nameCell3(DankTech plugin) {
        return "" + ChatColor.GREEN + plugin.getConfigClass().getStrings().getItemStorageCell() + " [T3]";
    }

    public static String nameCell4(DankTech plugin) {
        return "" + ChatColor.DARK_GREEN + plugin.getConfigClass().getStrings().getItemStorageCell() + " [T4]";
    }

    public static String nameCell5(DankTech plugin) {
        return "" + ChatColor.BLUE + plugin.getConfigClass().getStrings().getItemStorageCell() + " [T5]";
    }

    public static String nameCell6(DankTech plugin) {
        return "" + ChatColor.DARK_BLUE + plugin.getConfigClass().getStrings().getItemStorageCell() + " [T6]";
    }

    public static String nameCell7(DankTech plugin) {
        return "" + ChatColor.LIGHT_PURPLE + plugin.getConfigClass().getStrings().getItemStorageCell() + " [T7]";
    }

    public static String nameCell8(DankTech plugin) {
        return "" + ChatColor.DARK_PURPLE + plugin.getConfigClass().getStrings().getItemStorageCell() + " [T8]";
    }

    public static String nameCell9(DankTech plugin) {
        return "" + ChatColor.RED + plugin.getConfigClass().getStrings().getItemStorageCell() + " [★]";
    }

    public static List<String> dankLore(DankTech plugin) {
        return plugin.getConfigClass().getStrings().getItemDankPackLore();
    }

    public static List<String> trashLore(DankTech plugin) {
        return plugin.getConfigClass().getStrings().getItemTrashPackLore();
    }

    public static String dank1Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 1";
    }

    public static String dank2Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 2";
    }

    public static String dank3Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 3";
    }

    public static String dank4Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 4";
    }

    public static String dank5Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 5";
    }

    public static String dank6Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 6";
    }

    public static String dank7Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 7";
    }

    public static String dank8Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 8";
    }

    public static String dank9Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 9";
    }

    public static String trash1Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 2";
    }

    public static String trash2Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 4";
    }

    public static String trash3Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 6";
    }

    public static String trash4Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 8";
    }

    public static String trash5Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 10";
    }

    public static String trash6Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 12";
    }

    public static String trash7Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 14";
    }

    public static String trash8Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 16";
    }

    public static String trash9Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 18";
    }

    public static Integer LIMIT_1(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT1();
    }
    public static Integer LIMIT_2(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT2();
    }
    public static Integer LIMIT_3(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT3();
    }
    public static Integer LIMIT_4(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT4();
    }
    public static Integer LIMIT_5(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT5();
    }
    public static Integer LIMIT_6(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT6();
    }
    public static Integer LIMIT_7(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT7();
    }
    public static Integer LIMIT_8(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT8();
    }
    public static Integer LIMIT_9(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT9();
    }

    public static Integer getLimit(DankTech plugin, int level) {
        switch (level) {
            case 1:
                return LIMIT_1(plugin);
            case 2:
                return LIMIT_2(plugin);
            case 3:
                return LIMIT_3(plugin);
            case 4:
                return LIMIT_4(plugin);
            case 5:
                return LIMIT_5(plugin);
            case 6:
                return LIMIT_6(plugin);
            case 7:
                return LIMIT_7(plugin);
            case 8:
                return LIMIT_8(plugin);
            default:
                return LIMIT_9(plugin);
        }
    }

    public static String DANK_VOLUME_PER_SLOT(DankTech plugin) {
        return plugin.getConfigClass().getStrings().getAmountPerSlot();
    }


    public static String dank1Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT(plugin) + LIMIT_1(plugin);
    }
    public static String dank2Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT(plugin) + LIMIT_2(plugin);
    }
    public static String dank3Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT(plugin) + LIMIT_3(plugin);
    }
    public static String dank4Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT(plugin) + LIMIT_4(plugin);
    }
    public static String dank5Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT(plugin) + LIMIT_5(plugin);
    }
    public static String dank6Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT(plugin) + LIMIT_6(plugin);
    }
    public static String dank7Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT(plugin) + LIMIT_7(plugin);
    }
    public static String dank8Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT(plugin) + LIMIT_8(plugin);
    }
    public static String dank9Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT(plugin) + LIMIT_9(plugin);
    }

    public static String dankLoreVoid(DankTech plugin) {
        return "" + ChatColor.RED + plugin.getConfigClass().getStrings().getVoidInfoDankPack();
    }

    public static String dankTrashVoid(DankTech plugin) {
        return "" + ChatColor.RED + plugin.getConfigClass().getStrings().getVoidInfoTrashPack();
    }

    public static String dankLoreRightClick(DankTech plugin) {
        return "" + ChatColor.GOLD + plugin.getConfigClass().getStrings().getRightClick();
    }

    public static final String DANK_ERROR_STRING = "DANK_ERR";

    public static String dankLoreSelectedStack(@Nullable String stringOptional) {
        String itemType = "" + ChatColor.GRAY + "Empty";
        if (stringOptional != null) {
            itemType = "" + ChatColor.GREEN + stringOptional;
        }
        return "" + ChatColor.GOLD + "Selected Item: " + itemType;
    }

    public static  final String DANK_BUGGY_WARN_USERS_1 = "" + ChatColor.RED + ChatColor.BOLD + "WARNING! While every care has been made";
    public static  final String DANK_BUGGY_WARN_USERS_2 = "" + ChatColor.RED + ChatColor.BOLD + "to make this release stable, it may well";
    public static  final String DANK_BUGGY_WARN_USERS_3 = "" + ChatColor.RED + ChatColor.BOLD + "still have bugs. Please ensure you only";
    public static  final String DANK_BUGGY_WARN_USERS_4 = "" + ChatColor.RED + ChatColor.BOLD + "use this for items you wouldn't cry over";
    public static  final String DANK_BUGGY_WARN_USERS_5 = "" + ChatColor.RED + ChatColor.BOLD + "if lost!";

    public static List<String> dankLoreBuilder(DankTech parent, String slots, String volume, long dankID, @Nullable String selectedStack) {
        List<String> l = new ArrayList<>();
        for (String s : dankLore(parent)) {
            l.add(ChatColor.GRAY + s);
        }
        l.add("");
        l.add(slots);
        l.add(volume);
        l.add("");
        l.add(dankLoreVoid(parent));
        l.add("");
        l.add(dankLoreRightClick(parent));
        l.add("");
        l.add(dankLoreSelectedStack(selectedStack));
        l.add(ChatColor.GRAY + "Pack ID: " + dankID);
        if (BUGS_WARN_USERS) {
            l.add("");
            l.add(DANK_BUGGY_WARN_USERS_1);
            l.add(DANK_BUGGY_WARN_USERS_2);
            l.add(DANK_BUGGY_WARN_USERS_3);
            l.add(DANK_BUGGY_WARN_USERS_4);
            l.add(DANK_BUGGY_WARN_USERS_5);
        }
        return l;
    }

    public static List<String> trashLoreBuilder(DankTech parent, String slots, long dankID) {
        List<String> l = new ArrayList<>();
        for (String s : trashLore(parent)) {
            l.add(ChatColor.GRAY + s);
        }
        l.add("");
        l.add(slots);
        l.add("");
        l.add(dankTrashVoid(parent));
        l.add("");
        l.add(dankLoreRightClick(parent));
        l.add(ChatColor.GRAY + "Pack ID: " + dankID);
        if (BUGS_WARN_USERS) {
            l.add("");
            l.add(DANK_BUGGY_WARN_USERS_1);
            l.add(DANK_BUGGY_WARN_USERS_2);
            l.add(DANK_BUGGY_WARN_USERS_3);
            l.add(DANK_BUGGY_WARN_USERS_4);
            l.add(DANK_BUGGY_WARN_USERS_5);
        }
        return l;
    }

    public static List<String> getDankLore(DankTech parent, int dankLevel, long dankID, @Nullable String selectedStack) {
        switch (dankLevel) {
            case 1: return dankLoreBuilder(parent, dank1Slots(parent), dank1Volume(parent), dankID, selectedStack);
            case 2: return dankLoreBuilder(parent, dank2Slots(parent), dank2Volume(parent), dankID, selectedStack);
            case 3: return dankLoreBuilder(parent, dank3Slots(parent), dank3Volume(parent), dankID, selectedStack);
            case 4: return dankLoreBuilder(parent, dank4Slots(parent), dank4Volume(parent), dankID, selectedStack);
            case 5: return dankLoreBuilder(parent, dank5Slots(parent), dank5Volume(parent), dankID, selectedStack);
            case 6: return dankLoreBuilder(parent, dank6Slots(parent), dank6Volume(parent), dankID, selectedStack);
            case 7: return dankLoreBuilder(parent, dank7Slots(parent), dank7Volume(parent), dankID, selectedStack);
            case 8: return dankLoreBuilder(parent, dank8Slots(parent), dank8Volume(parent), dankID, selectedStack);
            case 9: return dankLoreBuilder(parent, dank9Slots(parent), dank9Volume(parent), dankID, selectedStack);
            default: return dankLoreBuilder(parent, "ERROR", "ERROR", -1, selectedStack);
        }
    }

    public static List<String> getTrashLore(DankTech parent, int dankLevel, long dankID) {
        switch (dankLevel) {
            case 1: return trashLoreBuilder(parent, trash1Slots(parent), dankID);
            case 2: return trashLoreBuilder(parent, trash2Slots(parent), dankID);
            case 3: return trashLoreBuilder(parent, trash3Slots(parent), dankID);
            case 4: return trashLoreBuilder(parent, trash4Slots(parent), dankID);
            case 5: return trashLoreBuilder(parent, trash5Slots(parent), dankID);
            case 6: return trashLoreBuilder(parent, trash6Slots(parent), dankID);
            case 7: return trashLoreBuilder(parent, trash7Slots(parent), dankID);
            case 8: return trashLoreBuilder(parent, trash8Slots(parent), dankID);
            case 9: return trashLoreBuilder(parent, trash9Slots(parent), dankID);
            default: return trashLoreBuilder(parent, "ERROR", -1);
        }
    }

    public static String getDankName(DankTech plugin, int dankLevel) {
        switch (dankLevel) {
            case 1: return nameDank1(plugin);
            case 2: return nameDank2(plugin);
            case 3: return nameDank3(plugin);
            case 4: return nameDank4(plugin);
            case 5: return nameDank5(plugin);
            case 6: return nameDank6(plugin);
            case 7: return nameDank7(plugin);
            case 8: return nameDank8(plugin);
            case 9: return nameDank9(plugin);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getTrashName(DankTech plugin, int trashLevel) {
        switch (trashLevel) {
            case 1: return nameTrash1(plugin);
            case 2: return nameTrash2(plugin);
            case 3: return nameTrash3(plugin);
            case 4: return nameTrash4(plugin);
            case 5: return nameTrash5(plugin);
            case 6: return nameTrash6(plugin);
            case 7: return nameTrash7(plugin);
            case 8: return nameTrash8(plugin);
            case 9: return nameTrash9(plugin);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getDankNameBold(DankTech plugin, int dankLevel) {
        switch (dankLevel) {
            case 1: return ChatColor.BOLD + nameDank1(plugin);
            case 2: return ChatColor.BOLD + nameDank2(plugin);
            case 3: return ChatColor.BOLD + nameDank3(plugin);
            case 4: return ChatColor.BOLD + nameDank4(plugin);
            case 5: return ChatColor.BOLD + nameDank5(plugin);
            case 6: return ChatColor.BOLD + nameDank6(plugin);
            case 7: return ChatColor.BOLD + nameDank7(plugin);
            case 8: return ChatColor.BOLD + nameDank8(plugin);
            case 9: return ChatColor.BOLD + nameDank9(plugin);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getTrashNameBold(DankTech plugin, int trashLevel) {
        switch (trashLevel) {
            case 1: return ChatColor.BOLD + nameTrash1(plugin);
            case 2: return ChatColor.BOLD + nameTrash2(plugin);
            case 3: return ChatColor.BOLD + nameTrash3(plugin);
            case 4: return ChatColor.BOLD + nameTrash4(plugin);
            case 5: return ChatColor.BOLD + nameTrash5(plugin);
            case 6: return ChatColor.BOLD + nameTrash6(plugin);
            case 7: return ChatColor.BOLD + nameTrash7(plugin);
            case 8: return ChatColor.BOLD + nameTrash8(plugin);
            case 9: return ChatColor.BOLD + nameTrash9(plugin);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getDankCellName(DankTech plugin, int dankLevel) {
        switch (dankLevel) {
            case 1: return nameCell1(plugin);
            case 2: return nameCell2(plugin);
            case 3: return nameCell3(plugin);
            case 4: return nameCell4(plugin);
            case 5: return nameCell5(plugin);
            case 6: return nameCell6(plugin);
            case 7: return nameCell7(plugin);
            case 8: return nameCell8(plugin);
            case 9: return nameCell9(plugin);
            default: return DANK_ERROR_STRING;
        }
    }


    // GUI Stuff

    public static String guiDisplayNameFiller(DankTech plugin) {
        return ChatColor.GRAY + plugin.getConfigClass().getStrings().getGuiFiller();
    }
    public static String guiDisplayNameInfo(DankTech plugin) {
        return ChatColor.RED + plugin.getConfigClass().getStrings().getGuiInfoName();
    }
    public static String guiDisplayNameLocked(DankTech plugin) {
        return ChatColor.RED + plugin.getConfigClass().getStrings().getGuiLockedSlot();
    }
    public static List<String> guiDisplayLoreInfo(DankTech plugin, long dankID, int dankLevel) {
        List<String> l = new ArrayList<>();
        l.add("" + ChatColor.GOLD + ChatColor.BOLD + plugin.getConfigClass().getStrings().getGuiInfoLoreId() + ": " + ChatColor.WHITE + dankID);
        l.add("" + ChatColor.GOLD + ChatColor.BOLD + plugin.getConfigClass().getStrings().getGuiInfoLoreLevel() + ": " + ChatColor.WHITE + dankLevel);
        return l;
    }
    public static String guiDisplayNameUnassigned(DankTech plugin) {
        return ChatColor.GRAY + plugin.getConfigClass().getStrings().getGuiUnassignedSlot();
    }
    public static List<String> guiDisplayLoreUnassigned(DankTech plugin) {
        return plugin.getConfigClass().getStrings().getGuiUnassignedSlotLore();
    }

    public static String GUI_DISPLAY_NAME_WITHDRAW(DankTech plugin) {
        return ChatColor.RED + plugin.getConfigClass().getStrings().getGuiInteractDankPackButtonName();
    }
    public static String guiDisplayWithdrawLoreLeft(DankTech plugin) {
        return ChatColor.GOLD + plugin.getConfigClass().getStrings().getGuiInteractLeftClickName() + ": " + ChatColor.WHITE + plugin.getConfigClass().getStrings().getGuiInteractLeftClickPackAction();
    }
    public static String guiDisplayWithdrawLoreRight(DankTech plugin) {
        return ChatColor.GOLD + plugin.getConfigClass().getStrings().getGuiInteractRightClickName() + ": " + ChatColor.WHITE + plugin.getConfigClass().getStrings().getGuiInteractRightClickAction();
    }
    public static String guiDisplayWithdrawLoreShiftLeft(DankTech plugin) {
        return ChatColor.GOLD + plugin.getConfigClass().getStrings().getGuiInteractShiftLeftClickName() + ": " + ChatColor.WHITE + plugin.getConfigClass().getStrings().getGuiInteractShiftLeftClickAction();
    }
    public static String guiDisplayWithdrawLoreShiftRight(DankTech plugin) {
        return ChatColor.GOLD + plugin.getConfigClass().getStrings().getGuiInteractShiftRightClickName() + ": " + ChatColor.WHITE + plugin.getConfigClass().getStrings().getGuiInteractShiftRightClickAction();
    }
    public static String guiDisplayWithdrawLoreDrop(DankTech plugin) {
        return ChatColor.GOLD + plugin.getConfigClass().getStrings().getGuiInteractDropClickName() + ": " + ChatColor.WHITE + plugin.getConfigClass().getStrings().getGuiInteractDropClickAction();
    }

    public static final String GUI_DISPLAY_TRASH_NAME_WITHDRAW = "" + ChatColor.RED + "Remove Item";
    public static final String GUI_DISPLAY_TRASH_LORE_LEFT = "" + ChatColor.GOLD + "Left Click: " + ChatColor.WHITE + "Reset slot";

    public static List<String> guiDisplayLoreWithdraw(DankTech plugin, int amount) {
        List<String> l = new ArrayList<>();
        l.add("");
        l.add(guiDisplayWithdrawLoreLeft(plugin));
        l.add(guiDisplayWithdrawLoreRight(plugin));
        l.add(guiDisplayWithdrawLoreShiftLeft(plugin));
        l.add(guiDisplayWithdrawLoreShiftRight(plugin));
        l.add(guiDisplayWithdrawLoreDrop(plugin));
        l.add("");
        if (amount > 0) {
            l.add("" + ChatColor.BLUE + "Amount: " + ChatColor.WHITE + amount);
        } else {
            l.add("" + ChatColor.BLUE + "Amount: " + ChatColor.GRAY + "Empty");
        }
        return l;
    }

    public static List<String> guiDisplayLoreTrash() {
        List<String> l = new ArrayList<>();
        l.add("");
        l.add(GUI_DISPLAY_TRASH_LORE_LEFT);
        return l;
    }

    public static final String SLIMEFUN_DISPLAY_CATEGORY_NAME = "" + ChatColor.YELLOW + "DankTech";

}
