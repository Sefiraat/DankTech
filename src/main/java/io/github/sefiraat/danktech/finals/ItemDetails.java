package io.github.sefiraat.danktech.finals;

import io.github.sefiraat.danktech.DankTech;
import net.md_5.bungee.api.ChatColor;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

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

    private static String getNameDank(Integer level) {
        if (level.equals(9)) {
            return getRarity(level) + DankTech.getInstance().getConfigClass().getStrings().getItemDankPack() + " [★]";
        } else {
            return getRarity(level) + DankTech.getInstance().getConfigClass().getStrings().getItemDankPack() + " [T" + level + "]";
        }
    }

    private static String getNameTrash(Integer level) {
        if (level.equals(9)) {
            return getRarity(level) + DankTech.getInstance().getConfigClass().getStrings().getItemTrashPack() + " [★]";
        } else {
            return getRarity(level) + DankTech.getInstance().getConfigClass().getStrings().getItemTrashPack() + " [T" + level + "]";
        }
    }

    private static String getNameCell(Integer level) {
        if (level.equals(9)) {
            return getRarity(level) + DankTech.getInstance().getConfigClass().getStrings().getItemStorageCell() + " [★]";
        } else {
            return getRarity(level) + DankTech.getInstance().getConfigClass().getStrings().getItemStorageCell() + " [T" + level + "]";
        }
    }

    public static String getDankName(int dankLevel) {
        switch (dankLevel) {
            case 1: return getNameDank(1);
            case 2: return getNameDank(2);
            case 3: return getNameDank(3);
            case 4: return getNameDank(4);
            case 5: return getNameDank(5);
            case 6: return getNameDank(6);
            case 7: return getNameDank(7);
            case 8: return getNameDank(8);
            case 9: return getNameDank(9);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getTrashName(int trashLevel) {
        switch (trashLevel) {
            case 1: return getNameTrash(1);
            case 2: return getNameTrash(2);
            case 3: return getNameTrash(3);
            case 4: return getNameTrash(4);
            case 5: return getNameTrash(5);
            case 6: return getNameTrash(6);
            case 7: return getNameTrash(7);
            case 8: return getNameTrash(8);
            case 9: return getNameTrash(9);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getDankNameBold(int dankLevel) {
        switch (dankLevel) {
            case 1: return ChatColor.BOLD + getNameDank(1);
            case 2: return ChatColor.BOLD + getNameDank(2);
            case 3: return ChatColor.BOLD + getNameDank(3);
            case 4: return ChatColor.BOLD + getNameDank(4);
            case 5: return ChatColor.BOLD + getNameDank(5);
            case 6: return ChatColor.BOLD + getNameDank(6);
            case 7: return ChatColor.BOLD + getNameDank(7);
            case 8: return ChatColor.BOLD + getNameDank(8);
            case 9: return ChatColor.BOLD + getNameDank(9);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getTrashNameBold(int trashLevel) {
        switch (trashLevel) {
            case 1: return ChatColor.BOLD + getNameTrash(1);
            case 2: return ChatColor.BOLD + getNameTrash(2);
            case 3: return ChatColor.BOLD + getNameTrash(3);
            case 4: return ChatColor.BOLD + getNameTrash(4);
            case 5: return ChatColor.BOLD + getNameTrash(5);
            case 6: return ChatColor.BOLD + getNameTrash(6);
            case 7: return ChatColor.BOLD + getNameTrash(7);
            case 8: return ChatColor.BOLD + getNameTrash(8);
            case 9: return ChatColor.BOLD + getNameTrash(9);
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getDankCellName(int dankLevel) {
        switch (dankLevel) {
            case 1: return getNameCell(1);
            case 2: return getNameCell(2);
            case 3: return getNameCell(3);
            case 4: return getNameCell(4);
            case 5: return getNameCell(5);
            case 6: return getNameCell(6);
            case 7: return getNameCell(7);
            case 8: return getNameCell(8);
            case 9: return getNameCell(9);
            default: return DANK_ERROR_STRING;
        }
    }

    private static List<String> dankLore() {
        return DankTech.getInstance().getConfigClass().getStrings().getItemDankPackLore();
    }

    private static List<String> trashLore() {
        return DankTech.getInstance().getConfigClass().getStrings().getItemTrashPackLore();
    }

    private static String dank1Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 1";
    }
    private static String dank2Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 2";
    }
    private static String dank3Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 3";
    }
    private static String dank4Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 4";
    }
    private static String dank5Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 5";
    }
    private static String dank6Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 6";
    }
    private static String dank7Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 7";
    }
    private static String dank8Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 8";
    }
    private static String dank9Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 9";
    }

    private static String trash1Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 2";
    }
    private static String trash2Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 4";
    }
    private static String trash3Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 6";
    }
    private static String trash4Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 8";
    }
    private static String trash5Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 10";
    }
    private static String trash6Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 12";
    }
    private static String trash7Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 14";
    }
    private static String trash8Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 16";
    }
    private static String trash9Slots() {
        return "" + ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getSlots() + ": 18";
    }

    private static Integer limit1() {
        return DankTech.getInstance().getConfigClass().getVals().getValuePerSlotT1();
    }
    private static Integer limit2() {
        return DankTech.getInstance().getConfigClass().getVals().getValuePerSlotT2();
    }
    private static Integer limit3() {
        return DankTech.getInstance().getConfigClass().getVals().getValuePerSlotT3();
    }
    private static Integer limit4() {
        return DankTech.getInstance().getConfigClass().getVals().getValuePerSlotT4();
    }
    private static Integer limit5() {
        return DankTech.getInstance().getConfigClass().getVals().getValuePerSlotT5();
    }
    private static Integer limit6() {
        return DankTech.getInstance().getConfigClass().getVals().getValuePerSlotT6();
    }
    private static Integer limit7() {
        return DankTech.getInstance().getConfigClass().getVals().getValuePerSlotT7();
    }
    private static Integer limit8() {
        return DankTech.getInstance().getConfigClass().getVals().getValuePerSlotT8();
    }
    private static Integer limit9() {
        return DankTech.getInstance().getConfigClass().getVals().getValuePerSlotT9();
    }

    public static Integer getLimit(int level) {
        switch (level) {
            case 1:
                return limit1();
            case 2:
                return limit2();
            case 3:
                return limit3();
            case 4:
                return limit4();
            case 5:
                return limit5();
            case 6:
                return limit6();
            case 7:
                return limit7();
            case 8:
                return limit8();
            default:
                return limit9();
        }
    }

    private static String dankVolumePerSlot() {
        return DankTech.getInstance().getConfigClass().getStrings().getAmountPerSlot();
    }

    private static String dank1Volume() {
        return "" + ChatColor.WHITE + dankVolumePerSlot() + ": " + limit1();
    }
    private static String dank2Volume() {
        return "" + ChatColor.WHITE + dankVolumePerSlot() + ": " + limit2();
    }
    private static String dank3Volume() {
        return "" + ChatColor.WHITE + dankVolumePerSlot() + ": " + limit3();
    }
    private static String dank4Volume() {
        return "" + ChatColor.WHITE + dankVolumePerSlot() + ": " + limit4();
    }
    private static String dank5Volume() {
        return "" + ChatColor.WHITE + dankVolumePerSlot() + ": " + limit5();
    }
    private static String dank6Volume() {
        return "" + ChatColor.WHITE + dankVolumePerSlot() + ": " + limit6();
    }
    private static String dank7Volume() {
        return "" + ChatColor.WHITE + dankVolumePerSlot() + ": " + limit7();
    }
    private static String dank8Volume() {
        return "" + ChatColor.WHITE + dankVolumePerSlot() + ": " + limit8();
    }
    private static String dank9Volume() {
        return "" + ChatColor.WHITE + dankVolumePerSlot() + ": " + limit9();
    }

    private static String dankLoreVoid() {
        return "" + ChatColor.RED + DankTech.getInstance().getConfigClass().getStrings().getVoidInfoDankPack();
    }

    private static String dankTrashVoid() {
        return "" + ChatColor.RED + DankTech.getInstance().getConfigClass().getStrings().getVoidInfoTrashPack();
    }

    private static String dankLoreRightClick() {
        return "" + ChatColor.GOLD + DankTech.getInstance().getConfigClass().getStrings().getRightClick();
    }

    private static final String DANK_ERROR_STRING = "DANK_ERR";

    private static String dankLoreSelectedStack(@Nullable String stringOptional) {
        String itemType = "" + ChatColor.GRAY + "Empty";
        if (stringOptional != null) {
            itemType = "" + ChatColor.GREEN + stringOptional;
        }
        return "" + ChatColor.GOLD + "Selected Item: " + itemType;
    }

    private static List<String> dankLoreBuilder(String slots, String volume, long dankID, @Nullable String selectedStack) {
        List<String> l = new ArrayList<>();
        for (String s : dankLore()) {
            l.add(ChatColor.GRAY + s);
        }
        l.add("");
        l.add(slots);
        l.add(volume);
        l.add("");
        l.add(dankLoreVoid());
        l.add("");
        l.add(dankLoreRightClick());
        l.add("");
        l.add(dankLoreSelectedStack(selectedStack));
        l.add(ChatColor.GRAY + DankTech.getInstance().getConfigClass().getStrings().getGuiInfoLoreId() + ": " + dankID);
        return l;
    }

    private static List<String> trashLoreBuilder(String slots, long dankID) {
        List<String> l = new ArrayList<>();
        for (String s : trashLore()) {
            l.add(ChatColor.GRAY + s);
        }
        l.add("");
        l.add(slots);
        l.add("");
        l.add(dankTrashVoid());
        l.add("");
        l.add(dankLoreRightClick());
        l.add(ChatColor.GRAY + "Pack ID: " + dankID);
        return l;
    }

    public static List<String> getDankLore(int dankLevel, long dankID, @Nullable String selectedStack) {
        switch (dankLevel) {
            case 1: return dankLoreBuilder(dank1Slots(), dank1Volume(), dankID, selectedStack);
            case 2: return dankLoreBuilder(dank2Slots(), dank2Volume(), dankID, selectedStack);
            case 3: return dankLoreBuilder(dank3Slots(), dank3Volume(), dankID, selectedStack);
            case 4: return dankLoreBuilder(dank4Slots(), dank4Volume(), dankID, selectedStack);
            case 5: return dankLoreBuilder(dank5Slots(), dank5Volume(), dankID, selectedStack);
            case 6: return dankLoreBuilder(dank6Slots(), dank6Volume(), dankID, selectedStack);
            case 7: return dankLoreBuilder(dank7Slots(), dank7Volume(), dankID, selectedStack);
            case 8: return dankLoreBuilder(dank8Slots(), dank8Volume(), dankID, selectedStack);
            case 9: return dankLoreBuilder(dank9Slots(), dank9Volume(), dankID, selectedStack);
            default: return dankLoreBuilder("ERROR", "ERROR", -1, selectedStack);
        }
    }

    public static List<String> getTrashLore(int dankLevel, long dankID) {
        switch (dankLevel) {
            case 1: return trashLoreBuilder(trash1Slots(), dankID);
            case 2: return trashLoreBuilder(trash2Slots(), dankID);
            case 3: return trashLoreBuilder(trash3Slots(), dankID);
            case 4: return trashLoreBuilder(trash4Slots(), dankID);
            case 5: return trashLoreBuilder(trash5Slots(), dankID);
            case 6: return trashLoreBuilder(trash6Slots(), dankID);
            case 7: return trashLoreBuilder(trash7Slots(), dankID);
            case 8: return trashLoreBuilder(trash8Slots(), dankID);
            case 9: return trashLoreBuilder(trash9Slots(), dankID);
            default: return trashLoreBuilder("ERROR", -1);
        }
    }

    // GUI Stuff

    public static String guiDisplayNameFiller() {
        return ChatColor.GRAY + DankTech.getInstance().getConfigClass().getStrings().getGuiFiller();
    }
    public static String guiDisplayNameInfo() {
        return ChatColor.RED + DankTech.getInstance().getConfigClass().getStrings().getGuiInfoName();
    }
    public static String guiDisplayNameLocked() {
        return ChatColor.RED + DankTech.getInstance().getConfigClass().getStrings().getGuiLockedSlot();
    }
    public static List<String> guiDisplayLoreInfo(long dankID, int dankLevel) {
        List<String> l = new ArrayList<>();
        l.add("" + ChatColor.GOLD + ChatColor.BOLD + DankTech.getInstance().getConfigClass().getStrings().getGuiInfoLoreId() + ": " + ChatColor.WHITE + dankID);
        l.add("" + ChatColor.GOLD + ChatColor.BOLD + DankTech.getInstance().getConfigClass().getStrings().getGuiInfoLoreLevel() + ": " + ChatColor.WHITE + dankLevel);
        return l;
    }
    public static String guiDisplayNameUnassigned() {
        return ChatColor.GRAY + DankTech.getInstance().getConfigClass().getStrings().getGuiUnassignedSlot();
    }
    public static List<String> guiDisplayLoreUnassigned() {
        return DankTech.getInstance().getConfigClass().getStrings().getGuiUnassignedSlotLore();
    }

    public static String guiDisplayNameWithdraw() {
        return ChatColor.RED + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractDankPackButtonName();
    }
    public static String guiDisplayWithdrawLoreLeft() {
        return ChatColor.GOLD + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractLeftClickName() +
                ": " +
                ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractLeftClickPackAction();
    }
    public static String guiDisplayWithdrawLoreRight() {
        return ChatColor.GOLD + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractRightClickName() +
                ": " +
                ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractRightClickAction();
    }
    public static String guiDisplayWithdrawLoreShiftLeft() {
        return ChatColor.GOLD + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractShiftLeftClickName() +
                ": " +
                ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractShiftLeftClickAction();
    }
    public static String guiDisplayWithdrawLoreShiftRight() {
        return ChatColor.GOLD + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractShiftRightClickName() +
                ": " +
                ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractShiftRightClickAction();
    }
    public static String guiDisplayWithdrawLoreDrop() {
        return ChatColor.GOLD + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractDropClickName() +
                ": " +
                ChatColor.WHITE + DankTech.getInstance().getConfigClass().getStrings().getGuiInteractDropClickAction();
    }

    public static final String GUI_DISPLAY_TRASH_NAME_WITHDRAW = "" + ChatColor.RED + "Remove Item";
    public static final String GUI_DISPLAY_TRASH_LORE_LEFT = "" + ChatColor.GOLD + "Left Click: " + ChatColor.WHITE + "Reset slot";

    public static List<String> guiDisplayLoreWithdraw(int amount) {
        List<String> l = new ArrayList<>();
        l.add("");
        l.add(guiDisplayWithdrawLoreLeft());
        l.add(guiDisplayWithdrawLoreRight());
        l.add(guiDisplayWithdrawLoreShiftLeft());
        l.add(guiDisplayWithdrawLoreShiftRight());
        l.add(guiDisplayWithdrawLoreDrop());
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
