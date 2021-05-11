package io.github.sefiraat.danktech.misc;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.implementation.dankpacks.DankPack;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.github.sefiraat.danktech.finals.Constants.*;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;

public class Config {

    private Config() {
        throw new IllegalStateException("Utility class");
    }

    public static void setLastOpenedBy(Long dankID, DankTech plugin, Player p) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
        section.set("LAST_OPENED_BY_UUID", p.getUniqueId().toString());
        section.set("LAST_OPENED_BY", p.getDisplayName());
        section.set("LAST_OPENED_ON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        plugin.saveDankStorageConfig();
    }

    public static String getLastOpenedBy(Long dankID, DankTech plugin) {
        return plugin.getInstance().getDankStorageConfig().getString(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + ".LAST_OPENED_BY");
    }

    public static String getLastOpenedByUUID(Long dankID, DankTech plugin) {
        return plugin.getInstance().getDankStorageConfig().getString(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + ".LAST_OPENED_BY_UUID");
    }

    public static String getLastOpenedOn(Long dankID, DankTech plugin) {
        return plugin.getInstance().getDankStorageConfig().getString(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + ".LAST_OPENED_ON");
    }

    public static ItemStack getSlotItemStack(Long dankID, Integer slot, DankTech plugin) {
        ConfigurationSection section = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "."  + dankID);
        ConfigurationSection slotSection = section.getConfigurationSection("SLOT" + slot);
        ItemStack stack = null;
        if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
            stack = slotSection.getItemStack(CONFIG_GETTER_VAL_STACK).clone();
        }
        return stack;
    }

    public static long getNextPackID(DankTech plugin) {
        ConfigurationSection sec = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID);
        int nextValue = 1;
        if (sec != null) {
            for (String key : sec.getKeys(false)) {
                int value = Integer.parseInt(key);
                if (value > nextValue) {
                    nextValue = value;
                }
            }
            nextValue++;
        }
        return nextValue;
    }

    public static long getNextTrashID(DankTech plugin) {
        ConfigurationSection sec = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_TRASH_ID);
        int nextValue = 1;
        if (sec != null) {
            for (String key : sec.getKeys(false)) {
                int value = Integer.parseInt(key);
                if (value > nextValue) {
                    nextValue = value;
                }
            }
            nextValue++;
        }
        return nextValue;
    }

    public static List<ItemStack> getAllDanks(DankTech plugin) {
        List<ItemStack> l = new ArrayList<>();
        ConfigurationSection sec = plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID);
        if (sec != null) {
            for (String s : sec.getKeys(false)) {
                Long dankID = Long.valueOf(s);
                int level = plugin.getInstance().getDankStorageConfig().getInt(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + "." + CONFIG_GETTER_VAL_LEVEL);
                ItemStack dank = DankPack.getDankPack(level, dankID, plugin, null);
                ItemMeta m = dank.getItemMeta();
                m.setDisplayName(getDankNameBold(level));
                m.setLore(ItemDetails.getDankLore(level, dankID, null));
                dank.setItemMeta(m);
                l.add(dank);
            }
        }
        return l;
    }

    public static ConfigurationSection getDankSection(DankTech plugin, long dankID) {
        return plugin.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "."  + dankID);
    }

    public static List<String> getWorldBlacklistOpen(DankTech plugin) {
        return plugin.getConfig().getStringList("GENERAL.BLACKLISTED_WORLDS_OPEN_PACK");
    }

    public static List<String> getWorldBlacklistPlace(DankTech plugin) {
        return plugin.getConfig().getStringList("GENERAL.BLACKLISTED_WORLDS_BLOCK_PLACEMENT");
    }

    public static List<String> getWorldBlacklistPickup(DankTech plugin) {
        return plugin.getConfig().getStringList("GENERAL.BLACKLISTED_WORLDS_PICKUP_ITEMS");
    }

}
