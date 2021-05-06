package io.github.sefiraat.danktech.listeners;

import com.gmail.nossr50.mcMMO;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.dankpacks.DankPack;
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
import static io.github.sefiraat.danktech.implementation.gui.DankGUI.getDankGUI;
import static io.github.sefiraat.danktech.lib.misc.Utils.*;

public class ItemRightClickListener implements Listener {

    final DankTech parent;

    public ItemRightClickListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        parent = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onRightClick(PlayerInteractEvent e) {
        if (e.getItem() != null && e.getItem().getItemMeta() != null) {
            Player p = e.getPlayer();
            ItemStack i = e.getItem();
            if (isDankMaterial(i, parent.getInstance()) && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                e.setCancelled(true);
                return;
            }
            if (isDank(i, parent.getInstance())) {
                if (isOldDank(i)) {
                    replaceDank(i, p);
                    e.setCancelled(true);
                    return;
                }
                if (p.isSneaking()) {
                    switch (e.getAction()) {
                        case LEFT_CLICK_AIR:
                            e.setCancelled(true);
                            cycleBackward(i, p);
                            break;
                        case RIGHT_CLICK_AIR:
                            e.setCancelled(true);
                            cycleForward(i, p);
                            break;
                        case RIGHT_CLICK_BLOCK:
                            e.setCancelled(true);
                            placeBlock(e, i, p);
                            break;
                        default:
                            break;
                    }
                } else {
                    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                        e.setCancelled(true);
                        openDankPack(i, p);
                    }
                }
            }
        }
    }

    private boolean isOldDank(ItemStack i) {
        Material m = i.getType();
        if (
                i.getType() == Material.GRAY_STAINED_GLASS ||
                i.getType() == Material.BLACK_STAINED_GLASS ||
                i.getType() == Material.LIME_STAINED_GLASS ||
                i.getType() == Material.GREEN_STAINED_GLASS ||
                i.getType() == Material.LIGHT_BLUE_STAINED_GLASS ||
                i.getType() == Material.BLUE_STAINED_GLASS ||
                i.getType() == Material.PINK_STAINED_GLASS ||
                i.getType() == Material.PURPLE_STAINED_GLASS ||
                i.getType() == Material.RED_STAINED_GLASS
        ) {
            return true;
        }
        return false;
    }

    private void replaceDank(ItemStack i, Player player) {

        getDankLevel(i, parent);

        int level = getDankLevel(i, parent);
        long id = getDankId(i, parent);

        i.setAmount(0);

        ItemStack dank = DankPack.DankPack(level, id, parent, player.getPlayer());
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        m.setLore(ItemDetails.getDankLore(level, id, null));
        dank.setItemMeta(m);
        // player.getInventory().addItem(dank);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), dank);
        player.sendMessage(Messages.messageCommandPackUpdated(id));
    }

    private void openDankPack(ItemStack i, Player p) {
        int dankLevel = getDankLevel(i, parent.getInstance());
        long dankId = getDankId(i, parent.getInstance());
        p.sendMessage(Messages.messageEventOpenPack(dankId));
        setLastOpenedBy(dankId, parent, p);
        Gui g = getDankGUI(dankId, dankLevel, parent.getInstance());
        g.open(p);
    }

    private void cycleForward(ItemStack dank, Player p) {
        Integer slot = getDankNextSlot(dank, parent);
        Long dankID = getDankId(dank, parent);
        ItemStack slotItemStack = getSlotItemStack(dankID, slot, parent);
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
        Integer slot = getDankPreviousSlot(dank, parent);
        Long dankID = getDankId(dank, parent);
        ItemStack slotItemStack = getSlotItemStack(dankID, slot, parent);
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
        Integer slot = getDankCurrentSlot(dank, parent);
        Long dankID = getDankId(dank, parent);
        ItemStack slotItemStack = getSlotItemStack(dankID, slot, parent);
        if (slotItemStack != null && !slotItemStack.hasItemMeta() && slotItemStack.getType().isBlock()) {
            Block block = e.getClickedBlock().getRelative(e.getBlockFace());
            if (isSafeToBuild(block, p)) {

                ConfigurationSection section = parent.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
                ConfigurationSection slotSection = section.getConfigurationSection(CONFIG_GETTER_VAL_SLOT + slot);

                Integer amount = slotSection.getInt(CONFIG_GETTER_VAL_VOLUME);
                if (amount > 1) {
                    amount--;
                    slotSection.set(CONFIG_GETTER_VAL_VOLUME, amount);
                    ItemStack i = getSlotItemStack(dankID, slot, parent);
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
