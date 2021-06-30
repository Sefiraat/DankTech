package io.github.sefiraat.danktech.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import dev.triumphteam.gui.guis.PaginatedGui;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.gui.AdminGUI;
import io.github.sefiraat.danktech.misc.Utils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static io.github.sefiraat.danktech.misc.Utils.givePlayerCell;
import static io.github.sefiraat.danktech.misc.Utils.givePlayerDank;
import static io.github.sefiraat.danktech.misc.Utils.givePlayerTrash;
import static io.github.sefiraat.danktech.misc.Utils.recoverDankByID;

@CommandAlias("DankTech|DT")
@Description("DankTech Main")
public class Commands extends BaseCommand {

    public Commands(DankTech parent) {

    }

    @Default
    public void onDefault(CommandSender sender) {
        if (sender instanceof Player) {
            sender.sendMessage(Messages.messageCommandSubcommand());
        }
    }


    @Subcommand("GiveItem")
    @Description("Gives Debug Items")
    public class GiveItem extends BaseCommand {

        @Default
        public void onDefault(CommandSender sender) {
            if (sender instanceof Player) {
                sender.sendMessage(Messages.messageCommandSelectItem());
            }
        }

        @Subcommand("DankPack")
        @CommandPermission("DankTech.Admin")
        @CommandCompletion("@players @range:1-9")
        public void onGiveItemDank(CommandSender sender, OnlinePlayer player, int level) {
            if (sender instanceof Player) {
                givePlayerDank(player.getPlayer(), level);
            }
        }

        @Subcommand("TrashPack")
        @CommandPermission("DankTech.Admin")
        @CommandCompletion("@players @range:1-9")
        public void onGiveItemTrash(CommandSender sender, OnlinePlayer player, int level) {
            if (sender instanceof Player) {
                givePlayerTrash(player.getPlayer(), level);
            }
        }

        @Subcommand("DankCell")
        @CommandPermission("DankTech.Admin")
        @CommandCompletion("@players @range:1-9 @range:1-64")
        public void onGiveItemCell(CommandSender sender, OnlinePlayer player, int level, int amount) {
            if (sender instanceof Player) {
                givePlayerCell(player.getPlayer(), level, amount);
            }
        }

    }

    @Subcommand("RecoverPack")
    @Description("Recovers a pre-existing pack")
    public class RecoverPack extends BaseCommand {

        @Default
        public void onDefault(CommandSender sender) {
            if (sender instanceof Player) {
                sender.sendMessage(Messages.messageCommandSelectItem());
            }
        }

        @Subcommand("PackByID")
        @CommandPermission("DankTech.Admin")
        public void onRecoverItemDank(CommandSender sender, long id) {
            if (sender instanceof Player) {
                recoverDankByID((Player) sender, id);
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
                PaginatedGui adminGUI = AdminGUI.getDankAdminGUI();
                adminGUI.open(p);
            }
        }
    }

    @Subcommand("AddBlacklist")
    @CommandPermission("CharmTech.Admin")
    @Description("Saves the item in hand to the charm library")
    public class AddBlacklist extends BaseCommand {

        @Default
        public void onDefault(CommandSender sender) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                ItemStack i = p.getInventory().getItemInMainHand();
                if (i.getType() != Material.AIR) {
                    ItemStack stackToSave = i.clone();
                    stackToSave.setAmount(1);
                    long nextItem = Utils.getNextItemID();
                    FileConfiguration c = DankTech.getInstance().getItemBlacklistConfig();
                    c.createSection("BLACKLISTED_ITEMS" + "." + nextItem);
                    c.set("BLACKLISTED_ITEMS." + nextItem, stackToSave);
                    DankTech.getInstance().saveItemBlacklistConfig();
                    p.sendMessage(Messages.messageCommandBlacklistItemSaved());
                } else {
                    p.sendMessage(Messages.messageCommandBlacklistMustHold());
                }
            }
        }
    }
}