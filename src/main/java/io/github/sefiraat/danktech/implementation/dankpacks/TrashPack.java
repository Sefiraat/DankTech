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

import static io.github.sefiraat.danktech.finals.Constants.*;
import static io.github.sefiraat.danktech.finals.ItemDetails.getTrashNameBold;
import static io.github.sefiraat.danktech.finals.Materials.getTrashTexture;

public class TrashPack {

    private TrashPack() {
        throw new IllegalStateException("Utility class");
    }

    public static ItemStack getTrashPack(@Nonnull Integer level, @Nonnull Long trashID, @Nonnull DankTech parent, @Nullable Player p) {

        ItemStack trash = SkullCreator.itemFromBase64(getTrashTexture(level));

        if (!parent.getInstance().getDankStorageConfig().contains(CONFIG_GETTER_SECTION_TRASH_ID + "." + trashID)) {
            setupSection(parent.getInstance().getDankStorageConfig(), trashID, level);
            parent.saveDankStorageConfig();
        }

        ItemMeta m = trash.getItemMeta();
        m.setDisplayName(getTrashNameBold(parent, level));
        m.setLore(ItemDetails.getTrashLore(parent, level, trashID));
        trash.setItemMeta(m);

        ContainerStorage.makeTrash(trash, parent);
        ContainerStorage.setTrashId(trash, parent, trashID);
        ContainerStorage.setTrashLevel(trash, parent, level);

        if (p!= null) {
            Config.setTrashLastOpenedBy(trashID, parent, p);
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
