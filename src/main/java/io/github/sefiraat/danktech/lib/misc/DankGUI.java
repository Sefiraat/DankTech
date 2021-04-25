package io.github.sefiraat.danktech.lib.misc;

import io.github.sefiraat.danktech.finals.GUIItems;
import me.mattstudios.mfgui.gui.guis.Gui;

import java.util.Arrays;
import java.util.List;

import static io.github.sefiraat.danktech.finals.ItemDetails.getDankName;

public class DankGUI {

    public static Gui getDankGUI(long DankID, int dankLevel) {

        Integer[] arrayFillerSlots = new Integer[]{0, 1, 2, 3, 5, 6, 7, 8, 36, 37, 38, 39, 40, 41, 42, 43, 44};
        List<Integer> listFillerSlots = (List<Integer>) Arrays.asList(arrayFillerSlots);


        Gui g = new Gui(5, getDankName(dankLevel));
        g.setDefaultClickAction(event -> {event.setCancelled(true);});

        g.setItem(listFillerSlots, GUIItems.GUIPackFiller());
        g.setItem(4, GUIItems.GUIPackInfo(DankID, dankLevel));

        if (dankLevel < 9) {
            setBlankColumns(g, dankLevel);
        }

        return g;
    }

    public static void setBlankColumns(Gui gui, int dankLevel) {
        for (int i = (dankLevel + 1); i <= 9; i++) {
            gui.setItem(2, i, GUIItems.GUIPackLockedSlot());
            gui.setItem(3, i, GUIItems.GUIPackLockedSlot());
            gui.setItem(4, i, GUIItems.GUIPackLockedSlot());
        }
    }
}
