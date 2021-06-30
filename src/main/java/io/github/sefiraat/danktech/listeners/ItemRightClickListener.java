package io.github.sefiraat.danktech.listeners;

import com.gmail.nossr50.mcMMO;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.StorageGui;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.dankpacks.DankPack;
import io.github.sefiraat.danktech.implementation.dankpacks.TrashPack;
import io.github.sefiraat.danktech.misc.Config;
import io.github.sefiraat.danktech.misc.ContainerStorage;
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

import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_DANK_ID;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_TRASH_ID;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_LEVEL;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_SLOT;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_STACK;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_VOLUME;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.ItemDetails.getTrashNameBold;
import static io.github.sefiraat.danktech.implementation.gui.DankGUI.getDankGUI;
import static io.github.sefiraat.danktech.implementation.gui.DankTrashGUI.getTrashGUI;
import static io.github.sefiraat.danktech.misc.Config.getNextPackID;
import static io.github.sefiraat.danktech.misc.Config.getNextTrashID;
import static io.github.sefiraat.danktech.misc.Config.getWorldBlacklistOpen;
import static io.github.sefiraat.danktech.misc.Config.getWorldBlacklistPlace;
import static io.github.sefiraat.danktech.misc.ContainerStorage.isShallow;

public class ItemRightClickListener implements Listener {

