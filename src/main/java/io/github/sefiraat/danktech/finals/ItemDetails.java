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

    private static ChatColor getRarity(int level) {
        switch (level) {
            case 1: return ChatColor.GRAY;
            case 2: return ChatColor.DARK_GRAY;
            case 3: return ChatColor.GREEN;
            case 4: return ChatColor.DARK_GREEN;
            case 5: return ChatColor.BLUE;
            case 6: return ChatColor.DARK_BLUE;
            case 7: return ChatColor.LIGHT_PURPLE;
            case 8: return ChatColor.DARK_PURPLE;
            default: return ChatColor.RED;
        }
    }

    private static String getNameDank(DankTech plugin, int level) {
        if (level == 9) {
            return getRarity(level) + plugin.getConfigClass().getStrings().getItemDankPack() + " [★]";
        } else {
            return getRarity(level) + plugin.getConfigClass().getStrings().getItemDankPack() + " [T" + level + "]";
        }
    }

    private static String getNameTrash(DankTech plugin, int level) {
        if (level == 9) {
            return getRarity(level) + plugin.getConfigClass().getStrings().getItemTrashPack() + " [★]";
        } else {
            return getRarity(level) + plugin.getConfigClass().getStrings().getItemTrashPack() + " [T" + level + "]";
        }
    }

    private static String getNameCell(DankTech plugin, int level) {
        if (level == 9) {
            return getRarity(level) + plugin.getConfigClass().getStrings().getItemStorageCell() + " [★]";
        } else {
            return getRarity(level) + plugin.getConfigClass().getStrings().getItemStorageCell() + " [T" + level + "]";
        }
    }

    public static String getDankName(DankTech plugin, int dankLevel) {
        switch (dankLevel) {
            case 1: return getNameDank(plugin, 1);
            case 2: return getNameDank(plugin, 2);
            case 3: return getNameDank(plugin, 3);
            case 4: return getNameDank(plugin, 4);
            case 5: return getNameDank(plugin, 5);
            case 6: return getNameDank(plugin, 6);
            case 7: return getNameDank(plugin, 7);
            case 8: return getNameDank(plugin, 8);
            case 9: return getNameDank(plugin, 9);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getTrashName(DankTech plugin, int trashLevel) {
        switch (trashLevel) {
            case 1: return getNameTrash(plugin,1);
            case 2: return getNameTrash(plugin,2);
            case 3: return getNameTrash(plugin,3);
            case 4: return getNameTrash(plugin,4);
            case 5: return getNameTrash(plugin,5);
            case 6: return getNameTrash(plugin,6);
            case 7: return getNameTrash(plugin,7);
            case 8: return getNameTrash(plugin,8);
            case 9: return getNameTrash(plugin,9);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getDankNameBold(DankTech plugin, int dankLevel) {
        switch (dankLevel) {
            case 1: return ChatColor.BOLD + getNameDank(plugin, 1);
            case 2: return ChatColor.BOLD + getNameDank(plugin, 2);
            case 3: return ChatColor.BOLD + getNameDank(plugin, 3);
            case 4: return ChatColor.BOLD + getNameDank(plugin, 4);
            case 5: return ChatColor.BOLD + getNameDank(plugin, 5);
            case 6: return ChatColor.BOLD + getNameDank(plugin, 6);
            case 7: return ChatColor.BOLD + getNameDank(plugin, 7);
            case 8: return ChatColor.BOLD + getNameDank(plugin, 8);
            case 9: return ChatColor.BOLD + getNameDank(plugin, 9);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getTrashNameBold(DankTech plugin, int trashLevel) {
        switch (trashLevel) {
            case 1: return ChatColor.BOLD + getNameTrash(plugin,1);
            case 2: return ChatColor.BOLD + getNameTrash(plugin,2);
            case 3: return ChatColor.BOLD + getNameTrash(plugin,3);
            case 4: return ChatColor.BOLD + getNameTrash(plugin,4);
            case 5: return ChatColor.BOLD + getNameTrash(plugin,5);
            case 6: return ChatColor.BOLD + getNameTrash(plugin,6);
            case 7: return ChatColor.BOLD + getNameTrash(plugin,7);
            case 8: return ChatColor.BOLD + getNameTrash(plugin,8);
            case 9: return ChatColor.BOLD + getNameTrash(plugin,9);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getDankCellName(DankTech plugin, int dankLevel) {
        switch (dankLevel) {
            case 1: return getNameCell(plugin,1);
            case 2: return getNameCell(plugin,2);
            case 3: return getNameCell(plugin,3);
            case 4: return getNameCell(plugin,4);
            case 5: return getNameCell(plugin,5);
            case 6: return getNameCell(plugin,6);
            case 7: return getNameCell(plugin,7);
            case 8: return getNameCell(plugin,8);
            case 9: return getNameCell(plugin,9);
            default: return DANK_ERROR_STRING;
        }
    }

    private static List<String> dankLore(DankTech plugin) {
        return plugin.getConfigClass().getStrings().getItemDankPackLore();
    }

    private static List<String> trashLore(DankTech plugin) {
        return plugin.getConfigClass().getStrings().getItemTrashPackLore();
    }

    private static String dank1Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 1";
    }
    private static String dank2Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 2";
    }
    private static String dank3Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 3";
    }
    private static String dank4Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 4";
    }
    private static String dank5Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 5";
    }
    private static String dank6Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 6";
    }
    private static String dank7Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 7";
    }
    private static String dank8Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 8";
    }
    private static String dank9Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 9";
    }

    private static String trash1Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 2";
    }
    private static String trash2Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 4";
    }
    private static String trash3Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 6";
    }
    private static String trash4Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 8";
    }
    private static String trash5Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 10";
    }
    private static String trash6Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 12";
    }
    private static String trash7Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 14";
    }
    private static String trash8Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 16";
    }
    private static String trash9Slots(DankTech plugin) {
        return "" + ChatColor.WHITE + plugin.getConfigClass().getStrings().getSlots() + ": 18";
    }

    private static Integer limit1(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT1();
    }
    private static Integer limit2(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT2();
    }
    private static Integer limit3(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT3();
    }
    private static Integer limit4(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT4();
    }
    private static Integer limit5(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT5();
    }
    private static Integer limit6(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT6();
    }
    private static Integer limit7(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT7();
    }
    private static Integer limit8(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT8();
    }
    private static Integer limit9(DankTech plugin) {
        return plugin.getConfigClass().getVals().getValuePerSlotT9();
    }

    public static Integer getLimit(DankTech plugin, int level) {
        switch (level) {
            case 1:
                return limit1(plugin);
            case 2:
                return limit2(plugin);
            case 3:
                return limit3(plugin);
            case 4:
                return limit4(plugin);
            case 5:
                return limit5(plugin);
            case 6:
                return limit6(plugin);
            case 7:
                return limit7(plugin);
            case 8:
                return limit8(plugin);
            default:
                return limit9(plugin);
        }
    }

    private static String dankVolumePerSlot(DankTech plugin) {
        return plugin.getConfigClass().getStrings().getAmountPerSlot();
    }

    private static String dank1Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + dankVolumePerSlot(plugin) + limit1(plugin);
    }
    private static String dank2Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + dankVolumePerSlot(plugin) + limit2(plugin);
    }
    private static String dank3Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + dankVolumePerSlot(plugin) + limit3(plugin);
    }
    private static String dank4Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + dankVolumePerSlot(plugin) + limit4(plugin);
    }
    private static String dank5Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + dankVolumePerSlot(plugin) + limit5(plugin);
    }
    private static String dank6Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + dankVolumePerSlot(plugin) + limit6(plugin);
    }
    private static String dank7Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + dankVolumePerSlot(plugin) + limit7(plugin);
    }
    private static String dank8Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + dankVolumePerSlot(plugin) + limit8(plugin);
    }
    private static String dank9Volume(DankTech plugin) {
        return "" + ChatColor.WHITE + dankVolumePerSlot(plugin) + limit9(plugin);
    }

    private static String dankLoreVoid(DankTech plugin) {
        return "" + ChatColor.RED + plugin.getConfigClass().getStrings().getVoidInfoDankPack();
    }

    private static String dankTrashVoid(DankTech plugin) {
        return "" + ChatColor.RED + plugin.getConfigClass().getStrings().getVoidInfoTrashPack();
    }

    private static String dankLoreRightClick(DankTech plugin) {
        return "" + ChatColor.GOLD + plugin.getConfigClass().getStrings().getRightClick();
    }

    private static final String DANK_ERROR_STRING = "DANK_ERR";

    private static String dankLoreSelectedStack(@Nullable String stringOptional) {
        String itemType = "" + ChatColor.GRAY + "Empty";
        if (stringOptional != null) {
            itemType = "" + ChatColor.GREEN + stringOptional;
        }
        return "" + ChatColor.GOLD + "Selected Item: " + itemType;
    }

    private static final String DANK_BUGGY_WARN_USERS_1 = "" + ChatColor.RED + ChatColor.BOLD + "WARNING! While every care has been made";
    private static final String DANK_BUGGY_WARN_USERS_2 = "" + ChatColor.RED + ChatColor.BOLD + "to make this release stable, it may well";
    private static final String DANK_BUGGY_WARN_USERS_3 = "" + ChatColor.RED + ChatColor.BOLD + "still have bugs. Please ensure you only";
    private static final String DANK_BUGGY_WARN_USERS_4 = "" + ChatColor.RED + ChatColor.BOLD + "use this for items you wouldn't cry over";
    private static final String DANK_BUGGY_WARN_USERS_5 = "" + ChatColor.RED + ChatColor.BOLD + "if lost!";

    private static List<String> dankLoreBuilder(DankTech parent, String slots, String volume, long dankID, @Nullable String selectedStack) {
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
        l.add(ChatColor.GRAY + parent.getConfigClass().getStrings().getGuiInfoLoreId() + ": " + dankID);
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

    private static List<String> trashLoreBuilder(DankTech parent, String slots, long dankID) {
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

    public static String guiDisplayNameWithdraw(DankTech plugin) {
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
