package io.github.sefiraat.danktech.finals;

import org.bukkit.Material;

public final class Materials {

    private Materials() {
        throw new IllegalStateException("Utility class");
    }

    public static final Material DANK_ERR = Material.BARRIER;

    public static final Material DANK_1 = Material.GRAY_STAINED_GLASS;
    public static final Material DANK_2 = Material.BLACK_STAINED_GLASS;
    public static final Material DANK_3 = Material.LIME_STAINED_GLASS;
    public static final Material DANK_4 = Material.GREEN_STAINED_GLASS;
    public static final Material DANK_5 = Material.LIGHT_BLUE_STAINED_GLASS;
    public static final Material DANK_6 = Material.BLUE_STAINED_GLASS;
    public static final Material DANK_7 = Material.PINK_STAINED_GLASS;
    public static final Material DANK_8 = Material.PURPLE_STAINED_GLASS;
    public static final Material DANK_9 = Material.RED_STAINED_GLASS;

    public static Material getDankMaterial(int dankLevel) {
        switch (dankLevel) {
            case 1: return DANK_1;
            case 2: return DANK_2;
            case 3: return DANK_3;
            case 4: return DANK_4;
            case 5: return DANK_5;
            case 6: return DANK_6;
            case 7: return DANK_7;
            case 8: return DANK_8;
            case 9: return DANK_9;
            default: return DANK_ERR;
        }
    }

    public static final Material DANK_CELL_1 = Material.GRAY_STAINED_GLASS_PANE;
    public static final Material DANK_CELL_2 = Material.BLACK_STAINED_GLASS_PANE;
    public static final Material DANK_CELL_3 = Material.LIME_STAINED_GLASS_PANE;
    public static final Material DANK_CELL_4 = Material.GREEN_STAINED_GLASS_PANE;
    public static final Material DANK_CELL_5 = Material.LIGHT_BLUE_STAINED_GLASS_PANE;
    public static final Material DANK_CELL_6 = Material.BLUE_STAINED_GLASS_PANE;
    public static final Material DANK_CELL_7 = Material.PINK_STAINED_GLASS_PANE;
    public static final Material DANK_CELL_8 = Material.PURPLE_STAINED_GLASS_PANE;
    public static final Material DANK_CELL_9 = Material.RED_STAINED_GLASS_PANE;

    public static Material getDankCellMaterial(int dankLevel) {
        switch (dankLevel) {
            case 1: return DANK_CELL_1;
            case 2: return DANK_CELL_2;
            case 3: return DANK_CELL_3;
            case 4: return DANK_CELL_4;
            case 5: return DANK_CELL_5;
            case 6: return DANK_CELL_6;
            case 7: return DANK_CELL_7;
            case 8: return DANK_CELL_8;
            case 9: return DANK_CELL_9;
            default: return DANK_ERR;
        }
    }

}
