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
    public static String messageCommandSubcommand(DankTech plugin) {
        return PREFIX + NOTICE + plugin.getConfigClass().getStrings().getCommandSubcommand();
    }
    public static String messageCommandSelectItem(DankTech plugin) {
        return PREFIX + NOTICE + plugin.getConfigClass().getStrings().getCommandSelectItem();
    }
    public static String messageCommandPackDoesNotExist(DankTech plugin) {
        return PREFIX + ERROR + plugin.getConfigClass().getStrings().getCommandPackDoesNotExist();
    }
    public static String messageCommandBlacklistItemSaved(DankTech plugin) {
        return PREFIX + SUCCESS + plugin.getConfigClass().getStrings().getCommandBlacklistItemAdded();
    }
    public static String messageCommandBlacklistMustHold(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getCommandBlacklistMustHold();
    }
    public static String messageCommandPackGiven(DankTech plugin, long packID) {
        return (PREFIX + SUCCESS + plugin.getConfigClass().getStrings().getCommandDankPackGiven() + ID + packID);
    }
    public static String messageCommandTrashGiven(DankTech plugin, long trashID) {
        return (PREFIX + SUCCESS + plugin.getConfigClass().getStrings().getCommandTrashPackGiven() + ID + trashID);
    }
    public static String messageCommandPackUpdated(DankTech plugin, long packID) {
        return (PREFIX + WARNING + plugin.getConfigClass().getStrings().getCommandPackUpdated() + ID + packID);
    }

    // Events
    public static String messageEventOpenPack(DankTech plugin, long packID) {
        return (PREFIX + PASSIVE + plugin.getConfigClass().getStrings().getEventOpenDank() + ID + packID);
    }
    public static String messageEventOpenTrash(DankTech plugin, long trashID) {
        return (PREFIX + PASSIVE + plugin.getConfigClass().getStrings().getEventOpenTrash() + ID + trashID);
    }
    public static String messageEventInputExisting(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getEventInputExisting();
    }
    public static String messageEventInputThisDank(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getEventInputThisDank();
    }
    public static String messageEventInputBlacklisted(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getEventInputBlacklisted();
    }
    public static String messageEventWithdrawNoSpace(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getEventWithdrawNoSpace();
    }
    public static String messageEventSlotNotAssigned(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getEventSlotNotAssigned();
    }
    public static String messageEventSlotCantPlace(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getEventSlotCantPlace();
    }
    public static String messageEventSlotNoMoreItems(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getEventSlotNoMoreItems();
    }
    public static String messageEventSlotChanged(DankTech plugin, String s, Integer slot) {
         return PREFIX + SUCCESS + plugin.getConfigClass().getStrings().getEventSlotChanged() + " [" + slot + "] : " + ChatColor.GOLD + s;
    }

    // Crafting
    public static String messageCraftNewPack(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getCraftNewPack();
    }
    public static String messageCraftUpgradePack(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getCraftUpgradePack();
    }
    public static String messageCraftNewTrash(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getCraftNewTrash();
    }
    public static String messageCraftUpgradeTrash(DankTech plugin) {
        return PREFIX + WARNING + plugin.getConfigClass().getStrings().getCraftUpgradeTrash();
    }
}
