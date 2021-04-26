package io.github.sefiraat.danktech.implementation.abstracts;

import io.github.sefiraat.danktech.DankTech;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

import static io.github.sefiraat.danktech.lib.misc.Utils.*;

public class DankPack extends ItemStack {

    private int level;
    private long packID;
    private ConfigurationSection section;
    private List<Material> Materials;
    private List<Long> Amounts;
    private DankTech Parent;

    public int getLevel() {
        return level;
    }

    public int getSlots() {
        return level * 3;
    }

    public boolean slotIsUsed(String slot) {
        if (section.contains(slot + ".STACK")) {
            return true;
        } else {
            return false;
        }
    }

    public List<Material> getMaterials() {
        return Materials;
    }

    public List<Long> getAmounts() {
        return Amounts;
    }

    public DankPack(@Nonnull Material material, @Nonnull int level, @Nonnull long packID, @Nonnull DankTech parent) {
        super(material);
        this.level = level;
        this.Parent = parent;
        this.packID = packID;

        if (Parent.getInstance().getDankStorageConfig().contains("PACKS.PACKS_BY_ID." + this.packID)) {
            this.section = Parent.getInstance().getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + this.packID);
        } else {
            setupSection(Parent.getInstance().getDankStorageConfig(), this.packID);
            Parent.saveDankStorageConfig();
        }

        makeDank(this, parent);
        setDankId(this, parent, this.packID);
        setDankLevel(this, parent, this.level);
    }

    public void displayPack() {
        Gui GUI = new Gui(5, "Dank Storage Pack");
        for (int i = 1; i < 9; i++) {
            Material m = getMaterials().get(i);
            Long Amount = getAmounts().get(i);
            int finalI = i;
            GuiItem guiItem = new GuiItem(new ItemStack(Material.BARRIER), event -> {
                clickDisplayItem(finalI);
            });
        }
    }

    @EventHandler
    private void clickDisplayItem(int slot) {
        //TODO
    }

    private void setupSection(Configuration config, long packID) {
        config.createSection("PACKS.PACKS_BY_ID." + packID);
        config.createSection("PACKS.PACKS_BY_ID." + packID + ".LEVEL" + level);
        if (level >= 1) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT1");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        };
        if (level >= 2) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT2");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        };
        if (level >= 3) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT3");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        };
        if (level >= 4) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT4");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        };
        if (level >= 5) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT5");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        };
        if (level >= 6) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT6");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        };
        if (level >= 7) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT7");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        };
        if (level >= 8) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT8");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        };
        if (level >= 9) {
            ConfigurationSection c = config.createSection("PACKS.PACKS_BY_ID." + packID + ".SLOT9");
            c.set("STACK", null);
            c.set("VOLUME", 0);
        };
    }



}
