package io.github.sefiraat.danktech.implementation.dankpacks;

import dev.dbassett.skullcreator.SkullCreator;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.misc.Config;
import io.github.sefiraat.danktech.misc.ContainerStorage;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static io.github.sefiraat.danktech.finals.Constants.*;
import static io.github.sefiraat.danktech.finals.Materials.getTrashTexture;

public class TrashPack {

    private TrashPack() {
        throw new IllegalStateException("Utility class");
    }

    public static ItemStack getTrashPack(@Nonnull Integer level, @Nonnull Long trashID, @Nonnull DankTech parent, @Nullable Player p) {

        ItemStack dank = SkullCreator.itemFromBase64(getTrashTexture(level));

        if (!parent.getInstance().getDankStorageConfig().contains(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID)) {
            setupSection(parent.getInstance().getDankStorageConfig(), trashID, level);
            parent.saveDankStorageConfig();
        }

        ContainerStorage.makeTrash(dank, parent);
        ContainerStorage.setTrashId(dank, parent, trashID);
        ContainerStorage.setTrashLevel(dank, parent, level);

        if (p!= null) {
            Config.setLastOpenedBy(trashID, parent, p);
        }

        return dank;

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
