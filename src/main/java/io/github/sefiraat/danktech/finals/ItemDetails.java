package io.github.sefiraat.danktech.finals;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

import static io.github.sefiraat.danktech.finals.Debug.bugsWarnUsers;

public final class ItemDetails {

    // Dank Stuff

    public static final String NameDank1 = "" + ChatColor.GRAY + "Dank Storage Pack [T1]";
    public static final String NameDank2 = "" + ChatColor.DARK_GRAY + "Dank Storage Pack [T2]";
    public static final String NameDank3 = "" + ChatColor.GREEN + "Dank Storage Pack [T3]";
    public static final String NameDank4 = "" + ChatColor.DARK_GREEN + "Dank Storage Pack [T4]";
    public static final String NameDank5 = "" + ChatColor.BLUE + "Dank Storage Pack [T5]";
    public static final String NameDank6 = "" + ChatColor.DARK_BLUE + "Dank Storage Pack [T6]";
    public static final String NameDank7 = "" + ChatColor.LIGHT_PURPLE + "Dank Storage Pack [T7]";
    public static final String NameDank8 = "" + ChatColor.DARK_PURPLE + "Dank Storage Pack [T8]";
    public static final String NameDank9 = "" + ChatColor.RED + "Dank Storage Pack [Master]";

    public static final String NameDankCell1 = "" + ChatColor.GRAY + "Storage Cell [T1]";
    public static final String NameDankCell2 = "" + ChatColor.DARK_GRAY + "Storage Cell [T2]";
    public static final String NameDankCell3 = "" + ChatColor.GREEN + "Storage Cell [T3]";
    public static final String NameDankCell4 = "" + ChatColor.DARK_GREEN + "Storage Cell [T4]";
    public static final String NameDankCell5 = "" + ChatColor.BLUE + "Storage Cell [T5]";
    public static final String NameDankCell6 = "" + ChatColor.DARK_BLUE + "Storage Cell [T6]";
    public static final String NameDankCell7 = "" + ChatColor.LIGHT_PURPLE + "Storage Cell [T7]";
    public static final String NameDankCell8 = "" + ChatColor.DARK_PURPLE + "Storage Cell [T8]";
    public static final String NameDankCell9 = "" + ChatColor.RED + "Storage Cell [Master]";

    public static final String DankInfo1 = ChatColor.GRAY + "A dimension folded into a single point of";
    public static final String DankInfo2 = ChatColor.GRAY + "space and time. All this just to hold";
    public static final String DankInfo3 = ChatColor.GRAY + "your trash!";

    public static final String Dank1_Slots = "" + ChatColor.WHITE + "Slots: 1";
    public static final String Dank2_Slots = "" + ChatColor.WHITE + "Slots: 2";
    public static final String Dank3_Slots = "" + ChatColor.WHITE + "Slots: 3";
    public static final String Dank4_Slots = "" + ChatColor.WHITE + "Slots: 4";
    public static final String Dank5_Slots = "" + ChatColor.WHITE + "Slots: 5";
    public static final String Dank6_Slots = "" + ChatColor.WHITE + "Slots: 6";
    public static final String Dank7_Slots = "" + ChatColor.WHITE + "Slots: 7";
    public static final String Dank8_Slots = "" + ChatColor.WHITE + "Slots: 8";
    public static final String Dank9_Slots = "" + ChatColor.WHITE + "Slots: 9";

    public static final Integer Limit1 = 256;
    public static final Integer Limit2 = 1024;
    public static final Integer Limit3 = 2048;
    public static final Integer Limit4 = 4096;
    public static final Integer Limit5 = 8192;
    public static final Integer Limit6 = 16384;
    public static final Integer Limit7 = 65536;
    public static final Integer Limit8 = 524288;
    public static final Integer Limit9 = 2147483547;

    public static Integer getLimit(int level) {
        switch(level) {
            case 1: return Limit1;
            case 2: return Limit2;
            case 3: return Limit3;
            case 4: return Limit4;
            case 5: return Limit5;
            case 6: return Limit6;
            case 7: return Limit7;
            case 8: return Limit8;
            default: return Limit9;
        }
    }

