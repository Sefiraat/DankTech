package io.github.sefiraat.danktech.finals;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

public final class ItemDetails {
    public static final String NameDank1 = "" + ChatColor.GRAY + ChatColor.BOLD + "Dank Storage Pack [T1]";
    public static final String NameDank2 = "" + ChatColor.DARK_GRAY + ChatColor.BOLD + "Dank Storage Pack [T2]";
    public static final String NameDank3 = "" + ChatColor.GREEN + ChatColor.BOLD + "Dank Storage Pack [T3]";
    public static final String NameDank4 = "" + ChatColor.DARK_GREEN + ChatColor.BOLD + "Dank Storage Pack [T4]";
    public static final String NameDank5 = "" + ChatColor.BLUE + ChatColor.BOLD + "Dank Storage Pack [T5]";
    public static final String NameDank6 = "" + ChatColor.DARK_BLUE + ChatColor.BOLD + "Dank Storage Pack [T6]";
    public static final String NameDank7 = "" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Dank Storage Pack [T7]";
    public static final String NameDank8 = "" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Dank Storage Pack [T8]";
    public static final String NameDank9 = "" + ChatColor.RED + ChatColor.BOLD + "Dank Storage Pack [Master]";

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

    public static final String Dank1_Volume = "" + ChatColor.WHITE + "Volume per slot: 256";
    public static final String Dank2_Volume = "" + ChatColor.WHITE + "Volume per slot: 1,024";
    public static final String Dank3_Volume = "" + ChatColor.WHITE + "Volume per slot: 2,048";
    public static final String Dank4_Volume = "" + ChatColor.WHITE + "Volume per slot: 4,096";
    public static final String Dank5_Volume = "" + ChatColor.WHITE + "Volume per slot: 8,192";
    public static final String Dank6_Volume = "" + ChatColor.WHITE + "Volume per slot: 16,384";
    public static final String Dank7_Volume = "" + ChatColor.WHITE + "Volume per slot: 65,536";
    public static final String Dank8_Volume = "" + ChatColor.WHITE + "Volume per slot: 524,288";
    public static final String Dank9_Volume = "" + ChatColor.WHITE + "Volume per slot: 2,147,483,647";

    public static final String DankLoreRightClick = "" + ChatColor.GOLD + "Right click to open pack";

    public static List<String> DankLoreBuilder(String slots, String volume) {
        List<String> l = new ArrayList<>();
        l.add(DankInfo1);
        l.add(DankInfo2);
        l.add(DankInfo3);
        l.add("");
        l.add(slots);
        l.add(volume);
        l.add("");
        l.add(DankLoreRightClick);
        return l;
    }

    public static final List<String> getDankLore(int DankLevel) {
        switch (DankLevel) {
            case 1: return DankLoreBuilder(Dank1_Slots, Dank1_Volume);
            case 2: return DankLoreBuilder(Dank2_Slots, Dank2_Volume);
            case 3: return DankLoreBuilder(Dank3_Slots, Dank3_Volume);
            case 4: return DankLoreBuilder(Dank4_Slots, Dank4_Volume);
            case 5: return DankLoreBuilder(Dank5_Slots, Dank5_Volume);
            case 6: return DankLoreBuilder(Dank6_Slots, Dank6_Volume);
            case 7: return DankLoreBuilder(Dank7_Slots, Dank7_Volume);
            case 8: return DankLoreBuilder(Dank8_Slots, Dank8_Volume);
            case 9: return DankLoreBuilder(Dank9_Slots, Dank9_Volume);
            default: return DankLoreBuilder("ERROR", "ERROR");
        }
    }

    public static final String getDankName(int DankLevel) {
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
}
