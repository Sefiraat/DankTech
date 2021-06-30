package io.github.sefiraat.danktech.misc;

import dev.dbassett.skullcreator.SkullCreator;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemStacks;
import io.github.sefiraat.danktech.finals.Materials;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.recipes.MinecraftRecipe;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.github.sefiraat.danktech.finals.ItemDetails.SLIMEFUN_DISPLAY_CATEGORY_NAME;
import static io.github.sefiraat.danktech.finals.Recipes.getSlimefunCellRecipe;
import static io.github.sefiraat.danktech.finals.Recipes.getSlimefunPackRecipe;
import static io.github.sefiraat.danktech.finals.Recipes.getSlimefunTrashRecipe;

public class SlimefunDankAddon implements SlimefunAddon {

    public SlimefunDankAddon() {

        // Category
        NamespacedKey categoryIdMain = new NamespacedKey(DankTech.getInstance(), "danktech_main");

        ItemStack categoryItemMain = SkullCreator.itemFromBase64(Materials.DANK_SLIMEFUN_CATEGORY);
        ItemMeta im = categoryItemMain.getItemMeta();
        im.setDisplayName(SLIMEFUN_DISPLAY_CATEGORY_NAME);
        im.setLore(Collections.singletonList("&a> Click to open"));
        categoryItemMain.setItemMeta(im);
        Category dankCategory = new Category(categoryIdMain, categoryItemMain);

        // Items
        Utils.dbgMsg("Cells");
        List<SlimefunItemStack> cells =  new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Utils.dbgMsg(" -- " + i);
            SlimefunItemStack dankCellStack = new SlimefunItemStack( "DANK_CELL_" + i, ItemStacks.getCell(i));
            SlimefunItem dankCell = new DankSlimefunItem(dankCategory, dankCellStack, new RecipeType(MinecraftRecipe.SHAPED_CRAFTING), getSlimefunCellRecipe(i));
            dankCell.register(this);
            cells.add(dankCellStack);
        }

        List<SlimefunItemStack> danks = new ArrayList<>();
        Utils.dbgMsg("Dank Packs");
        for (Integer i = 1; i < 10; i++) {
            Utils.dbgMsg(" -- " + i);
            SlimefunItemStack dankPackStack = new SlimefunItemStack( "DANK_PACK_" + i, ItemStacks.getShallowDank(i));
            SlimefunItem dankPack;
            if (i.equals(1)) {
                dankPack = new DankSlimefunItem(dankCategory, dankPackStack, new RecipeType(MinecraftRecipe.SHAPED_CRAFTING), getSlimefunPackRecipe(cells.get(0),null));
            } else {
                dankPack = new DankSlimefunItem(dankCategory, dankPackStack, new RecipeType(MinecraftRecipe.SHAPED_CRAFTING), getSlimefunPackRecipe(cells.get(i - 1), danks.get(i - 2)));
            }
            dankPack.register(this);
            danks.add(dankPackStack);
        }

        List<SlimefunItemStack> trashes = new ArrayList<>();
        Utils.dbgMsg("Trash Packs");
        for (Integer i = 1; i < 10; i++) {
            Utils.dbgMsg(" -- " + i);
            SlimefunItemStack dankTrashStack = new SlimefunItemStack( "DANK_TRASH_" + i, ItemStacks.getShallowTrash(i));
            SlimefunItem trashPack;
            if (i.equals(1)) {
                trashPack = new DankSlimefunItem(dankCategory, dankTrashStack, new RecipeType(MinecraftRecipe.SHAPED_CRAFTING), getSlimefunTrashRecipe(cells.get(0),null));
            } else {
                trashPack = new DankSlimefunItem(dankCategory, dankTrashStack, new RecipeType(MinecraftRecipe.SHAPED_CRAFTING), getSlimefunTrashRecipe(cells.get(i - 1), trashes.get(i - 2)));
            }
            trashPack.register(this);
            trashes.add(dankTrashStack);
        }

    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return DankTech.getInstance();
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return null;
    }
}
