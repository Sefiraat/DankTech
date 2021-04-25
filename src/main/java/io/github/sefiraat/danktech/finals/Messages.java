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
    public static final String MessageCommandPackGiven(long packID) {
        return (Prefix + Success + "Pack created. ID: " + packID);
    }

    // Events
    public static final String MessageEventOpenPack(long packID) {
        return (Prefix + Passive + "Opening Dank Pack. ID: " + packID);
    }
}
