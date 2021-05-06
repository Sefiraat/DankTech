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

    public static Recipe recipeCell1(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(1, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_1");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(1));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell2(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(2, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_2");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(2));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell3(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(3, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_3");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(3));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell4(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(4, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_4");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(4));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell5(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(5, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_5");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(5));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell6(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(6, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_6");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(6));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell7(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(7, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_7");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(7));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell8(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(8, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_8");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(8));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }
    public static Recipe recipeCell9(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(9, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_9");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getCellCraftingMaterial(9));
        r.setIngredient('E', Materials.CELL_CORE_MATERIAL);
        return r;
    }

    public static Recipe recipeDank(DankTech plugin) {
        ItemStack i = new ItemStack(Material.PLAYER_HEAD, 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_All");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.PLAYER_HEAD);
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }

    public static Recipe recipeDank1(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(1), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_1");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.PLAYER_HEAD);
        r.setIngredient('E', Materials.DANK_CORE_MATERIAL);
        return r;
    }

    public static Recipe recipeTrash(DankTech plugin) {
        ItemStack i = new ItemStack(Material.PLAYER_HEAD, 1);
        NamespacedKey key = new NamespacedKey(plugin, "Trash_All");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.PLAYER_HEAD);
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }

    public static Recipe recipeTrash1(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(1), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Trash_1");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.PLAYER_HEAD);
        r.setIngredient('E', Materials.TRASH_CORE_MATERIAL);
        return r;
    }

    public static Recipe recipeDank2(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(2), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_2");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(2));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank3(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(3), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_3");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(3));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank4(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(4), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_4");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(4));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank5(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(5), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_5");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(5));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank6(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(6), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_6");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(6));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank7(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(7), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_7");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(7));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank8(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(8), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_8");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', getDankCellMaterial(8));
        r.setIngredient('E', Material.PLAYER_HEAD);
        return r;
    }
    public static Recipe recipeDank9(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(9), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_9");
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
                    stack, new ItemStack(Materials.DANK_CORE_MATERIAL), stack,
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
                    stack, new ItemStack(Materials.TRASH_CORE_MATERIAL), stack,
                    stack, stack, stack
            };
        }
        return i;
    }

}
