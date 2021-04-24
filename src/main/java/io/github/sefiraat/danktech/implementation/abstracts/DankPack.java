package io.github.sefiraat.danktech.implementation.abstracts;

import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

public class DankPack {

    private int level;
    private ConfigurationSection section;
    private List<Material> Materials;
    private List<Long> Amounts;

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

    public DankPack(@Nonnull int level, @Nonnull ConfigurationSection packConfigSection) {
        this.level = level;
        this.section = packConfigSection;
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



}
