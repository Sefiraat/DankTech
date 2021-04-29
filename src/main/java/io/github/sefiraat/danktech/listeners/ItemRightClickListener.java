package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.Messages;
import me.mattstudios.mfgui.gui.guis.Gui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

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
                    e.setCancelled(true);
                    Player p = e.getPlayer();
                    if (p.isSneaking()) {
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
                        }
                    } else {
                        if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
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

    private void cycleForward(ItemStack i, Player p) {
    }

    private void cycleBackward(ItemStack i, Player p) {
    }

    private void placeBlock(PlayerInteractEvent e, ItemStack i, Player p) {
    }

}
