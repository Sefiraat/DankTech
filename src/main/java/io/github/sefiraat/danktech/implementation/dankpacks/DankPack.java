package io.github.sefiraat.danktech.implementation.dankpacks;

import dev.dbassett.skullcreator.SkullCreator;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.misc.Config;
import io.github.sefiraat.danktech.misc.ContainerStorage;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_DANK_ID;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_LEVEL;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_SLOT;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_STACK;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_VOLUME;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.Materials.getDankTexture;

public class DankPack {

    private DankPack() {
        throw new IllegalStateException("Utility class");
    }

    public static ItemStack getDankPack(@Nonnull Integer level, @Nonnull Long packID, @Nullable Player player) {

        ItemStack dank = SkullCreator.itemFromBase64(getDankTexture(level));
        if (!DankTech.getInstance().getDankStorageConfig().contains(CONFIG_GETTER_SECTION_DANK_ID + "." + packID)) {
            setupSection(DankTech.getInstance().getDankStorageConfig(), packID, level);
            DankTech.getInstance().saveDankStorageConfig();
        }

        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        m.setLore(ItemDetails.getDankLore(level, packID, null));
        dank.setItemMeta(m);

        ContainerStorage.makeDank(dank);
        ContainerStorage.setDankId(dank, packID);
        ContainerStorage.setDankLevel(dank, level);

        if (player!= null) {
            Config.setDankLastOpenedBy(packID, player);
        }

        return dank;
    }

    private static void setupSection(Configuration config, long packID, Integer level) {

        config.createSection(CONFIG_GETTER_SECTION_DANK_ID + "." + packID);
        config.set(CONFIG_GETTER_SECTION_DANK_ID + "." + packID + "." + CONFIG_GETTER_VAL_LEVEL, level);

        for (int i = 1; i < (level + 1); i++) {
            if (level >= 1) {
                ConfigurationSection c = config.createSection(CONFIG_GETTER_SECTION_DANK_ID + "." + packID + "." + CONFIG_GETTER_VAL_SLOT + i);
                c.set(CONFIG_GETTER_VAL_STACK, null);
                c.set(CONFIG_GETTER_VAL_VOLUME, 0);
            }
        }
    }
}
