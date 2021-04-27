package io.github.sefiraat.danktech.finals;

import net.md_5.bungee.api.ChatColor;

public final class Messages {

    // General
    public static final String Prefix = "" + ChatColor.GRAY + "[DankTech] ";
    public static final String Suffix = "" + ChatColor.GRAY + "";

    public static final String Warning = "" + ChatColor.YELLOW;
    public static final String Error = "" + ChatColor.RED;
    public static final String Notice = "" + ChatColor.WHITE;
    public static final String Passive = "" + ChatColor.GRAY;
    public static final String Success = "" + ChatColor.GREEN;


    // Commands
    public static final String MessageCommandSubcommand = Prefix + Notice + "Please select a valid sub command";
    public static final String MessageCommandSelectItem = Prefix + Notice + "Please select a valid sub command";
    public static final String MessageCommandPackNoExist = Prefix + Error + "Yeah, bags only go from 1 to 9 dummy :)";

    public static String MessageCommandPackGiven(long packID) {
        return (Prefix + Success + "Pack created. ID: " + packID);
    }

    // Events
    public static String MessageEventOpenPack(long packID) {
        return (Prefix + Passive + "Opening Dank Pack. ID: " + packID);
    }
    public static final String MessageEventInputExisting = Prefix + Warning + "Slot is already assigned. Empty slot to replace.";
    public static final String MessageEventInputThisDank = Prefix + Warning + "You cannot put a Dank inside itself silly!";
    public static final String MessageEventWithdrawNoSpace = Prefix + Warning + "You need an empty inventory slot!";
    public static final String MessageEventWithdrawNoVolume = Prefix + Warning + "Nothing to withdraw";

    // Crafting
    public static final String MessageCraftNewPack = Prefix + Success + "You have crafted a new Dank Pack!";
    public static final String MessageCraftUpgradePack = Prefix + Success + "You have upgraded a Dank Pack!";
}
