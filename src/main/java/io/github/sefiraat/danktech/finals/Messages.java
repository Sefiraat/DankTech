package io.github.sefiraat.danktech.finals;

import net.md_5.bungee.api.ChatColor;

public final class Messages {

    private Messages() {
        throw new IllegalStateException("Utility class");
    }

    // General
    public static final String PREFIX = "" + ChatColor.GRAY + "[DankTech] ";
    public static final String SUFFIX = "" + ChatColor.GRAY + "";

    public static final String WARNING = "" + ChatColor.YELLOW;
    public static final String ERROR = "" + ChatColor.RED;
    public static final String NOTICE = "" + ChatColor.WHITE;
    public static final String PASSIVE = "" + ChatColor.GRAY;
    public static final String SUCCESS = "" + ChatColor.GREEN;


    // Commands
    public static final String MESSAGE_COMMAND_SUBCOMMAND = PREFIX + NOTICE + "Please select a valid sub command";
    public static final String MESSAGE_COMMAND_SELECT_ITEM = PREFIX + NOTICE + "Please select an item type";
    public static final String MESSAGE_COMMAND_PACK_NO_EXIST = PREFIX + ERROR + "Yeah, packs only go from 1 to 9 dummy :)";

    public static String messageCommandPackGiven(long packID) {
        return (PREFIX + SUCCESS + "Dank Pack created. ID: " + packID);
    }

    public static String messageCommandTrashGiven(long trashID) {
        return (PREFIX + SUCCESS + "Trash Pack created. ID: " + trashID);
    }

    public static String messageCommandPackUpdated(long packID) {
        return (PREFIX + WARNING + "This pack is old or incorrectly made! Updating to the correct format. ID: " + packID);
    }

    // Events
    public static String messageEventOpenPack(long packID) {
        return (PREFIX + PASSIVE + "Opening Dank Pack. ID: " + packID);
    }
    public static String messageEventOpenTrash(long trashID) {
        return (PREFIX + PASSIVE + "Opening Dank Trash. ID: " + trashID);
    }
    public static final String MESSAGE_EVENT_INPUT_EXISTING = PREFIX + WARNING + "Slot is already assigned.";
    public static final String MESSAGE_EVENT_INPUT_THIS_DANK = PREFIX + WARNING + "You cannot put a Dank inside itself silly!";
    public static final String MESSAGE_EVENT_WITHDRAW_NO_SPACE = PREFIX + WARNING + "You need an empty inventory slot!";
    public static final String MESSAGE_EVENT_SLOT_NOT_ASSIGNED = PREFIX + WARNING + "No item registered";
    public static final String MESSAGE_EVENT_SLOT_CANT_PLACE = PREFIX + ERROR + "The selected item can't be placed via a Dank";
    public static final String MESSAGE_EVENT_SLOT_NO_MORE_ITEMS = PREFIX + WARNING + "The selected item has run out!";

    public static final String messageEventSlotChanged(String s, Integer slot) {
         return PREFIX + SUCCESS + "Selected Slot [" + slot + "] : " + ChatColor.GOLD + s;
    }

    // Crafting
    public static final String MESSAGE_CRAFT_NEW_PACK = PREFIX + SUCCESS + "You have crafted a new Dank Pack";
    public static final String MESSAGE_CRAFT_UPGRADE_PACK = PREFIX + SUCCESS + "You have upgraded a Dank Pack";
    public static final String MESSAGE_CRAFT_NEW_TRASH = PREFIX + SUCCESS + "You have crafted a new Dank Trash Can";
    public static final String MESSAGE_CRAFT_UPGRADE_TRASH = PREFIX + SUCCESS + "You have upgraded a Dank Trash Can";
}