    public ItemRightClickListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onClick(PlayerInteractEvent e) {
        if (e.getItem() != null && e.getItem().getItemMeta() != null && e.getAction() != Action.LEFT_CLICK_AIR && e.getAction() != Action.LEFT_CLICK_BLOCK) {
            Player p = e.getPlayer();
            ItemStack i = e.getItem();
            if (ContainerStorage.isDankMaterial(i) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                e.setCancelled(true);
                return;
            }
            if (ContainerStorage.isDank(i)) {
                handleDank(e, i, p);
                e.setCancelled(true);
                return;
            }
            if (ContainerStorage.isTrash(i)) {
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
        if (ContainerStorage.getDankId(i).equals(0L)) {
            replaceDank(i, p, true);
            return;
        } else if (isShallow(i)) {
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
            if (((e.getAction().equals(Action.RIGHT_CLICK_AIR)) || (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && canOpenBlacklist(p)) {
                openDankPack(i, p);
            }
        }
    }

    private void handleTrash(PlayerInteractEvent e, ItemStack i, Player p) {
        if (ContainerStorage.getTrashId(i).equals(0L)) {
            replaceTrash(i, p);
            return;
        } else if (isShallow(i)) {
            replaceAndUpgradeTrash(i, p);
            return;
        }
        if (((e.getAction().equals(Action.RIGHT_CLICK_AIR)) || (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && canOpenBlacklist(p)) {
            openTrashPack(i, p);
        }
    }

    private boolean isOldDank(ItemStack i) {
        Material m = i.getType();
        return (
                m.equals(Material.GRAY_STAINED_GLASS) ||
                m.equals(Material.BLACK_STAINED_GLASS) ||
                m.equals(Material.LIME_STAINED_GLASS) ||
                m.equals(Material.GREEN_STAINED_GLASS) ||
                m.equals(Material.LIGHT_BLUE_STAINED_GLASS) ||
                m.equals(Material.BLUE_STAINED_GLASS) ||
                m.equals(Material.PINK_STAINED_GLASS) ||
                m.equals(Material.PURPLE_STAINED_GLASS) ||
                m.equals(Material.RED_STAINED_GLASS)
        );
    }

    private void replaceDank(ItemStack i, Player player, boolean isNew) {

        int level = ContainerStorage.getDankLevel(i);
        long id;

        if (isNew) {
            id = getNextPackID();
        } else {
            id = ContainerStorage.getDankId(i);
        }

        i.setAmount(0);

        ItemStack dank = DankPack.getDankPack(level, id, player.getPlayer());
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        m.setLore(ItemDetails.getDankLore(level, id, null));
        dank.setItemMeta(m);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), dank);
        player.sendMessage(Messages.messageCommandPackUpdated(id));
    }

    private void replaceAndUpgradeDank(ItemStack i, Player player) {

        int level = ContainerStorage.getDankLevel(i);
        long id = ContainerStorage.getDankId(i);
        i.setAmount(0);

        ConfigurationSection c = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + id);
        c.set(CONFIG_GETTER_VAL_LEVEL, level);
        c.set(CONFIG_GETTER_VAL_SLOT + level + "." + CONFIG_GETTER_VAL_STACK, null);
        c.set(CONFIG_GETTER_VAL_SLOT + level + "." + CONFIG_GETTER_VAL_VOLUME , 0);
        ItemStack dank = DankPack.getDankPack(level, id, player);
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        m.setLore(ItemDetails.getDankLore(level, id, null));
        dank.setItemMeta(m);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), dank);
        player.sendMessage(Messages.messageCraftUpgradePack());
    }

    private void replaceTrash(ItemStack i, Player player) {

        ContainerStorage.getTrashLevel(i);

        int level = ContainerStorage.getTrashLevel(i);
        long id;
        id = getNextTrashID();

        i.setAmount(0);

        ItemStack trash = TrashPack.getTrashPack(level, id, player.getPlayer());
        ItemMeta m = trash.getItemMeta();
        m.setDisplayName(getTrashNameBold(level));
        m.setLore(ItemDetails.getTrashLore(level, id));
        trash.setItemMeta(m);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), trash);
        player.sendMessage(Messages.messageCommandPackUpdated(id));
    }

    private void replaceAndUpgradeTrash(ItemStack i, Player player) {

        int level = ContainerStorage.getTrashLevel(i);
        long id = ContainerStorage.getTrashId(i);

        i.setAmount(0);

        ConfigurationSection c = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_TRASH_ID + "." + id);
        c.set(CONFIG_GETTER_VAL_LEVEL, ((level*2)-1));
        c.set(CONFIG_GETTER_VAL_SLOT + ((level*2)-1) + "." + CONFIG_GETTER_VAL_STACK, null);
        c.set(CONFIG_GETTER_VAL_SLOT + ((level*2)-1) + "." + CONFIG_GETTER_VAL_VOLUME , 0);
        c.set(CONFIG_GETTER_VAL_LEVEL, (level*2));
        c.set(CONFIG_GETTER_VAL_SLOT + (level*2) + "." + CONFIG_GETTER_VAL_STACK, null);
        c.set(CONFIG_GETTER_VAL_SLOT + (level*2) + "." + CONFIG_GETTER_VAL_VOLUME , 0);
        ItemStack trash = TrashPack.getTrashPack(level, id, player);
        ItemMeta m = trash.getItemMeta();
        m.setDisplayName(getTrashNameBold(level));
        m.setLore(ItemDetails.getTrashLore(level, id));
        trash.setItemMeta(m);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), trash);
        player.sendMessage(Messages.messageCraftUpgradeTrash());
    }

    private void openDankPack(ItemStack i, Player p) {
        int dankLevel = ContainerStorage.getDankLevel(i);
        long dankId = ContainerStorage.getDankId(i);
        p.sendMessage(Messages.messageEventOpenPack(dankId));
        Config.setDankLastOpenedBy(dankId, p);
        Gui g = getDankGUI(dankId, dankLevel);
        g.open(p);
    }

    private void openTrashPack(ItemStack i, Player p) {
        int trashLevel = ContainerStorage.getTrashLevel(i);
        long trashId = ContainerStorage.getTrashId(i);
        p.sendMessage(Messages.messageEventOpenTrash(trashId));
        Config.setTrashLastOpenedBy(trashId, p);
        Gui g = getTrashGUI(trashId, trashLevel);
        g.open(p);
    }

    private boolean canOpenBlacklist(Player p) {
        return p.isOp() || p.hasPermission("danktech.admin") || !getWorldBlacklistOpen().contains(p.getWorld().getName());
    }

    private boolean canPlaceBlacklist(Player p) {
        return p.isOp() || p.hasPermission("danktech.admin") || !getWorldBlacklistPlace().contains(p.getWorld().getName());
    }

    private void cycleForward(ItemStack dank, Player p) {
        Integer slot = ContainerStorage.getDankNextSlot(dank);
        Long dankID = ContainerStorage.getDankId(dank);
        ItemStack slotItemStack = Config.getSlotItemStack(dankID, slot);
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
        Integer slot = ContainerStorage.getDankPreviousSlot(dank);
        Long dankID = ContainerStorage.getDankId(dank);
        ItemStack slotItemStack = Config.getSlotItemStack(dankID, slot);
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
        Integer slot = ContainerStorage.getDankCurrentSlot(dank);
        Long dankID = ContainerStorage.getDankId(dank);
        ItemStack slotItemStack = Config.getSlotItemStack(dankID, slot);
        if (slotItemStack != null && !slotItemStack.hasItemMeta() && slotItemStack.getType().isBlock()) {
            Block block = e.getClickedBlock().getRelative(e.getBlockFace());
            if (isSafeToBuild(block, p)) {

                ConfigurationSection section = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
                ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + slot);

                int amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
                if (amount > 1) {
                    amount--;
                    slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
                    ItemStack i = Config.getSlotItemStack(dankID, slot);
                    block.setType(i.getType());
                    if (DankTech.getInstance().getSupportedPlugins().isMcMMO()) {
                        mcMMO.getPlaceStore().setTrue(block);
                    }
                } else {
                    p.sendMessage(Messages.messageEventSlotNoMoreItems());
                }
            }
        } else {
            p.sendMessage(Messages.messageEventSlotCantPlace());
        }
    }

    private boolean isSafeToBuild(Block block, Player p) {
        if (block.getBlockData().getMaterial().equals(Material.AIR) && DankTech.getInstance().getProtection().canBuild(block, p)) {
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
