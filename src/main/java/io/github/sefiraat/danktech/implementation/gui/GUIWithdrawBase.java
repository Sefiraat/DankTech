package io.github.sefiraat.danktech.implementation.gui;

import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.StorageGui;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class GUIWithdrawBase {
    private final Player player;
    private final ConfigurationSection slotSection;
    private final Gui gui;
    private final long dankID;

    public Player getPlayer() {
        return player;
    }

    public ConfigurationSection getSlotSection() {
        return slotSection;
    }

    public Gui getGui() {
        return gui;
    }

    public long getDankID() {
        return dankID;
    }

    public GUIWithdrawBase(Player player, ConfigurationSection slotSection, Gui gui, long dankID) {
        this.player = player;
        this.slotSection = slotSection;
        this.gui = gui;
        this.dankID = dankID;
    }
}
