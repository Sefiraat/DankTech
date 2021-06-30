package io.github.sefiraat.danktech.finals;

import io.github.sefiraat.danktech.DankTech;
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

    public static final String ID = " - ID: ";

    // Commands
    public static String messageCommandSubcommand() {
        return PREFIX + NOTICE + DankTech.getInstance().getConfigClass().getStrings().getCommandSubcommand();
    }
    public static String messageCommandSelectItem() {
        return PREFIX + NOTICE + DankTech.getInstance().getConfigClass().getStrings().getCommandSelectItem();
    }
    public static String messageCommandPackDoesNotExist() {
        return PREFIX + ERROR + DankTech.getInstance().getConfigClass().getStrings().getCommandPackDoesNotExist();
    }
    public static String messageCommandBlacklistItemSaved() {
        return PREFIX + SUCCESS + DankTech.getInstance().getConfigClass().getStrings().getCommandBlacklistItemAdded();
    }
    public static String messageCommandBlacklistMustHold() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getCommandBlacklistMustHold();
    }
    public static String messageCommandPackGiven(long packID) {
        return (PREFIX + SUCCESS + DankTech.getInstance().getConfigClass().getStrings().getCommandDankPackGiven() + ID + packID);
    }
    public static String messageCommandTrashGiven(long trashID) {
        return (PREFIX + SUCCESS + DankTech.getInstance().getConfigClass().getStrings().getCommandTrashPackGiven() + ID + trashID);
    }
    public static String messageCommandPackUpdated(long packID) {
        return (PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getCommandPackUpdated() + ID + packID);
    }

    // Events
    public static String messageEventOpenPack(long packID) {
        return (PREFIX + PASSIVE + DankTech.getInstance().getConfigClass().getStrings().getEventOpenDank() + ID + packID);
    }
    public static String messageEventOpenTrash(long trashID) {
        return (PREFIX + PASSIVE + DankTech.getInstance().getConfigClass().getStrings().getEventOpenTrash() + ID + trashID);
    }
    public static String messageEventInputExisting() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getEventInputExisting();
    }
    public static String messageEventInputThisDank() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getEventInputThisDank();
    }
    public static String messageEventInputBlacklisted() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getEventInputBlacklisted();
    }
    public static String messageEventWithdrawNoSpace() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getEventWithdrawNoSpace();
    }
    public static String messageEventSlotNotAssigned() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getEventSlotNotAssigned();
    }
    public static String messageEventSlotCantPlace() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getEventSlotCantPlace();
    }
    public static String messageEventSlotNoMoreItems() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getEventSlotNoMoreItems();
    }
    public static String messageEventSlotChanged(String s, Integer slot) {
         return PREFIX + SUCCESS + DankTech.getInstance().getConfigClass().getStrings().getEventSlotChanged() + " [" + slot + "] : " + ChatColor.GOLD + s;
    }

    // Crafting
    public static String messageCraftNewPack() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getCraftNewPack();
    }
    public static String messageCraftUpgradePack() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getCraftUpgradePack();
    }
    public static String messageCraftNewTrash() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getCraftNewTrash();
    }
    public static String messageCraftUpgradeTrash() {
        return PREFIX + WARNING + DankTech.getInstance().getConfigClass().getStrings().getCraftUpgradeTrash();
    }
}
