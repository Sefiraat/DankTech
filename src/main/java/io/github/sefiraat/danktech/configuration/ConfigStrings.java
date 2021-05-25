package io.github.sefiraat.danktech.configuration;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ConfigStrings {

    // GUI

    private final String guiFiller;
    private final String guiInfoName;
    private final String guiInfoLoreId;
    private final String guiInfoLoreLevel;
    private final String guiLockedSlot;
    private final String guiUnassignedSlot;
    private final List<String> guiUnassignedSlotLore;
    private final String guiInteractDankPackButtonName;
    private final String guiInteractTrashPackButtonName;
    private final String guiInteractLeftClickName;
    private final String guiInteractLeftClickPackAction;
    private final String guiInteractLeftClickTrashAction;
    private final String guiInteractRightClickName;
    private final String guiInteractRightClickAction;
    private final String guiInteractShiftLeftClickName;
    private final String guiInteractShiftLeftClickAction;
    private final String guiInteractShiftRightClickName;
    private final String guiInteractShiftRightClickAction;
    private final String guiInteractDropClickName;
    private final String guiInteractDropClickAction;

    public String getGuiFiller() {
        return guiFiller;
    }
    public String getGuiInfoName() {
        return guiInfoName;
    }
    public String getGuiInfoLoreId() {
        return guiInfoLoreId;
    }
    public String getGuiInfoLoreLevel() {
        return guiInfoLoreLevel;
    }
    public String getGuiLockedSlot() {
        return guiLockedSlot;
    }
    public String getGuiUnassignedSlot() {
        return guiUnassignedSlot;
    }
    public List<String> getGuiUnassignedSlotLore() {
        return guiUnassignedSlotLore;
    }
    public String getGuiInteractDankPackButtonName() {
        return guiInteractDankPackButtonName;
    }
    public String getGuiInteractTrashPackButtonName() {
        return guiInteractTrashPackButtonName;
    }
    public String getGuiInteractLeftClickName() {
        return guiInteractLeftClickName;
    }
    public String getGuiInteractLeftClickPackAction() {
        return guiInteractLeftClickPackAction;
    }
    public String getGuiInteractLeftClickTrashAction() {
        return guiInteractLeftClickTrashAction;
    }
    public String getGuiInteractRightClickName() {
        return guiInteractRightClickName;
    }
    public String getGuiInteractRightClickAction() {
        return guiInteractRightClickAction;
    }
    public String getGuiInteractShiftLeftClickName() {
        return guiInteractShiftLeftClickName;
    }
    public String getGuiInteractShiftLeftClickAction() {
        return guiInteractShiftLeftClickAction;
    }
    public String getGuiInteractShiftRightClickName() {
        return guiInteractShiftRightClickName;
    }
    public String getGuiInteractShiftRightClickAction() {
        return guiInteractShiftRightClickAction;
    }
    public String getGuiInteractDropClickName() {
        return guiInteractDropClickName;
    }
    public String getGuiInteractDropClickAction() {
        return guiInteractDropClickAction;
    }

    // Item Details

    private final String itemDankPack;
    private final String itemTrashPack;
    private final String itemStorageCell;
    private final List<String> itemDankPackLore;
    private final List<String> itemTrashPackLore;
    private final String slots;
    private final String amountPerSlot;
    private final String voidInfoDankPack;
    private final String voidInfoTrashPack;
    private final String rightClick;

    public String getItemDankPack() {
        return itemDankPack;
    }
    public String getItemTrashPack() {
        return itemTrashPack;
    }
    public String getItemStorageCell() {
        return itemStorageCell;
    }
    public List<String> getItemDankPackLore() {
        return itemDankPackLore;
    }
    public List<String> getItemTrashPackLore() {
        return itemTrashPackLore;
    }
    public String getSlots() {
        return slots;
    }
    public String getAmountPerSlot() {
        return amountPerSlot;
    }
    public String getVoidInfoDankPack() {
        return voidInfoDankPack;
    }
    public String getVoidInfoTrashPack() {
        return voidInfoTrashPack;
    }
    public String getRightClick() {
        return rightClick;
    }

// Messages - Commands

    private final String commandSubcommand;
    private final String commandSelectItem;
    private final String commandPackDoesNotExist;
    private final String commandDankPackGiven;
    private final String commandTrashPackGiven;
    private final String commandPackUpdated;
    private final String commandBlacklistItemAdded;
    private final String commandBlacklistMustHold;

    public String getCommandSubcommand() {
        return commandSubcommand;
    }
    public String getCommandSelectItem() {
        return commandSelectItem;
    }
    public String getCommandPackDoesNotExist() {
        return commandPackDoesNotExist;
    }
    public String getCommandDankPackGiven() {
        return commandDankPackGiven;
    }
    public String getCommandTrashPackGiven() {
        return commandTrashPackGiven;
    }
    public String getCommandPackUpdated() {
        return commandPackUpdated;
    }
    public String getCommandBlacklistItemAdded() {
        return commandBlacklistItemAdded;
    }
    public String getCommandBlacklistMustHold() {
        return commandBlacklistMustHold;
    }

    // Messages - Events

    private final String eventOpenDank;
    private final String eventOpenTrash;
    private final String eventInputExisting;
    private final String eventInputThisDank;
    private final String eventInputBlacklisted;
    private final String eventWithdrawNoSpace;
    private final String eventSlotNotAssigned;
    private final String eventSlotCantPlace;
    private final String eventSlotNoMoreItems;
    private final String eventSlotChanged;

    public String getEventOpenDank() {
        return eventOpenDank;
    }
    public String getEventOpenTrash() {
        return eventOpenTrash;
    }
    public String getEventInputExisting() {
        return eventInputExisting;
    }
    public String getEventInputThisDank() {
        return eventInputThisDank;
    }
    public String getEventInputBlacklisted() {
        return eventInputBlacklisted;
    }
    public String getEventWithdrawNoSpace() {
        return eventWithdrawNoSpace;
    }
    public String getEventSlotNotAssigned() {
        return eventSlotNotAssigned;
    }
    public String getEventSlotCantPlace() {
        return eventSlotCantPlace;
    }
    public String getEventSlotNoMoreItems() {
        return eventSlotNoMoreItems;
    }
    public String getEventSlotChanged() {
        return eventSlotChanged;
    }

    // Messages - Crafting

    private final String craftNewPack;
    private final String craftUpgradePack;
    private final String craftNewTrash;
    private final String craftUpgradeTrash;

    public String getCraftNewPack() {
        return craftNewPack;
    }
    public String getCraftUpgradePack() {
        return craftUpgradePack;
    }
    public String getCraftNewTrash() {
        return craftNewTrash;
    }
    public String getCraftUpgradeTrash() {
        return craftUpgradeTrash;
    }

    public ConfigStrings(DankTech parent) {

        FileConfiguration c = parent.getConfig();

        guiFiller = c.getString("TEXTS.GUI.PANE_FILLER");
        guiInfoName = c.getString("TEXTS.GUI.PANE_INFO_NAME");
        guiInfoLoreId = c.getString("TEXTS.GUI.PANE_INFO_LORE_ID");
        guiInfoLoreLevel = c.getString("TEXTS.GUI.PANE_INFO_LORE_LEVEL");
        guiLockedSlot = c.getString("TEXTS.GUI.LOCKED_SLOT");
        guiUnassignedSlot = c.getString("TEXTS.GUI.UNASSIGNED_SLOT");
        guiUnassignedSlotLore = c.getStringList("TEXTS.GUI.UNASSIGNED_SLOT_LORE");
        guiInteractDankPackButtonName = c.getString("TEXTS.GUI.INTERACT_DANK_PACK_BUTTON_NAME");
        guiInteractTrashPackButtonName = c.getString("TEXTS.GUI.INTERACT_TRASH_PACK_BUTTON_NAME");
        guiInteractLeftClickName = c.getString("TEXTS.GUI.INTERACT_LEFT_CLICK_NAME");
        guiInteractLeftClickPackAction = c.getString("TEXTS.GUI.INTERACT_LEFT_CLICK_PACK_ACTION");
        guiInteractLeftClickTrashAction = c.getString("TEXTS.GUI.INTERACT_LEFT_CLICK_TRASH_ACTION");
        guiInteractRightClickName = c.getString("TEXTS.GUI.INTERACT_RIGHT_CLICK_NAME");
        guiInteractRightClickAction = c.getString("TEXTS.GUI.INTERACT_RIGHT_CLICK_ACTION");
        guiInteractShiftLeftClickName = c.getString("TEXTS.GUI.INTERACT_SHIFT_LEFT_CLICK_NAME");
        guiInteractShiftLeftClickAction = c.getString("TEXTS.GUI.INTERACT_SHIFT_LEFT_CLICK_ACTION");
        guiInteractShiftRightClickName = c.getString("TEXTS.GUI.INTERACT_SHIFT_RIGHT_CLICK_NAME");
        guiInteractShiftRightClickAction = c.getString("TEXTS.GUI.INTERACT_SHIFT_RIGHT_CLICK_ACTION");
        guiInteractDropClickName = c.getString("TEXTS.GUI.INTERACT_DROP_CLICK_NAME");
        guiInteractDropClickAction = c.getString("TEXTS.GUI.INTERACT_DROP_CLICK_ACTION");

        itemDankPack = c.getString("TEXTS.ITEM_DETAILS.ITEM_DANK_PACK");
        itemTrashPack = c.getString("TEXTS.ITEM_DETAILS.ITEM_DANK_TRASH");
        itemStorageCell = c.getString("TEXTS.ITEM_DETAILS.ITEM_STORAGE_CELL");
        itemDankPackLore = c.getStringList("TEXTS.ITEM_DETAILS.ITEM_DANK_PACK_LORE");
        itemTrashPackLore = c.getStringList("TEXTS.ITEM_DETAILS.ITEM_TRASH_PACK_LORE");
        slots = c.getString("TEXTS.ITEM_DETAILS.ITEM_SLOT_NUMBER");
        amountPerSlot = c.getString("TEXTS.ITEM_DETAILS.ITEM_SLOT_AMOUNT_PER");
        voidInfoDankPack = c.getString("TEXTS.ITEM_DETAILS.ITEM_DANK_PACK_VOID_INFO");
        voidInfoTrashPack = c.getString("TEXTS.ITEM_DETAILS.ITEM_DANK_TRASH_VOID_INFO");
        rightClick = c.getString("TEXTS.ITEM_DETAILS.ITEM_RIGHT_CLICK");

        commandSubcommand = c.getString("TEXTS.MESSAGES.COMMANDS.COMMAND_SUBCOMMAND");
        commandSelectItem = c.getString("TEXTS.MESSAGES.COMMANDS.COMMAND_SELECT_ITEM");
        commandPackDoesNotExist = c.getString("TEXTS.MESSAGES.COMMANDS.COMMAND_PACK_NO_EXIST");
        commandDankPackGiven = c.getString("TEXTS.MESSAGES.COMMANDS.COMMAND_DANK_PACK_GIVEN");
        commandTrashPackGiven = c.getString("TEXTS.MESSAGES.COMMANDS.COMMAND_TRASH_PACK_GIVEN");
        commandPackUpdated = c.getString("TEXTS.MESSAGES.COMMANDS.COMMAND_PACK_UPDATED");
        commandBlacklistItemAdded = c.getString("TEXTS.MESSAGES.COMMANDS.COMMAND_BLACKLIST_ITEM_SAVED");
        commandBlacklistMustHold = c.getString("TEXTS.MESSAGES.COMMANDS.COMMAND_BLACKLIST_ITEM_MUST_HOLD");

        eventOpenDank = c.getString("TEXTS.MESSAGES.EVENTS.EVENT_OPEN_DANK_PACK");
        eventOpenTrash = c.getString("TEXTS.MESSAGES.EVENTS.EVENT_OPEN_TRASH_PACK");
        eventInputExisting = c.getString("TEXTS.MESSAGES.EVENTS.EVENT_INPUT_EXISTING");
        eventInputThisDank = c.getString("TEXTS.MESSAGES.EVENTS.EVENT_INPUT_THIS_DANK");
        eventInputBlacklisted = c.getString("TEXTS.MESSAGES.EVENTS.EVENT_INPUT_BLACKLISTED");
        eventWithdrawNoSpace = c.getString("TEXTS.MESSAGES.EVENTS.EVENT_WITHDRAW_NO_SPACE");
        eventSlotNotAssigned = c.getString("TEXTS.MESSAGES.EVENTS.EVENT_SLOT_NOT_ASSIGNED");
        eventSlotCantPlace = c.getString("TEXTS.MESSAGES.EVENTS.EVENT_SLOT_CANT_PLACE");
        eventSlotNoMoreItems = c.getString("TEXTS.MESSAGES.EVENTS.EVENT_SLOT_NO_MORE_ITEMS");
        eventSlotChanged = c.getString("TEXTS.MESSAGES.EVENTS.EVENT_SLOT_CHANGED");

        craftNewPack = c.getString("TEXTS.MESSAGES.CRAFTING.CRAFT_NEW_PACK");
        craftUpgradePack = c.getString("TEXTS.MESSAGES.CRAFTING.CRAFT_UPGRADE_PACK");
        craftNewTrash = c.getString("TEXTS.MESSAGES.CRAFTING.CRAFT_NEW_TRASH");
        craftUpgradeTrash = c.getString("TEXTS.MESSAGES.CRAFTING.CRAFT_UPGRADE_TRASH");

    }
}
