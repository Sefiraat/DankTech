package io.github.sefiraat.danktech.listeners;

import com.gmail.nossr50.mcMMO;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.dankpacks.DankPack;
import io.github.sefiraat.danktech.implementation.dankpacks.TrashPack;
import io.github.sefiraat.danktech.misc.Config;
import io.github.sefiraat.danktech.misc.ContainerStorage;
import me.mattstudios.mfgui.gui.guis.Gui;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.Collection;

import static io.github.sefiraat.danktech.finals.Constants.*;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.ItemDetails.getTrashNameBold;
import static io.github.sefiraat.danktech.implementation.gui.DankGUI.getDankGUI;
import static io.github.sefiraat.danktech.implementation.gui.DankTrashGUI.getTrashGUI;
import static io.github.sefiraat.danktech.misc.Config.*;
import static io.github.sefiraat.danktech.misc.ContainerStorage.isShallow;

public class ItemRightClickListener implements Listener {

    final DankTech parent;

    public ItemRightClickListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        parent = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onRightClick(PlayerInteractEvent e) {
        if (e.getItem() != null && e.getItem().getItemMeta() != null && e.getAction() != Action.LEFT_CLICK_AIR && e.getAction() != Action.LEFT_CLICK_BLOCK) {
            Player p = e.getPlayer();
            ItemStack i = e.getItem();
            if (ContainerStorage.isDankMaterial(i, parent.getInstance()) && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                e.setCancelled(true);
                return;
            }
            if (ContainerStorage.isDank(i, parent.getInstance())) {
                handleDank(e, i, p);
                e.setCancelled(true);
                return;
            }
            if (ContainerStorage.isTrash(i, parent.getInstance())) {
                handleTrash(e, i, p);
                e.setCancelled(true);
            }
        }
    }