    public static final String Dank1_Volume = "" + ChatColor.WHITE + "Volume per slot: " + Limit1;
    public static final String Dank2_Volume = "" + ChatColor.WHITE + "Volume per slot: " + Limit2;
    public static final String Dank3_Volume = "" + ChatColor.WHITE + "Volume per slot: " + Limit3;
    public static final String Dank4_Volume = "" + ChatColor.WHITE + "Volume per slot: " + Limit4;
    public static final String Dank5_Volume = "" + ChatColor.WHITE + "Volume per slot: " + Limit5;
    public static final String Dank6_Volume = "" + ChatColor.WHITE + "Volume per slot: " + Limit6;
    public static final String Dank7_Volume = "" + ChatColor.WHITE + "Volume per slot: " + Limit7;
    public static final String Dank8_Volume = "" + ChatColor.WHITE + "Volume per slot: " + Limit8;
    public static final String Dank9_Volume = "" + ChatColor.WHITE + "Volume per slot: " + Limit9;

    public static final String DankLoreVoid = "" + ChatColor.RED + "Items over limit are voided";
    public static final String DankLoreRightClick = "" + ChatColor.GOLD + "Right click to open pack";

    public static  final String DankBuggyWarnUsers1 = "" + ChatColor.RED + ChatColor.BOLD + "Warning! While every care has been made";
    public static  final String DankBuggyWarnUsers2 = "" + ChatColor.RED + ChatColor.BOLD + "to make this release stable, it may well";
    public static  final String DankBuggyWarnUsers3 = "" + ChatColor.RED + ChatColor.BOLD + "still have bugs. Please ensure you only";
    public static  final String DankBuggyWarnUsers4 = "" + ChatColor.RED + ChatColor.BOLD + "use this for items you wouldn't cry over";
    public static  final String DankBuggyWarnUsers5 = "" + ChatColor.RED + ChatColor.BOLD + "if lost!";

    public static List<String> DankLoreBuilder(String slots, String volume, long dankID) {
        List<String> l = new ArrayList<>();
        l.add(DankInfo1);
        l.add(DankInfo2);
        l.add(DankInfo3);
        l.add("");
        l.add(slots);
        l.add(volume);
        l.add("");
        l.add(DankLoreVoid);
        l.add("");
        l.add(DankLoreRightClick);
        l.add("");
        l.add(ChatColor.GRAY + "Pack ID: " + dankID);
        if (bugsWarnUsers) {
            l.add("");
            l.add(DankBuggyWarnUsers1);
            l.add(DankBuggyWarnUsers2);
            l.add(DankBuggyWarnUsers3);
            l.add(DankBuggyWarnUsers4);
            l.add(DankBuggyWarnUsers5);
        }
        return l;
    }

    public static List<String> getDankLore(int DankLevel, long dankID) {
        switch (DankLevel) {
            case 1: return DankLoreBuilder(Dank1_Slots, Dank1_Volume, dankID);
            case 2: return DankLoreBuilder(Dank2_Slots, Dank2_Volume, dankID);
            case 3: return DankLoreBuilder(Dank3_Slots, Dank3_Volume, dankID);
            case 4: return DankLoreBuilder(Dank4_Slots, Dank4_Volume, dankID);
            case 5: return DankLoreBuilder(Dank5_Slots, Dank5_Volume, dankID);
            case 6: return DankLoreBuilder(Dank6_Slots, Dank6_Volume, dankID);
            case 7: return DankLoreBuilder(Dank7_Slots, Dank7_Volume, dankID);
            case 8: return DankLoreBuilder(Dank8_Slots, Dank8_Volume, dankID);
            case 9: return DankLoreBuilder(Dank9_Slots, Dank9_Volume, dankID);
            default: return DankLoreBuilder("ERROR", "ERROR", -1);
        }
    }

