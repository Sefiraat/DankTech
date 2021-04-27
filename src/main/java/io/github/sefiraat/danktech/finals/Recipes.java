package io.github.sefiraat.danktech.finals;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public final class Recipes {
    public static Recipe recipeCell1(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(1, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_1");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.IRON_INGOT);
        r.setIngredient('E', Material.GLASS_PANE);
        return r;
    }
    public static Recipe recipeCell2(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(2, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_2");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.GOLD_INGOT);
        r.setIngredient('E', Material.GLASS_PANE);
        return r;
    }
    public static Recipe recipeCell3(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(3, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_3");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.IRON_BLOCK);
        r.setIngredient('E', Material.GLASS_PANE);
        return r;
    }
    public static Recipe recipeCell4(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(4, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_4");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.GOLD_BLOCK);
        r.setIngredient('E', Material.GLASS_PANE);
        return r;
    }
    public static Recipe recipeCell5(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(5, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_5");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.DIAMOND);
        r.setIngredient('E', Material.GLASS_PANE);
        return r;
    }
    public static Recipe recipeCell6(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(6, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_6");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.DIAMOND_BLOCK);
        r.setIngredient('E', Material.GLASS_PANE);
        return r;
    }
    public static Recipe recipeCell7(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(7, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_7");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.EMERALD);
        r.setIngredient('E', Material.GLASS_PANE);
        return r;
    }
    public static Recipe recipeCell8(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(8, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_8");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.EMERALD_BLOCK);
        r.setIngredient('E', Material.GLASS_PANE);
        return r;
    }
    public static Recipe recipeCell9(DankTech plugin) {
        ItemStack i = ItemStacks.getCell(9, plugin).clone();
        NamespacedKey key = new NamespacedKey(plugin, "Cell_9");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Material.NETHER_STAR);
        r.setIngredient('E', Material.GLASS_PANE);
        return r;
    }

    public static Recipe recipeDank1(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(1), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_1");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Materials.getDankCellMaterial(1));
        r.setIngredient('E', Material.DRAGON_EGG);
        return r;
    }

    public static Recipe recipeDank2(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(2), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_2");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Materials.getDankCellMaterial(2));
        r.setIngredient('E', Materials.getDankMaterial(1));
        return r;
    }
    public static Recipe recipeDank3(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(3), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_3");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Materials.getDankCellMaterial(3));
        r.setIngredient('E', Materials.getDankMaterial(2));
        return r;
    }
    public static Recipe recipeDank4(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(4), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_4");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Materials.getDankCellMaterial(4));
        r.setIngredient('E', Materials.getDankMaterial(3));
        return r;
    }
    public static Recipe recipeDank5(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(5), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_5");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Materials.getDankCellMaterial(5));
        r.setIngredient('E', Materials.getDankMaterial(4));
        return r;
    }
    public static Recipe recipeDank6(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(6), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_6");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Materials.getDankCellMaterial(6));
        r.setIngredient('E', Materials.getDankMaterial(5));
        return r;
    }
    public static Recipe recipeDank7(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(7), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_7");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Materials.getDankCellMaterial(7));
        r.setIngredient('E', Materials.getDankMaterial(6));
        return r;
    }
    public static Recipe recipeDank8(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(8), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_8");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Materials.getDankCellMaterial(8));
        r.setIngredient('E', Materials.getDankMaterial(7));
        return r;
    }
    public static Recipe recipeDank9(DankTech plugin) {
        ItemStack i = new ItemStack(Materials.getDankMaterial(9), 1);
        NamespacedKey key = new NamespacedKey(plugin, "Dank_9");
        ShapedRecipe r = new ShapedRecipe(key, i);
        r.shape("NNN","NEN","NNN");
        r.setIngredient('N', Materials.getDankCellMaterial(9));
        r.setIngredient('E', Materials.getDankMaterial(8));
        return r;
    }


}