    private void handleDank(PlayerInteractEvent e, ItemStack i, Player p) {
        if (isOldDank(i)) {
            replaceDank(i, p, false);
            return;
        }
        if (ContainerStorage.getDankId(i, parent) == 0) {
            replaceDank(i, p, true);
            return;
        } else if (isShallow(i, parent)) {
            replaceAndUpgradeDank(i, p);
            return;
        }
        if (p.isSneaking() && canPlaceBlacklist(p)) {
            switch (e.getAction()) {
                case LEFT_CLICK_AIR:
                    cycleBackward(i, p);
                    break;
                case RIGHT_CLICK_AIR:
                    cycleForward(i, p);
                    break;
                case RIGHT_CLICK_BLOCK:
                    placeBlock(e, i, p);
                    break;
                default:
                    break;
            }
        } else {
            if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && canOpenBlacklist(p)) {
                openDankPack(i, p);
            }
        }
    }

    private void handleTrash(PlayerInteractEvent e, ItemStack i, Player p) {
        if (ContainerStorage.getTrashId(i, parent) == 0) {
            replaceTrash(i, p);
            return;
        } else if (isShallow(i, parent)) {
            replaceAndUpgradeTrash(i, p);
            return;
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && canOpenBlacklist(p)) {
            openTrashPack(i, p);
        }
    }

    private boolean isOldDank(ItemStack i) {
        Material m = i.getType();
        return (
                m == Material.GRAY_STAINED_GLASS ||
                m == Material.BLACK_STAINED_GLASS ||
                m == Material.LIME_STAINED_GLASS ||
                m == Material.GREEN_STAINED_GLASS ||
                m == Material.LIGHT_BLUE_STAINED_GLASS ||
                m == Material.BLUE_STAINED_GLASS ||
                m == Material.PINK_STAINED_GLASS ||
                m == Material.PURPLE_STAINED_GLASS ||
                m == Material.RED_STAINED_GLASS
        );
    }

    private void replaceDank(ItemStack i, Player player, boolean isNew) {

        int level = ContainerStorage.getDankLevel(i, parent);
        long id = 0;

        if (isNew) {
            id = getNextPackID(parent);
        } else {
            id = ContainerStorage.getDankId(i, parent);
        }

        i.setAmount(0);

        ItemStack dank = DankPack.getDankPack(level, id, parent, player.getPlayer());
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        m.setLore(ItemDetails.getDankLore(level, id, null));
        dank.setItemMeta(m);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), dank);
        player.sendMessage(Messages.messageCommandPackUpdated(id));
    }

    private void replaceAndUpgradeDank(ItemStack i, Player player) {

        int level = ContainerStorage.getDankLevel(i, parent);
        long id = ContainerStorage.getDankId(i, parent);
        i.setAmount(0);

        ConfigurationSection c = parent.getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + id);
        c.set(CONFIG_GETTER_VAL_LEVEL, level);
        c.set(CONFIG_GETTER_VAL_SLOT + level + "." + CONFIG_GETTER_VAL_STACK, null);
        c.set(CONFIG_GETTER_VAL_SLOT + level + "." + CONFIG_GETTER_VAL_VOLUME , 0);
        ItemStack dank = DankPack.getDankPack(level, id, parent, player);
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        m.setLore(ItemDetails.getDankLore(level, id, null));
        dank.setItemMeta(m);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), dank);
        player.sendMessage(Messages.MESSAGE_CRAFT_UPGRADE_PACK);
    }

    private void replaceTrash(ItemStack i, Player player) {

        ContainerStorage.getTrashLevel(i, parent);

        int level = ContainerStorage.getTrashLevel(i, parent);
        long id = 0;
        id = getNextTrashID(parent);

        i.setAmount(0);

        ItemStack trash = TrashPack.getTrashPack(level, id, parent, player.getPlayer());
        ItemMeta m = trash.getItemMeta();
        m.setDisplayName(getTrashNameBold(level));
        m.setLore(ItemDetails.getTrashLore(level, id));
        trash.setItemMeta(m);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), trash);
        player.sendMessage(Messages.messageCommandPackUpdated(id));
    }

    private void replaceAndUpgradeTrash(ItemStack i, Player player) {

        int level = ContainerStorage.getTrashLevel(i, parent);
        long id = ContainerStorage.getTrashId(i, parent);

        i.setAmount(0);

        ConfigurationSection c = parent.getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_TRASH_ID + "." + id);
        c.set(CONFIG_GETTER_VAL_LEVEL, ((level*2)-1));
        c.set(CONFIG_GETTER_VAL_SLOT + ((level*2)-1) + "." + CONFIG_GETTER_VAL_STACK, null);
        c.set(CONFIG_GETTER_VAL_SLOT + ((level*2)-1) + "." + CONFIG_GETTER_VAL_VOLUME , 0);
        c.set(CONFIG_GETTER_VAL_LEVEL, (level*2));
        c.set(CONFIG_GETTER_VAL_SLOT + (level*2) + "." + CONFIG_GETTER_VAL_STACK, null);
        c.set(CONFIG_GETTER_VAL_SLOT + (level*2) + "." + CONFIG_GETTER_VAL_VOLUME , 0);
        ItemStack trash = TrashPack.getTrashPack(level, id, parent, player);
        ItemMeta m = trash.getItemMeta();
        m.setDisplayName(getTrashNameBold(level));
        m.setLore(ItemDetails.getTrashLore(level, id));
        trash.setItemMeta(m);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), trash);
        player.sendMessage(Messages.MESSAGE_CRAFT_UPGRADE_TRASH);
    }

    private void openDankPack(ItemStack i, Player p) {
        int dankLevel = ContainerStorage.getDankLevel(i, parent.getInstance());
        long dankId = ContainerStorage.getDankId(i, parent.getInstance());
        p.sendMessage(Messages.messageEventOpenPack(dankId));
        Config.setDankLastOpenedBy(dankId, parent, p);
        Gui g = getDankGUI(dankId, dankLevel, parent.getInstance());
        g.open(p);
    }

    private void openTrashPack(ItemStack i, Player p) {
        int trashLevel = ContainerStorage.getTrashLevel(i, parent.getInstance());
        long trashId = ContainerStorage.getTrashId(i, parent.getInstance());
        p.sendMessage(Messages.messageEventOpenPack(trashId));
        Config.setDankLastOpenedBy(trashId, parent, p);
        Gui g = getTrashGUI(trashId, trashLevel, parent.getInstance());
        g.open(p);
    }

    private boolean canOpenBlacklist(Player p) {
        return p.isOp() || p.hasPermission("danktech.admin") || !getWorldBlacklistOpen(parent).contains(p.getWorld().getName());
    }

    private boolean canPlaceBlacklist(Player p) {
        return p.isOp() || p.hasPermission("danktech.admin") || !getWorldBlacklistPlace(parent).contains(p.getWorld().getName());
    }

    private void cycleForward(ItemStack dank, Player p) {
        Integer slot = ContainerStorage.getDankNextSlot(dank, parent);
        Long dankID = ContainerStorage.getDankId(dank, parent);
        ItemStack slotItemStack = Config.getSlotItemStack(dankID, slot, parent);
        String itemName = "EMPTY";
        if (slotItemStack != null) {
            if (slotItemStack.getItemMeta().hasDisplayName()) {
                itemName = slotItemStack.getItemMeta().getDisplayName();
            } else {
                itemName = slotItemStack.getType().name().replace("_"," ");
            }
        }
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Messages.messageEventSlotChanged(itemName, slot)));
    }

    private void cycleBackward(ItemStack dank, Player p) {
        Integer slot = ContainerStorage.getDankPreviousSlot(dank, parent);
        Long dankID = ContainerStorage.getDankId(dank, parent);
        ItemStack slotItemStack = Config.getSlotItemStack(dankID, slot, parent);
        String itemName = "EMPTY";
        if (slotItemStack != null) {
            if (slotItemStack.getItemMeta().hasDisplayName()) {
                itemName = slotItemStack.getItemMeta().getDisplayName();
            } else {
                itemName = slotItemStack.getType().name().replace("_"," ");
            }
        }
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Messages.messageEventSlotChanged(itemName, slot)));
    }

    private void placeBlock(PlayerInteractEvent e, ItemStack dank, Player p) {
        Integer slot = ContainerStorage.getDankCurrentSlot(dank, parent);
        Long dankID = ContainerStorage.getDankId(dank, parent);
        ItemStack slotItemStack = Config.getSlotItemStack(dankID, slot, parent);
        if (slotItemStack != null && !slotItemStack.hasItemMeta() && slotItemStack.getType().isBlock()) {
            Block block = e.getClickedBlock().getRelative(e.getBlockFace());
            if (isSafeToBuild(block, p)) {

                ConfigurationSection section = parent.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
                ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + slot);

                Integer amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
                if (amount > 1) {
                    amount--;
                    slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
                    ItemStack i = Config.getSlotItemStack(dankID, slot, parent);
                    block.setType(i.getType());
                    if (parent.isMcMMO()) {
                        mcMMO.getPlaceStore().setTrue(block);
                    }
                } else {
                    p.sendMessage(Messages.MESSAGE_EVENT_SLOT_NO_MORE_ITEMS);
                }
            }
        } else {
            p.sendMessage(Messages.MESSAGE_EVENT_SLOT_CANT_PLACE);
        }
    }

    private boolean isSafeToBuild(Block block, Player p) {
        if (block.getBlockData().getMaterial() == Material.AIR && parent.getProtection().canBuild(block, p)) {
            Collection<Entity> entities = block.getWorld().getNearbyEntities(block.getLocation(), 0.5, 0.5, 0.5);
            if (!entities.isEmpty()) {
                for (Entity e : entities) {
                    if (e.getType() != EntityType.DROPPED_ITEM) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

}
