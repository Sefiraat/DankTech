package io.github.sefiraat.danktech.finals;

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

    public static final String NAME_DANK_1 = "" + ChatColor.GRAY + "Dank Storage Pack [T1]";
    public static final String NAME_DANK_2 = "" + ChatColor.DARK_GRAY + "Dank Storage Pack [T2]";
    public static final String NAME_DANK_3 = "" + ChatColor.GREEN + "Dank Storage Pack [T3]";
    public static final String NAME_DANK_4 = "" + ChatColor.DARK_GREEN + "Dank Storage Pack [T4]";
    public static final String NAME_DANK_5 = "" + ChatColor.BLUE + "Dank Storage Pack [T5]";
    public static final String NAME_DANK_6 = "" + ChatColor.DARK_BLUE + "Dank Storage Pack [T6]";
    public static final String NAME_DANK_7 = "" + ChatColor.LIGHT_PURPLE + "Dank Storage Pack [T7]";
    public static final String NAME_DANK_8 = "" + ChatColor.DARK_PURPLE + "Dank Storage Pack [T8]";
    public static final String NAME_DANK_9 = "" + ChatColor.RED + "Dank Storage Pack [Master]";

    public static final String NAME_DANK_CELL_1 = "" + ChatColor.GRAY + "Storage Cell [T1]";
    public static final String NAME_DANK_CELL_2 = "" + ChatColor.DARK_GRAY + "Storage Cell [T2]";
    public static final String NAME_DANK_CELL_3 = "" + ChatColor.GREEN + "Storage Cell [T3]";
    public static final String NAME_DANK_CELL_4 = "" + ChatColor.DARK_GREEN + "Storage Cell [T4]";
    public static final String NAME_DANK_CELL_5 = "" + ChatColor.BLUE + "Storage Cell [T5]";
    public static final String NAME_DANK_CELL_6 = "" + ChatColor.DARK_BLUE + "Storage Cell [T6]";
    public static final String NAME_DANK_CELL_7 = "" + ChatColor.LIGHT_PURPLE + "Storage Cell [T7]";
    public static final String NAME_DANK_CELL_8 = "" + ChatColor.DARK_PURPLE + "Storage Cell [T8]";
    public static final String NAME_DANK_CELL_9 = "" + ChatColor.RED + "Storage Cell [Master]";

    public static final String DANK_INFO_1 = ChatColor.GRAY + "A dimension folded into a single point of";
    public static final String DANK_INFO_2 = ChatColor.GRAY + "space and time. All this just to hold";
    public static final String DANK_INFO_3 = ChatColor.GRAY + "your trash!";

    public static final String DANK_1_SLOTS = "" + ChatColor.WHITE + "Slots: 1";
    public static final String DANK_2_SLOTS = "" + ChatColor.WHITE + "Slots: 2";
    public static final String DANK_3_SLOTS = "" + ChatColor.WHITE + "Slots: 3";
    public static final String DANK_4_SLOTS = "" + ChatColor.WHITE + "Slots: 4";
    public static final String DANK_5_SLOTS = "" + ChatColor.WHITE + "Slots: 5";
    public static final String DANK_6_SLOTS = "" + ChatColor.WHITE + "Slots: 6";
    public static final String DANK_7_SLOTS = "" + ChatColor.WHITE + "Slots: 7";
    public static final String DANK_8_SLOTS = "" + ChatColor.WHITE + "Slots: 8";
    public static final String DANK_9_SLOTS = "" + ChatColor.WHITE + "Slots: 9";

    public static final Integer LIMIT_1 = 256;
    public static final Integer LIMIT_2 = 1024;
    public static final Integer LIMIT_3 = 2048;
    public static final Integer LIMIT_4 = 4096;
    public static final Integer LIMIT_5 = 8192;
    public static final Integer LIMIT_6 = 16384;
    public static final Integer LIMIT_7 = 65536;
    public static final Integer LIMIT_8 = 524288;
    public static final Integer LIMIT_9 = 2147483547;
    public static final Integer LIMIT_TRASH = 1;

    public static Integer getLimit(int level) {
        switch(level) {
            case 1: return LIMIT_1;
            case 2: return LIMIT_2;
            case 3: return LIMIT_3;
            case 4: return LIMIT_4;
            case 5: return LIMIT_5;
            case 6: return LIMIT_6;
            case 7: return LIMIT_7;
            case 8: return LIMIT_8;
            default: return LIMIT_9;
        }
    }

    public static final String DANK_VOLUME_PER_SLOT = "Volume per slot: ";

    public static final String DANK_1_VOLUME = "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT + LIMIT_1;
    public static final String DANK_2_VOLUME = "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT + LIMIT_2;
    public static final String DANK_3_VOLUME = "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT + LIMIT_3;
    public static final String DANK_4_VOLUME = "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT + LIMIT_4;
    public static final String DANK_5_VOLUME = "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT + LIMIT_5;
    public static final String DANK_6_VOLUME = "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT + LIMIT_6;
    public static final String DANK_7_VOLUME = "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT + LIMIT_7;
    public static final String DANK_8_VOLUME = "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT + LIMIT_8;
    public static final String DANK_9_VOLUME = "" + ChatColor.WHITE + DANK_VOLUME_PER_SLOT + LIMIT_9;

    public static final String DANK_LORE_VOID = "" + ChatColor.RED + "Items over limit are voided";
    public static final String DANK_LORE_RIGHT_CLICK = "" + ChatColor.GOLD + "Right click to open pack";

    public static final String DANK_ERROR_STRING = "DANK_ERR";

    public static final String dankLoreSelectedStack(@Nullable String stringOptional) {
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

    public static List<String> dankLoreBuilder(String slots, String volume, long dankID, @Nullable String selectedStack) {
        List<String> l = new ArrayList<>();
        l.add(DANK_INFO_1);
        l.add(DANK_INFO_2);
        l.add(DANK_INFO_3);
        l.add("");
        l.add(slots);
        l.add(volume);
        l.add("");
        l.add(DANK_LORE_VOID);
        l.add("");
        l.add(DANK_LORE_RIGHT_CLICK);
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

    public static List<String> getDankLore(int dankLevel, long dankID, @Nullable String selectedStack) {
        switch (dankLevel) {
            case 1: return dankLoreBuilder(DANK_1_SLOTS, DANK_1_VOLUME, dankID, selectedStack);
            case 2: return dankLoreBuilder(DANK_2_SLOTS, DANK_2_VOLUME, dankID, selectedStack);
            case 3: return dankLoreBuilder(DANK_3_SLOTS, DANK_3_VOLUME, dankID, selectedStack);
            case 4: return dankLoreBuilder(DANK_4_SLOTS, DANK_4_VOLUME, dankID, selectedStack);
            case 5: return dankLoreBuilder(DANK_5_SLOTS, DANK_5_VOLUME, dankID, selectedStack);
            case 6: return dankLoreBuilder(DANK_6_SLOTS, DANK_6_VOLUME, dankID, selectedStack);
            case 7: return dankLoreBuilder(DANK_7_SLOTS, DANK_7_VOLUME, dankID, selectedStack);
            case 8: return dankLoreBuilder(DANK_8_SLOTS, DANK_8_VOLUME, dankID, selectedStack);
            case 9: return dankLoreBuilder(DANK_9_SLOTS, DANK_9_VOLUME, dankID, selectedStack);
            default: return dankLoreBuilder("ERROR", "ERROR", -1, selectedStack);
        }
    }

    public static String getDankName(int dankLevel) {
        switch (dankLevel) {
            case 1: return NAME_DANK_1;
            case 2: return NAME_DANK_2;
            case 3: return NAME_DANK_3;
            case 4: return NAME_DANK_4;
            case 5: return NAME_DANK_5;
            case 6: return NAME_DANK_6;
            case 7: return NAME_DANK_7;
            case 8: return NAME_DANK_8;
            case 9: return NAME_DANK_9;
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getDankNameBold(int dankLevel) {
        switch (dankLevel) {
            case 1: return ChatColor.BOLD + NAME_DANK_1;
            case 2: return ChatColor.BOLD + NAME_DANK_2;
            case 3: return ChatColor.BOLD + NAME_DANK_3;
            case 4: return ChatColor.BOLD + NAME_DANK_4;
            case 5: return ChatColor.BOLD + NAME_DANK_5;
            case 6: return ChatColor.BOLD + NAME_DANK_6;
            case 7: return ChatColor.BOLD + NAME_DANK_7;
            case 8: return ChatColor.BOLD + NAME_DANK_8;
            case 9: return ChatColor.BOLD + NAME_DANK_9;
            default: return DANK_ERROR_STRING;
        }
    }

    public static String getDankCellName(int dankLevel) {
        switch (dankLevel) {
            case 1: return NAME_DANK_CELL_1;
            case 2: return NAME_DANK_CELL_2;
            case 3: return NAME_DANK_CELL_3;
            case 4: return NAME_DANK_CELL_4;
            case 5: return NAME_DANK_CELL_5;
            case 6: return NAME_DANK_CELL_6;
            case 7: return NAME_DANK_CELL_7;
            case 8: return NAME_DANK_CELL_8;
            case 9: return NAME_DANK_CELL_9;
            default: return DANK_ERROR_STRING;
        }
    }


    // GUI Stuff

    public static final String GUI_DISPLAY_NAME_FILLER = "" + ChatColor.GRAY + "Get Dank";
    public static final String GUI_DISPLAY_NAME_INFO = "" + ChatColor.RED + "Pack Info";
    public static final String GUI_DISPLAY_NAME_LOCKED = "" + ChatColor.RED + "Locked Slot";
    public static List<String> guiDisplayLoreInfo(long dankID, int dankLevel) {
        List<String> l = new ArrayList<>();
        l.add("" + ChatColor.GOLD + ChatColor.BOLD + "Dank ID: " + ChatColor.WHITE + dankID);
        l.add("" + ChatColor.GOLD + ChatColor.BOLD + "Dank Tier: " + ChatColor.WHITE + dankLevel);
        return l;
    }
    public static final String GUI_DISPLAY_NAME_UNASSIGNED = "" + ChatColor.GRAY + "Unassigned Slot";
    public static List<String> guiDisplayLoreUnassigned() {
        List<String> l = new ArrayList<>();
        l.add("" + ChatColor.WHITE + "Slot unassigned, place an item below");
        l.add("" + ChatColor.WHITE + "to assign that type to this slot.");
        return l;
    }

    public static final String GUI_DISPLAY_NAME_WITHDRAW = "" + ChatColor.RED + "Withdraw / Add Items";

    public static final String GUI_DISPLAY_WITHDRAW_LORE_LEFT = "" + ChatColor.GOLD + "Left Click: " + ChatColor.WHITE + "Withdraw 1";
    public static final String GUI_DISPLAY_WITHDRAW_LORE_RIGHT = "" + ChatColor.GOLD + "Right Click: " + ChatColor.WHITE + "Withdraw Stack";
    public static final String GUI_DISPLAY_WITHDRAW_LORE_SHIFT_LEFT = "" + ChatColor.GOLD + "Shift Left Click: " + ChatColor.WHITE + "Dump Inventory";
    public static final String GUI_DISPLAY_WITHDRAW_LORE_SHIFT_RIGHT = "" + ChatColor.GOLD + "Shift Right Click: " + ChatColor.WHITE + "Fill Inventory";
    public static final String GUI_DISPLAY_WITHDRAW_LORE_DROP = "" + ChatColor.GOLD + "Drop (Q): " + ChatColor.WHITE + "Drop a stack";
    public static final String GUI_DISPLAY_TRASH_LORE_LEFT = "" + ChatColor.GOLD + "Left Click: " + ChatColor.WHITE + "Reset slot";

    public static List<String> guiDisplayLoreWithdraw(int amount) {
        List<String> l = new ArrayList<>();
        l.add("");
        l.add(GUI_DISPLAY_WITHDRAW_LORE_LEFT);
        l.add(GUI_DISPLAY_WITHDRAW_LORE_RIGHT);
        l.add(GUI_DISPLAY_WITHDRAW_LORE_SHIFT_LEFT);
        l.add(GUI_DISPLAY_WITHDRAW_LORE_SHIFT_RIGHT);
        l.add(GUI_DISPLAY_WITHDRAW_LORE_DROP);
        l.add("");
        if (amount > 0) {
            l.add("" + ChatColor.BLUE + "Amount: " + ChatColor.WHITE + amount);
        } else {
            l.add("" + ChatColor.BLUE + "Amount: " + ChatColor.GRAY + "Empty");
        }
        return l;
    }

    public static List<String> guiDisplayLoreTrash(int amount) {
        List<String> l = new ArrayList<>();
        l.add("");
        l.add(GUI_DISPLAY_TRASH_LORE_LEFT);
        l.add("");
        if (amount > 0) {
            l.add("" + ChatColor.BLUE + "Amount: " + ChatColor.WHITE + amount);
        } else {
            l.add("" + ChatColor.BLUE + "Amount: " + ChatColor.GRAY + "Empty");
        }
        return l;
    }

    public static final String SLIMEFUN_DISPLAY_CATEGORY_NAME = "" + ChatColor.YELLOW + "DankTech";

}
