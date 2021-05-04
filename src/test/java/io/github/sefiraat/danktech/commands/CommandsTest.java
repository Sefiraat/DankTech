package io.github.sefiraat.danktech.commands;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import io.github.sefiraat.danktech.DankTech;
import io.github.sefiraat.danktech.finals.ItemDetails;
import io.github.sefiraat.danktech.implementation.abstracts.DankPack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.junit.jupiter.api.*;

import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.Materials.getDankMaterial;
import static io.github.sefiraat.danktech.lib.misc.Utils.*;

public class CommandsTest {

    private static ServerMock server;
    private static DankTech plugin;
    private static PlayerMock playerOp;
    private static PlayerMock playerNormal;

    @BeforeAll
    public static void setUp()
    {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(DankTech.class);
        server.addSimpleWorld("world");
        playerOp = server.addPlayer();
        playerOp.setOp(true);
        playerOp.setName("op");
        playerNormal = server.addPlayer();
    }

    @AfterAll
    public static void tearDown()
    {
        MockBukkit.unmock();
    }

    private Integer testDankLevel(Player player) {
        for (ItemStack item : player.getInventory()) {
            if (isDank(item,plugin)) {
                return getDankLevel(item, plugin);
            }
        }
        return 0;
    }

    private void givePack(Player p, Integer level) {
        long packID = getNextPackID(plugin);
        DankPack dank = new DankPack(getDankMaterial(level), level, packID, plugin, p.getPlayer());
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        m.setLore(ItemDetails.getDankLore(level, packID, null));
        dank.setItemMeta(m);
        p.getPlayer().getInventory().addItem(dank);
    }

    @Test
    @DisplayName("Give Danks")
    public void testGiveDank() {
        boolean b = true;
        for (int i = 1; i < 10; i++) {
            givePack(playerOp, i);
            boolean dankValid = testDankLevel(playerOp) == i;
            server.getLogger().info("Testing pack " + i + ": " + dankValid);
            playerOp.getInventory().clear();
            if (!dankValid) { b = false; }
        }
        Assertions.assertTrue(b);
    }

}
