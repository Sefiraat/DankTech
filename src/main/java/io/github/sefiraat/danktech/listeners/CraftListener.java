package io.github.sefiraat.danktech.listeners;

import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.finals.ItemStacks;
import io.github.sefiraat.danktech.finals.Materials;
import io.github.sefiraat.danktech.finals.Messages;
import io.github.sefiraat.danktech.implementation.abstracts.DankPack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;

import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.Materials.getDankMaterial;
import static io.github.sefiraat.danktech.lib.misc.Utils.getNextPackID;

public class CraftListener implements Listener {

    final DankTech Parent;

    public CraftListener(@Nonnull DankTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        Parent = plugin;
    }

    @EventHandler
    public void onPreCraft(PrepareItemCraftEvent e) {
        if (e.getView().getPlayer() instanceof Player) {
            if (e.getRecipe() != null && e.getRecipe().getResult() != null) {
                ItemStack res = e.getRecipe().getResult();
                if (isResultDank(res.getType())) {

                    ItemStack[] Contents = e.getInventory().getMatrix();
                    boolean isNew = false;
                    int[] slots = {0, 1, 2, 3, 5, 6, 7, 8};
                    boolean itemsCorrect = true;
                    int dankLevel = 1;
                    long dankID = -1;

                    if (res.getType() == Materials.Dank1) {
                        isNew = true;
                    }

                    for (int i : slots) {
                        NamespacedKey key = new NamespacedKey(Parent, "dank");
                        if (Contents[i].getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.INTEGER)) {
                        } else {
                            itemsCorrect = false;
                        }
                    }

                    if (!isNew) {
                        NamespacedKey levelKey = new NamespacedKey(Parent.getInstance(),"dank-level");
                        NamespacedKey idKey = new NamespacedKey(Parent.getInstance(),"dank-id");
                        if (Contents[4].getItemMeta().getPersistentDataContainer().has(levelKey, PersistentDataType.INTEGER)) {
                            dankLevel = Contents[4].getItemMeta().getPersistentDataContainer().get(levelKey, PersistentDataType.INTEGER) + 1;
                            dankID = Contents[4].getItemMeta().getPersistentDataContainer().get(idKey, PersistentDataType.LONG);
                        } else {
                            itemsCorrect = false;
                        }
                    }

                    if (itemsCorrect) {
                        NamespacedKey key = new NamespacedKey(Parent.getInstance(),"dank-level");
                        NamespacedKey idKey = new NamespacedKey(Parent.getInstance(),"dank-id");
                        ItemStack r = ItemStacks.getShallowDank(dankLevel);
                        ItemMeta im = r.getItemMeta();
                        im.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, dankLevel);
                        im.getPersistentDataContainer().set(idKey, PersistentDataType.LONG, dankID);
                        r.setItemMeta(im);
                        e.getInventory().setResult(r);
                    } else {
                        e.getInventory().setResult(new ItemStack(Material.AIR));
                    }

                }
            }
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (e.getView().getPlayer() instanceof Player) {
            Player p = (Player) e.getView().getPlayer();
            if (e.getRecipe() != null && e.getRecipe().getResult() != null) {
                NamespacedKey key = new NamespacedKey(Parent.getInstance(),"dank-level");
                ItemStack res = e.getCurrentItem();
                boolean isDank = isResultDank(res.getType());
                boolean hasKey = res.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.INTEGER);
                if (isDank && hasKey) {
                    int level = res.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
                    if (level == 1) {
                        long packID = getNextPackID(Parent);
                        DankPack Dank = new DankPack(getDankMaterial(level), level, packID, Parent);
                        ItemMeta m = Dank.getItemMeta();
                        m.setDisplayName(getDankNameBold(level));
                        m.setLore(ItemDetails.getDankLore(level, packID, null));
                        Dank.setItemMeta(m);
                        e.setCurrentItem(Dank);
                        p.sendMessage(Messages.MessageCraftNewPack);
                    } else {
                        NamespacedKey idKey = new NamespacedKey(Parent.getInstance(),"dank-id");
                        long packID = res.getItemMeta().getPersistentDataContainer().get(idKey, PersistentDataType.LONG);
                        ConfigurationSection c = Parent.getDankStorageConfig().getConfigurationSection("PACKS.PACKS_BY_ID." + packID);
                        c.set("LEVEL",level);
                        c.set("SLOT" + level + ".STACK", null);
                        c.set("SLOT" + level + ".VOLUME", 0);
                        DankPack Dank = new DankPack(getDankMaterial(level), level, packID, Parent);
                        ItemMeta m = Dank.getItemMeta();
                        m.setDisplayName(getDankNameBold(level));
                        m.setLore(ItemDetails.getDankLore(level, packID, null));
                        Dank.setItemMeta(m);
                        e.setCurrentItem(Dank);
                        p.sendMessage(Messages.MessageCraftUpgradePack);
                    }
                }
            }
        }
    }

    public boolean isResultDank(Material m) {
        return m == Materials.Dank1 ||
                m == Materials.Dank2 ||
                m == Materials.Dank3 ||
                m == Materials.Dank4 ||
                m == Materials.Dank5 ||
                m == Materials.Dank6 ||
                m == Materials.Dank7 ||
                m == Materials.Dank8 ||
                m == Materials.Dank9;
    }

}
