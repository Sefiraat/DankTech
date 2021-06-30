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
import java.util.Objects;

import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_DANK_ID;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_TRASH_ID;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_LEVEL;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_STACK;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;

public class Config {

    private Config() {
        throw new IllegalStateException("Utility class");
    }

    public static void setDankLastOpenedBy(Long dankID, Player p) {
        ConfigurationSection section = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID);
        assert section != null;
        section.set("LAST_OPENED_BY_UUID", p.getUniqueId().toString());
        section.set("LAST_OPENED_BY", p.getDisplayName());
        section.set("LAST_OPENED_ON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        DankTech.getInstance().saveDankStorageConfig();
    }

    public static void setTrashLastOpenedBy(Long trashID, Player p) {
        ConfigurationSection section = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID);
        assert section != null;
        section.set("LAST_OPENED_BY_UUID", p.getUniqueId().toString());
        section.set("LAST_OPENED_BY", p.getDisplayName());
        section.set("LAST_OPENED_ON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        DankTech.getInstance().saveDankStorageConfig();
    }

    public static String getLastOpenedBy(Long dankID) {
        return DankTech.getInstance().getDankStorageConfig().getString(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + ".LAST_OPENED_BY");
    }

    public static String getLastOpenedByUUID(Long dankID) {
        return DankTech.getInstance().getDankStorageConfig().getString(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + ".LAST_OPENED_BY_UUID");
    }

    public static String getLastOpenedOn(Long dankID) {
        return DankTech.getInstance().getDankStorageConfig().getString(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + ".LAST_OPENED_ON");
    }

    public static ItemStack getSlotItemStack(Long dankID, Integer slot) {
        ConfigurationSection section = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "."  + dankID);
        assert section != null;
        ConfigurationSection slotSection = section.getConfigurationSection("SLOT" + slot);
        assert slotSection != null;
        ItemStack stack = null;
        if (slotSection.getItemStack(CONFIG_GETTER_VAL_STACK) != null) {
            stack = Objects.requireNonNull(slotSection.getItemStack(CONFIG_GETTER_VAL_STACK)).clone();
        }
        return stack;
    }

    public static long getNextPackID() {
        ConfigurationSection sec = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID);
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

    public static long getNextTrashID() {
        ConfigurationSection sec = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_TRASH_ID);
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

    public static List<ItemStack> getAllDanks() {
        List<ItemStack> l = new ArrayList<>();
        ConfigurationSection sec = DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID);
        if (sec != null) {
            for (String s : sec.getKeys(false)) {
                long dankID = Long.parseLong(s);
                int level = DankTech.getInstance().getDankStorageConfig().getInt(CONFIG_GETTER_SECTION_DANK_ID + "." + dankID + "." + CONFIG_GETTER_VAL_LEVEL);
                ItemStack dank = DankPack.getDankPack(level, dankID, null);
                ItemMeta im = dank.getItemMeta();
                assert im != null;
                im.setDisplayName(getDankNameBold(level));
                im.setLore(ItemDetails.getDankLore(level, dankID, null));
                dank.setItemMeta(im);
                l.add(dank);
            }
        }
        return l;
    }

    public static ConfigurationSection getDankSection(long dankID) {
        return DankTech.getInstance().getDankStorageConfig().getConfigurationSection(CONFIG_GETTER_SECTION_DANK_ID + "."  + dankID);
    }

    public static List<String> getWorldBlacklistOpen() {
        return DankTech.getInstance().getConfig().getStringList("GENERAL.BLACKLISTED_WORLDS_OPEN_PACK");
    }

    public static List<String> getWorldBlacklistPlace() {
        return DankTech.getInstance().getConfig().getStringList("GENERAL.BLACKLISTED_WORLDS_BLOCK_PLACEMENT");
    }

    public static List<String> getWorldBlacklistPickup() {
        return DankTech.getInstance().getConfig().getStringList("GENERAL.BLACKLISTED_WORLDS_PICKUP_ITEMS");
    }

    public static boolean isBlacklisted(ItemStack i) {
        ConfigurationSection blacklist = DankTech.getInstance().getItemBlacklistConfig().getConfigurationSection("BLACKLISTED_ITEMS");
        if (blacklist != null) {
            for (String s : blacklist.getKeys(false)) {
                ItemStack blacklistedStack = DankTech.getInstance().getItemBlacklistConfig().getItemStack("BLACKLISTED_ITEMS" + "." + s);
                if (i.isSimilar(blacklistedStack)) {
                    return true;
                }
            }
        }
        return false;
    }

}