    public static String getDankName(int DankLevel) {
        switch (DankLevel) {
            case 1: return NameDank1;
            case 2: return NameDank2;
            case 3: return NameDank3;
            case 4: return NameDank4;
            case 5: return NameDank5;
            case 6: return NameDank6;
            case 7: return NameDank7;
            case 8: return NameDank8;
            case 9: return NameDank9;
            default: return "Error";
        }
    }

    public static String getDankNameBold(int DankLevel) {
        switch (DankLevel) {
            case 1: return ChatColor.BOLD + NameDank1;
            case 2: return ChatColor.BOLD + NameDank2;
            case 3: return ChatColor.BOLD + NameDank3;
            case 4: return ChatColor.BOLD + NameDank4;
            case 5: return ChatColor.BOLD + NameDank5;
            case 6: return ChatColor.BOLD + NameDank6;
            case 7: return ChatColor.BOLD + NameDank7;
            case 8: return ChatColor.BOLD + NameDank8;
            case 9: return ChatColor.BOLD + NameDank9;
            default: return "Error";
        }
    }

    public static String getDankCellName(int DankLevel) {
        switch (DankLevel) {
            case 1: return NameDankCell1;
            case 2: return NameDankCell2;
            case 3: return NameDankCell3;
            case 4: return NameDankCell4;
            case 5: return NameDankCell5;
            case 6: return NameDankCell6;
            case 7: return NameDankCell7;
            case 8: return NameDankCell8;
            case 9: return NameDankCell9;
            default: return "Error";
        }
    }


    // GUI Stuff

    public static final String GUIDisplayNameFiller = "" + ChatColor.GRAY + "Get Dank";
    public static final String GUIDisplayNameInfo = "" + ChatColor.RED + "Pack Info";
    public static final String GUIDisplayNameLocked = "" + ChatColor.RED + "Locked Slot";
    public static List<String> GUIDisplayLoreInfo(long DankID, int DankLevel) {
        List<String> l = new ArrayList<>();
        l.add("" + ChatColor.GOLD + ChatColor.BOLD + "Dank ID: " + ChatColor.WHITE + DankID);
        l.add("" + ChatColor.GOLD + ChatColor.BOLD + "Dank Tier: " + ChatColor.WHITE + DankLevel);
        return l;
    }
    public static final String GUIDisplayNameUnassigned = "" + ChatColor.GRAY + "Unassigned Slot";
    public static List<String> GUIDisplayLoreUnassigned() {
        List<String> l = new ArrayList<>();
        l.add("" + ChatColor.WHITE + "Slot unassigned, place an item below");
        l.add("" + ChatColor.WHITE + "to assign that type to this slot.");
        return l;
    }

    public static final String GUIDisplayNameWithdraw = "" + ChatColor.RED + "Withdraw / Add Items";

    public static final String GUIDisplayWithdrawLoreLeft = "" + ChatColor.GOLD + "Left Click: " + ChatColor.WHITE + "Withdraw 1";
    public static final String GUIDisplayWithdrawLoreRight = "" + ChatColor.GOLD + "Right Click: " + ChatColor.WHITE + "Withdraw Stack";
    public static final String GUIDisplayWithdrawLoreShiftLeft = "" + ChatColor.GOLD + "Shift Left Click: " + ChatColor.WHITE + "Dump Inventory";
    public static final String GUIDisplayWithdrawLoreShiftRight = "" + ChatColor.GOLD + "Shift Right Click: " + ChatColor.WHITE + "Fill Inventory";

    public static List<String> GUIDisplayLoreWithdraw(int amount) {
        List<String> l = new ArrayList<>();
        l.add("");
        l.add(GUIDisplayWithdrawLoreLeft);
        l.add(GUIDisplayWithdrawLoreRight);
        l.add(GUIDisplayWithdrawLoreShiftLeft);
        l.add(GUIDisplayWithdrawLoreShiftRight);
        l.add("");
        if (amount > 0) {
            l.add("" + ChatColor.BLUE + "Amount: " + ChatColor.WHITE + amount);
        } else {
            l.add("" + ChatColor.BLUE + "Amount: " + ChatColor.GRAY + "Empty");
        }
        return l;
    }
}
