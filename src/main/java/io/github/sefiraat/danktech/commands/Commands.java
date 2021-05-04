package io.github.sefiraat.danktech.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.gui.AdminGUI;
import io.github.sefiraat.danktech.implementation.abstracts.DankPack;
import jdk.jfr.Description;
import me.mattstudios.mfgui.gui.guis.PaginatedGui;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.Materials.getDankMaterial;
import static io.github.sefiraat.danktech.lib.misc.Utils.getNextPackID;

@CommandAlias("DankTech|DT")
@Description("DankTech Main")
public class Commands extends BaseCommand {

    public final DankTech parent;

    public Commands(DankTech Parent) {
        this.parent = Parent;
    }

    @Default
    public void onDefault(CommandSender sender) {
        if (sender instanceof Player) {
            sender.sendMessage(Messages.MESSAGE_COMMAND_SUBCOMMAND);
        }
    }


    @Subcommand("GiveItem")
    @Description("Gives Debug Items")
    public class GiveItem extends BaseCommand {

        @Default
        public void onDefault(CommandSender sender) {
            if (sender instanceof Player) {
                sender.sendMessage(Messages.MESSAGE_COMMAND_SELECT_ITEM);
            }
        }

        @Subcommand("DankPack")
        @CommandPermission("DankTech.Admin")
        @CommandCompletion("@players @range:1-9")
        public void onGiveItemDank(CommandSender sender, OnlinePlayer player, int level) {
            if (sender instanceof Player) {
                if (level <= 9) {
                    long packID = getNextPackID(parent);
                    DankPack dank = new DankPack(getDankMaterial(level), level, packID, parent, player.getPlayer());
                    ItemMeta m = dank.getItemMeta();
                    m.setDisplayName(getDankNameBold(level));
                    m.setLore(ItemDetails.getDankLore(level, packID, null));
                    dank.setItemMeta(m);
                    player.getPlayer().getInventory().addItem(dank);
                    player.getPlayer().sendMessage(Messages.messageCommandPackGiven(packID));
                } else {
                    player.getPlayer().sendMessage(Messages.MESSAGE_COMMAND_PACK_NO_EXIST);
                }
            }
        }
    }

    @Subcommand("RecoverPack")
    @Description("Recovers a pre-existing pack")
    public class RecoverPack extends BaseCommand {

        @Default
        public void onDefault(CommandSender sender) {
            if (sender instanceof Player) {
                sender.sendMessage(Messages.MESSAGE_COMMAND_SELECT_ITEM);
            }
        }

        @Subcommand("PackByID")
        @CommandPermission("DankTech.Admin")
        public void onRecoverItemDank(CommandSender sender, long id) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                int level = parent.getInstance().getDankStorageConfig().getInt("PACKS.PACKS_BY_ID." + id + ".LEVEL");

                DankPack dank = new DankPack(getDankMaterial(level), level, id, parent, null);
                ItemMeta m = dank.getItemMeta();
                m.setDisplayName(getDankNameBold(level));
                m.setLore(ItemDetails.getDankLore(level, id, null));
                dank.setItemMeta(m);
                player.getInventory().addItem(dank);
                player.sendMessage(Messages.messageCommandPackGiven(id));
            }
        }
    }

    @Subcommand("ViewPacks")
    @Description("Opens a GUI of pre-existing packs")
    @CommandPermission("DankTech.Admin")
    public class ViewPacks extends BaseCommand {

        @Default
        public void onDefault(CommandSender sender) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                PaginatedGui adminGUI = AdminGUI.getDankAdminGUI(parent);
                adminGUI.open(p);
            }
        }

    }
}