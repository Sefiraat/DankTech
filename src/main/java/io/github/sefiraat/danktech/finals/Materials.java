package io.github.sefiraat.danktech.finals;

import org.bukkit.Material;

public final class Materials {

    public static final Material Error = Material.BARRIER;

    public static final Material Dank1 = Material.LIGHT_GRAY_STAINED_GLASS;
    public static final Material Dank2 = Material.GRAY_STAINED_GLASS;
    public static final Material Dank3 = Material.LIME_STAINED_GLASS;
    public static final Material Dank4 = Material.GREEN_STAINED_GLASS;
    public static final Material Dank5 = Material.LIGHT_BLUE_STAINED_GLASS;
    public static final Material Dank6 = Material.BLUE_STAINED_GLASS;
    public static final Material Dank7 = Material.PINK_STAINED_GLASS;
    public static final Material Dank8 = Material.PURPLE_STAINED_GLASS;
    public static final Material Dank9 = Material.RED_STAINED_GLASS;

    public static Material getDankMaterial(int DankLevel) {
        switch (DankLevel) {
            case 1: return Dank1;
            case 2: return Dank2;
            case 3: return Dank3;
            case 4: return Dank4;
            case 5: return Dank5;
            case 6: return Dank6;
            case 7: return Dank7;
            case 8: return Dank8;
            case 9: return Dank9;
            default: return Error;
        }
    }
}
