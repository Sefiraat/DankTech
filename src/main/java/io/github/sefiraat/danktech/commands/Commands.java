package io.github.sefiraat.danktech.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.abstracts.DankPack;
import jdk.jfr.Description;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.Materials.getDankMaterial;
import static io.github.sefiraat.danktech.lib.misc.Utils.getNextPackID;

@CommandAlias("DankTech|DT")
@Description("DankTech Main")
public class Commands extends BaseCommand {

    public DankTech Parent;

    public Commands(DankTech Parent) {
        this.Parent = Parent;
    }

    @Subcommand("GiveItem")
    @Description("Gives Debug Items")
    public class GiveItem extends BaseCommand {

        @Default
        public void onDefault(CommandSender sender) {
            if (sender instanceof Player) {
                sender.sendMessage(Messages.MessageCommandSelectItem);
            }
        }

        @Subcommand("DankPack")
        @CommandPermission("DankTech.Admin")
        public void onGiveItemDank(CommandSender sender, int level) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (level <= 9) {
                    long packID = getNextPackID(Parent);
                    DankPack Dank = new DankPack(getDankMaterial(level), level, packID, Parent);
                    ItemMeta m = Dank.getItemMeta();
                    m.setDisplayName(getDankNameBold(level));
                    m.setLore(ItemDetails.getDankLore(level));
                    Dank.setItemMeta(m);
                    player.getInventory().addItem(Dank);
                    player.sendMessage(Messages.MessageCommandPackGiven(packID));
                } else {
                    player.sendMessage(Messages.MessageCommandPackNoExist);
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
                sender.sendMessage(Messages.MessageCommandSelectItem);
            }
        }

        @Subcommand("PackByID")
        @CommandPermission("DankTech.Admin")
        public void onRecoverItemDank(CommandSender sender, long ID) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                int level = Parent.getInstance().getDankStorageConfig().getInt("PACKS.PACKS_BY_ID." + ID + ".LEVEL");

                DankPack Dank = new DankPack(getDankMaterial(level), level, ID, Parent);
                ItemMeta m = Dank.getItemMeta();
                m.setDisplayName(getDankNameBold(level));
                m.setLore(ItemDetails.getDankLore(level));
                Dank.setItemMeta(m);
                player.getInventory().addItem(Dank);
                player.sendMessage(Messages.MessageCommandPackGiven(ID));
            }
        }
    }

}