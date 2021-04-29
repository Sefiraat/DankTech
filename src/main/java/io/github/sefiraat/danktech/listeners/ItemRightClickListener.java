package io.github.sefiraat.danktech.listeners;

import com.gmail.nossr50.mcMMO;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.GUIItems;
import io.github.sefiraat.danktech.finals.Messages;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.DataStore;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SoundGroup;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

import java.util.Locale;

import static io.github.sefiraat.danktech.lib.misc.DankGUI.getDankGUI;
import static io.github.sefiraat.danktech.lib.misc.Utils.*;

public class ItemRightClickListener implements Listener {

    final DankTech Parent;

    public ItemRightClickListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        Parent = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onRightClick(PlayerInteractEvent e) {
        if (e.getItem() != null) {
            if (e.getItem().getItemMeta() != null) {
                ItemStack i = e.getItem();
                if (isDank(i, Parent.getInstance())) {
                    Player p = e.getPlayer();
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
    }

    private void openDankPack(ItemStack i, Player p) {
        int dankLevel = getDankLevel(i,Parent.getInstance());
        long dankId = getDankId(i, Parent.getInstance());
        p.sendMessage(Messages.MessageEventOpenPack(dankId));
        Gui g = getDankGUI(dankId, dankLevel, Parent.getInstance());
        g.open(p);
    }

    private void cycleForward(ItemStack dank, Player p) {
        Integer slot = getDankNextSlot(dank, Parent);
        Long dankID = getDankId(dank,Parent);
        ItemStack slotItemStack = getSlotItemStack(dankID, slot, Parent);
        String itemName = "EMPTY";
        if (slotItemStack != null) {
            if (slotItemStack.getItemMeta().hasDisplayName()) {
                itemName = slotItemStack.getItemMeta().getDisplayName();
            } else {
                itemName = slotItemStack.getType().name().replace("_","");
            }
        }
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Messages.MessageEventSlotChanged(itemName, slot)));
    }

    private void cycleBackward(ItemStack dank, Player p) {
        Integer slot = getDankPreviousSlot(dank, Parent);
        Long dankID = getDankId(dank,Parent);
        ItemStack slotItemStack = getSlotItemStack(dankID, slot, Parent);
        String itemName = "EMPTY";
        if (slotItemStack != null) {
            if (slotItemStack.getItemMeta().hasDisplayName()) {
                itemName = slotItemStack.getItemMeta().getDisplayName();
            } else {
                itemName = slotItemStack.getType().name().replace("_"," ");
            }
        }
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Messages.MessageEventSlotChanged(itemName, slot)));
    }

    private void placeBlock(PlayerInteractEvent e, ItemStack dank, Player p) {
        Integer slot = getDankCurrentSlot(dank, Parent);
        Long dankID = getDankId(dank,Parent);
        ItemStack slotItemStack = getSlotItemStack(dankID, slot, Parent);
        if (!slotItemStack.hasItemMeta() && slotItemStack.getType().isBlock()) {
            Block block = e.getClickedBlock().getRelative(e.getBlockFace());
            if (block.getBlockData().getMaterial() == Material.AIR) {
                if (Parent.getProtection().canBuild(block, p)) {

                    ConfigurationSection section = Parent.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + dankID);
                    ConfigurationSection slotSection = section.getConfigurationSection("SLOT" + slot);

                    Integer amount = slotSection.getInt("VOLUME");
                    if (amount > 1) {
                        amount--;
                        slotSection.set("VOLUME", amount);
                        ItemStack i = getSlotItemStack(dankID, slot, Parent);
                        block.setType(i.getType());
                        mcMMO.getPlaceStore().setTrue(block);
                    } else {
                        p.sendMessage(Messages.MessageEventSlotNoMoreItems);
                    }
                }
            }
        } else {
            p.sendMessage(Messages.MessageEventSlotCantPlace);
        }
    }

}
