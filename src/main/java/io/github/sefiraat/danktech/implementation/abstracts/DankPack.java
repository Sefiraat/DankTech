package io.github.sefiraat.danktech.implementation.abstracts;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static io.github.sefiraat.danktech.lib.misc.Utils.*;

public class DankPack extends ItemStack {

    private final int level;
    private ConfigurationSection section;

    public int getLevel() {
        return level;
    }

    public int getSlots() {
        return level * 3;
    }

    public boolean slotIsUsed(String slot) {
        return section.contains(slot + ".STACK");
    }

    public DankPack(@Nonnull Material material, @Nonnull Integer level, @Nonnull Long packID, @Nonnull DankTech parent, @Nullable Player p) {
        super(material);
        this.level = level;

        if (parent.getInstance().getDankStorageConfig().contains("PACKS.PACKS_BY_ID." + packID)) {
            this.section = parent.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + packID);
        } else {
            setupSection(parent.getInstance().getDankStorageConfig(), packID);
            parent.saveDankStorageConfig();
        }

        makeDank(this, parent);
        setDankId(this, parent, packID);
        setDankLevel(this, parent, this.level);

        if (p!= null) {
            setLastOpenedBy(packID, parent, p);
        }

    }

    private void setupSection(Configuration config, long packID) {
        config.createSection("PACKS.PACKS_BY_ID." + packID);
        config.set("PACKS.PACKS_BY_ID." + packID + ".LEVEL", level);
        if (level >= 1) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT1");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        }
        if (level >= 2) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT2");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        }
        if (level >= 3) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT3");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        }
        if (level >= 4) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT4");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        }
        if (level >= 5) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT5");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        }
        if (level >= 6) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT6");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        }
        if (level >= 7) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT7");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        }
        if (level >= 8) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT8");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        }
        if (level >= 9) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT9");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        }
    }



}
