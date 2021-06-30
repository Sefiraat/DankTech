package io.github.sefiraat.danktech.finals;

import io.github.sefiraat.danktech.DankTech;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

import javax.annotation.Nullable;

import static io.github.sefiraat.danktech.finals.Materials.getDankCellMaterial;

public final class Recipes {

    private Recipes() {
        throw new IllegalStateException("Utility class");
    }

    public static Material getCellCraftingMaterial(Integer level) {
        switch (level) {
            case 1: return Material.IRON_INGOT;
            case 2: return Material.GOLD_INGOT;
            case 3: return Material.IRON_BLOCK;
            case 4: return Material.GOLD_BLOCK;
            case 5: return Material.DIAMOND;
            case 6: return Material.EMERALD;
            case 7: return Material.DIAMOND_BLOCK;
            case 8: return Material.EMERALD_BLOCK;
            default: return Material.NETHER_STAR;
        }
    }

    public static Recipe recipeCell1() {
        ItemStack i = ItemStacks.getCell(1).clone();
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Cell_1");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(1));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell2() {
        ItemStack i = ItemStacks.getCell(2).clone();
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Cell_2");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(2));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell3() {
        ItemStack i = ItemStacks.getCell(3).clone();
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Cell_3");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(3));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell4() {
        ItemStack i = ItemStacks.getCell(4).clone();
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Cell_4");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(4));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell5() {
        ItemStack i = ItemStacks.getCell(5).clone();
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Cell_5");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(5));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell6() {
        ItemStack i = ItemStacks.getCell(6).clone();
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Cell_6");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(6));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell7() {
        ItemStack i = ItemStacks.getCell(7).clone();
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Cell_7");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(7));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell8() {
        ItemStack i = ItemStacks.getCell(8).clone();
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Cell_8");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(8));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell9() {
        ItemStack i = ItemStacks.getCell(9).clone();
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Cell_9");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(9));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }

    public static Recipe recipeDank() {
        ItemStack i = new ItemStack(Material.PLAYER_HEAD, 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Dank_All");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.PLAYER_HEAD);
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }

    public static Recipe recipeDank1() {
        ItemStack i = new ItemStack(Materials.getDankMaterial(1), 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Dank_1");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.PLAYER_HEAD);
        r.setIngredient('E', Materials.DANK_T1_CORE_MATERIAL);
        return r;
    }

    public static Recipe recipeTrash() {
        ItemStack i = new ItemStack(Material.PLAYER_HEAD, 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Trash_All");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.PLAYER_HEAD);
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }

    public static Recipe recipeTrash1() {
        ItemStack i = new ItemStack(Materials.getDankMaterial(1), 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Trash_1");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.PLAYER_HEAD);
        r.setIngredient('E', Materials.TRASH_T1_CORE_MATERIAL);
        return r;
    }

    public static Recipe recipeDank2() {
        ItemStack i = new ItemStack(Materials.getDankMaterial(2), 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Dank_2");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(2));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank3() {
        ItemStack i = new ItemStack(Materials.getDankMaterial(3), 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Dank_3");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(3));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank4() {
        ItemStack i = new ItemStack(Materials.getDankMaterial(4), 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Dank_4");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(4));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank5() {
        ItemStack i = new ItemStack(Materials.getDankMaterial(5), 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Dank_5");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(5));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank6() {
        ItemStack i = new ItemStack(Materials.getDankMaterial(6), 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Dank_6");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(6));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank7() {
        ItemStack i = new ItemStack(Materials.getDankMaterial(7), 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Dank_7");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(7));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank8() {
        ItemStack i = new ItemStack(Materials.getDankMaterial(8), 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Dank_8");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(8));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank9() {
        ItemStack i = new ItemStack(Materials.getDankMaterial(9), 1);
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Dank_9");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(9));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }

    public static ItemStack[] getSlimefunCellRecipe(Integer level) {
        return new ItemStack[] {
            new ItemStack(getCellCraftingMaterial(level)), new ItemStack(getCellCraftingMaterial(level)),     new ItemStack(getCellCraftingMaterial(level)),
            new ItemStack(getCellCraftingMaterial(level)), new ItemStack(Materials.CELL_CORE_MATERIAL),                 new ItemStack(getCellCraftingMaterial(level)),
            new ItemStack(getCellCraftingMaterial(level)), new ItemStack(getCellCraftingMaterial(level)),     new ItemStack(getCellCraftingMaterial(level))
        };
    }

    public static ItemStack[] getSlimefunPackRecipe(SlimefunItemStack stack, @Nullable SlimefunItemStack core) {
        ItemStack[] i;
        if (core != null) {
            i = new ItemStack[]{
                    stack, stack, stack,
                    stack, core, stack,
                    stack, stack, stack
            };
        } else {
            i = new ItemStack[]{
                    stack, stack, stack,
                    stack, new ItemStack(Materials.DANK_T1_CORE_MATERIAL), stack,
                    stack, stack, stack
            };
        }
        return i;
    }

    public static ItemStack[] getSlimefunTrashRecipe(SlimefunItemStack stack, @Nullable SlimefunItemStack core) {
        ItemStack[] i;
        if (core != null) {
            i = new ItemStack[]{
                    stack, stack, stack,
                    stack, core, stack,
                    stack, stack, stack
            };
        } else {
            i = new ItemStack[]{
                    stack, stack, stack,
                    stack, new ItemStack(Materials.TRASH_T1_CORE_MATERIAL), stack,
                    stack, stack, stack
            };
        }
        return i;
    }

    public static Recipe recipeUpgradeRange() {
        ItemStack i = ItemStacks.getCell(1).clone();
        NamespacedKey key = new NamespacedKey(DankTech.getInstance(), "Cell_1");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NSN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(1));
        r.setIngredient('S', Material.NETHER_STAR);
        return r;
    }

}
