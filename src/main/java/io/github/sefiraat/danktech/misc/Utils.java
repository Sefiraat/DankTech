package io.github.sefiraat.danktech.misc;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.ItemStacks;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.dankpacks.DankPack;
import io.github.sefiraat.danktech.implementation.dankpacks.TrashPack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_DANK_ID;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.ItemDetails.getTrashNameBold;
import static io.github.sefiraat.danktech.misc.Config.getNextPackID;
import static io.github.sefiraat.danktech.misc.Config.getNextTrashID;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }


    public static int getEmptySlots(Player p) {
        PlayerInventory inventory = p.getInventory();
        ItemStack[] cont = inventory.getStorageContents();
        int i = 0;
        for (ItemStack item : cont)
            if (item != null) {
                i++;
            }
        return 36 - i;
    }

    public static void givePlayerDank(Player player, int level, DankTech parent) {
        if (level <= 9) {
            long packID = getNextPackID(parent);
            ItemStack dank = DankPack.getDankPack(level, packID, parent, player.getPlayer());
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

    public static void recoverDankByID(Player p, DankTech parent, long id) {
        int level = parent.getInstance().getDankStorageConfig().getInt(CONFIG_GETTER_SECTION_DANK_ID + "." + id + ".LEVEL");
        ItemStack dank = DankPack.getDankPack(level, id, parent, p.getPlayer());
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        m.setLore(ItemDetails.getDankLore(level, id, null));
        dank.setItemMeta(m);
        p.getInventory().addItem(dank);
        p.sendMessage(Messages.messageCommandPackGiven(id));
    }

    public static void givePlayerTrash(Player player, int level, DankTech parent) {
        if (level <= 9) {
            long packID = getNextTrashID(parent);
            ItemStack trash = TrashPack.getTrashPack(level, packID, parent, player.getPlayer());
            ItemMeta m = trash.getItemMeta();
            m.setDisplayName(getTrashNameBold(level));
            m.setLore(ItemDetails.getTrashLore(level, packID));
            trash.setItemMeta(m);
            player.getPlayer().getInventory().addItem(trash);
            player.getPlayer().sendMessage(Messages.messageCommandTrashGiven(packID));
        } else {
            player.getPlayer().sendMessage(Messages.MESSAGE_COMMAND_PACK_NO_EXIST);
        }
    }

    public static void givePlayerCell(Player player, int level, int amount, DankTech parent) {
        ItemStack i = ItemStacks.getCell(level, parent).clone();
        i.setAmount(amount);
        player.getPlayer().getInventory().addItem(i);
    }

}
