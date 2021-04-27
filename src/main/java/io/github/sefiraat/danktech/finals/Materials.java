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

    public static final Material DankCell1 = Material.LIGHT_GRAY_STAINED_GLASS_PANE;
    public static final Material DankCell2 = Material.GRAY_STAINED_GLASS_PANE;
    public static final Material DankCell3 = Material.LIME_STAINED_GLASS_PANE;
    public static final Material DankCell4 = Material.GREEN_STAINED_GLASS_PANE;
    public static final Material DankCell5 = Material.LIGHT_BLUE_STAINED_GLASS_PANE;
    public static final Material DankCell6 = Material.BLUE_STAINED_GLASS_PANE;
    public static final Material DankCell7 = Material.PINK_STAINED_GLASS_PANE;
    public static final Material DankCell8 = Material.PURPLE_STAINED_GLASS_PANE;
    public static final Material DankCell9 = Material.RED_STAINED_GLASS_PANE;

    public static Material getDankCellMaterial(int DankLevel) {
        switch (DankLevel) {
            case 1: return DankCell1;
            case 2: return DankCell2;
            case 3: return DankCell3;
            case 4: return DankCell4;
            case 5: return DankCell5;
            case 6: return DankCell6;
            case 7: return DankCell7;
            case 8: return DankCell8;
            case 9: return DankCell9;
            default: return Error;
        }
    }

}
