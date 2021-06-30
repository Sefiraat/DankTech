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

import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_SECTION_TRASH_ID;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_LEVEL;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_SLOT;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_STACK;
import static io.github.sefiraat.danktech.finals.Constants.CONFIG_GETTER_VAL_VOLUME;
import static io.github.sefiraat.danktech.finals.ItemDetails.getTrashNameBold;
import static io.github.sefiraat.danktech.finals.Materials.getTrashTexture;

public class TrashPack {

    private TrashPack() {
        throw new IllegalStateException("Utility class");
    }

    public static ItemStack getTrashPack(@Nonnull Integer level, @Nonnull Long trashID, @Nullable Player p) {

        ItemStack trash = SkullCreator.itemFromBase64(getTrashTexture(level));

        if (!DankTech.getInstance().getDankStorageConfig().contains(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID)) {
            setupSection(DankTech.getInstance().getDankStorageConfig(), trashID, level);
            DankTech.getInstance().saveDankStorageConfig();
        }

        ItemMeta m = trash.getItemMeta();
        m.setDisplayName(getTrashNameBold(level));
        m.setLore(ItemDetails.getTrashLore(level, trashID));
        trash.setItemMeta(m);

        ContainerStorage.makeTrash(trash);
        ContainerStorage.setTrashId(trash, trashID);
        ContainerStorage.setTrashLevel(trash, level);

        if (p!= null) {
            Config.setTrashLastOpenedBy(trashID, p);
        }

        return trash;

    }

    private static void setupSection(Configuration config, long trashID, Integer level) {

        config.createSection(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID);
        config.set(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID + "." + CONFIG_GETTER_VAL_LEVEL, level);
        for (int i = 1; i < ((level * 2) + 1); i++) {
            ConfigurationSection c = config.createSection(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID + "." + CONFIG_GETTER_VAL_SLOT + i);
            c.set(CONFIG_GETTER_VAL_STACK, null);
            c.set(CONFIG_GETTER_VAL_VOLUME, 0);
        }

    }



}
